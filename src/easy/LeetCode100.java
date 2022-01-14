package easy; /**
 *
 */

import DataStructure.TreeNode;

import java.util.*;

class LeetCode100 {

    public static boolean isSameTree(TreeNode tree1, TreeNode tree2) {
        if (tree1 == null || tree2 == null) {
            return tree1 == tree2;
        }
        if (tree1.val == tree2.val) {
            return isSameTree(tree1.left, tree2.left) && isSameTree(tree1.right, tree2.right);
        }
        return false;
    }

    public static List<Integer> bfs(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode tempNode = queue.poll();
            if (tempNode == null) {
                res.add(0);
            } else {
                res.add(tempNode.val);
            }
            if (tempNode != null) {
                queue.add(tempNode.left);
                queue.add(tempNode.right);
            }
        }
        return res;
    }

    public static boolean isSameTree2(TreeNode p, TreeNode q) {
        List<Integer> a = bfs(p);
        List<Integer> b = bfs(q);
        if (a.size() != b.size()) {
            return false;
        }
        for (int i = 0; i < a.size(); i++) {
            if (!Objects.equals(a.get(i), b.get(i))) {
                return false;
            }
        }
        return true;
    }


    /**
     * 1
     * / \
     * 2   3
     * /\   /\
     * 4 5  6 7
     *
     * @param args
     */
    public static void main(String[] args) {
        //treenode1
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);

        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);

        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(7);
        //treenode2
        TreeNode treeNode2 = new TreeNode(1);
        treeNode2.left = new TreeNode(2);
        treeNode2.right = new TreeNode(3);

        treeNode2.left.left = new TreeNode(4);
        treeNode2.left.right = new TreeNode(5);

        treeNode2.right.left = new TreeNode(6);
//        treeNode2.right.right = new TreeNode(7);

        System.out.println(isSameTree2(treeNode, treeNode2));
        System.out.println(isSameTree2(treeNode, treeNode));
        System.out.println(isSameTree2(treeNode2, treeNode2));

    }
}