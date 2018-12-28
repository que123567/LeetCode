package easy;

import DataStructure.TreeNode;

/**
 * 101. Symmetric Tree
 * <p>
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * <p>
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * But the following [1,2,2,null,3,null,3] is not:
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 */
public class LeetCode101 {
    /**
     * Iterarion
     */
    class SolutionI {
        public boolean isSymmetric(TreeNode root) {
            return root == null || isSymmetricRe(root.left, root.right);

        }

        public boolean isSymmetricRe(TreeNode left, TreeNode right) {
            if (left == null || right == null) {
                return left == right;
            }
            if (left.val != right.val) {
                return false;
            }
            return isSymmetricRe(left.left, right.right) && isSymmetricRe(left.right, right.left);
        }

    }

    /**
     * Recursion
     */
    class SolutionR {
        public boolean isSymmetric(TreeNode root) {

        }
    }

    public static void main(String[] args) {


    }
}
