package medium;

/**
 * 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
 * 
 * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
 * 
 * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连。
 * 
 * 返回矩阵中 省份 的数量。
 */
public class LeetCode547 {

    /**
     * 并查集,求连通分量
     */
    public int findCircleNum(int[][] isConnected) {
        if (isConnected.length == 0) {
            return 0;
        }
        int[] parent = new int[isConnected.length];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = i + 1; j < isConnected.length; j++) {
                if (isConnected[i][j] == 1) {
                    union(parent, i, j);
                }
            }
        }
        int num = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (parent[i] == i) {
                num++;
            }
        }

        return num;
    }


    public void union(int[] parent, int index1, int index2) {
        parent[find(parent,index1)] = find(parent,index2);
    }

    public int find(int[] parent, int index) {
        while (index != parent[index]) {
            parent[index] = parent[parent[index]];
            index = parent[index];
        }
        return index;
    }

    public static void main(String[] args) {

    }
}
