package medium;

public class LeetCode261 {

    //TODO::
    static class Solution1 {
        public boolean validTree(int n, int[][] edges) {
            //init
            int[] parent = new int[n];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
            //union
            for (int[] edge : edges) {
                union(parent, edge[0], edge[1]);
            }
            return true;
        }

        private void union(int[] parent, int index1, int index2) {
            parent[find(parent, index1)] = find(parent, index2);
        }

        private int find(int[] parent, int index1) {
            while (index1 != parent[index1]) {
                parent[index1] = parent[parent[index1]];
                index1 = parent[index1];
            }
            return index1;
        }

    }


    public static void main(String[] args) {
        int edges1[][] = new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        Solution1 solution1 = new Solution1();
        boolean res = solution1.validTree(5, edges1);
        System.out.println(res);
    }
}
