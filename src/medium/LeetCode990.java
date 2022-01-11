package medium;

/**
 * https://leetcode-cn.com/problems/satisfiability-of-equality-equations/
 */
public class LeetCode990 {


    public boolean equationsPossible(String[] equations) {
        int[] uf = new int[26];
        for (int i = 0; i < 26; i++) {
            uf[i] = i;
        }
        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                int a = equation.charAt(0) - 'a';
                int b = equation.charAt(3) - 'a';
                union(uf, a, b);
            }
        }
        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                int a = equation.charAt(0) - 'a';
                int b = equation.charAt(3) - 'a';
                if (connect(uf, a, b)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }

    public int find(int[] parent, int index) {
        while (parent[index] != index) {
            parent[index] = parent[parent[index]];
            index = parent[index];
        }
        return index;
    }

    public boolean connect(int[] parent, int index1, int index2) {
        return find(parent, index1) == find(parent, index2);
    }



    public static void main(String[] args) {

    }
}
