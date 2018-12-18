package easy;

import DataStructure.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 653. Two Sum IV - Input is a BST
 * .
 * Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.
 * .
 * Example 1:
 * .
 * Input:
 * 5
 * / \
 * 3   6
 * / \   \
 * 2   4   7
 * .
 * Target = 9
 * .
 * Output: True
 * Example 2:
 * .
 * Input:
 * 5
 * / \
 * 3   6
 * / \   \
 * 2   4   7
 * .
 * Target = 28
 * .
 * Output: False
 */
public class LeetCode653 {



    /**
     * DFS
     *
     * @param root
     * @param k
     * @return
     */
    public static boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return DFS(root, set, k);
    }

    public static Boolean DFS(TreeNode root, Set<Integer> set, int k) {
        if (root == null) {
            return false;
        }
        if (set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);
        return DFS(root, set, k);
    }

    public static void main(String[] args) {

    }
}
