package medium;

import DataStructure.TreeNode;

/**
 * 938. Range Sum of BST
 * .
 * Given the root node of a binary search tree, return the sum of values of all nodes with value between L and R (inclusive).
 * .
 * The binary search tree is guaranteed to have unique values.
 * .
 * .
 * .
 * Example 1:
 * .
 * Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
 * Output: 32
 * Example 2:
 * .
 * Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
 * Output: 23
 * .
 * code from https://leetcode.com/problems/range-sum-of-bst/discuss/192019/Java-3-recursive-methods-with-comment.
 */
public class LeetCode938 {
    /**
     * Solution_1
     *
     * @param root
     * @param L
     * @param R
     * @return
     */
    public static int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }
        if (root.val < L) {
            return rangeSumBST(root.right, L, R);
        }
        if (root.val > R) {
            return rangeSumBST(root.left, L, R);
        }
        return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
    }

    /**
     * solution_2
     *
     * @param root
     * @param L
     * @param R
     * @return
     */
    public static int rangeSumBST_(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }
        return (L <= root.left.val && root.right.val < R ? root.val : 0) + rangeSumBST_(root.left, L, R) + rangeSumBST_(root.right, L, R);

    }

    public static int rangeSumBST__(TreeNode root, int L, int R) {
        if (root == null)
            return 0;
        int sum = 0;
        if (root.val > L)
            sum += rangeSumBST__(root.left, L, R);// left child is a possible candidate.
        if (root.val < R)
            sum += rangeSumBST__(root.right, L, R);// right child is a possible candidate.
        if (root.val >= L && root.val <= R)
            sum += root.val;
        return sum;
    }

    public static void main(String[] args) {

    }
}
