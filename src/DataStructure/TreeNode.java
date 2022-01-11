package DataStructure;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode next;

    public TreeNode(int x) {
        val = x;
    }

    /**
     * Case1
     *
     * @return
     */
    public static TreeNode makeTree_Test_Case_1() {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(13);

        return treeNode;
    }


    public static TreeNode makeTree_Test_Case_2() {
        TreeNode treeNode = new TreeNode(4);
        treeNode.left = new TreeNode(7);
        treeNode.right = new TreeNode(2);

        treeNode.left.left = new TreeNode(9);
        treeNode.left.right = new TreeNode(6);

        treeNode.right.left = new TreeNode(3);
        treeNode.right.right = new TreeNode(1);

        return treeNode;
    }

    public static TreeNode makeTree_Test_Case_3() {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(5);

        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(4);

        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(7);

        return treeNode;
    }

    /**
     * Travel_1
     *
     * @param root
     */
    public static void travelTree(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        travelTree(root.left);
        travelTree(root.right);

    }

    // 定义：输入一棵二叉树的根节点，返回这棵树的前序遍历结果
    static List<Integer> preorderTraverse(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        // 前序遍历的结果，root.val 在第一个
        res.add(root.val);
        // 利用函数定义，后面接着左子树的前序遍历结果
        res.addAll(preorderTraverse(root.left));
        // 利用函数定义，最后接着右子树的前序遍历结果
        res.addAll(preorderTraverse(root.right));
        return res;
    }

    public static int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(node);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode tempNode = queue.poll();
                if (tempNode != null) {
                    if (tempNode.left != null) {
                        System.out.println("node:" + tempNode.left.val);
                        queue.add(tempNode.left);
                    }
                    if (tempNode.right != null) {
                        System.out.println("node:" + tempNode.right.val);
                        queue.add(tempNode.right);
                    }
                }
                size = queue.size();
                size--;
            }
            ans += 1;
        }
        return ans;
//        int leftMax = maxDepth(node.left);
//        int rightMax = maxDepth(node.right);
//        return Math.max(leftMax, rightMax) + 1;
    }

    public static int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth2(root.left), maxDepth2(root.right)) + 1;
    }

    public static int maxDepth3(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size != 0) {
                TreeNode tmpNode = queue.poll();
                if (tmpNode.left != null) {
                    queue.add(tmpNode.left);
                }
                if (tmpNode.right != null) {
                    queue.add(tmpNode.right);
                }
                size--;
            }
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode node = makeTree_Test_Case_3();
        int maxDepth = maxDepth3(node);
        System.out.println(maxDepth);
        //
        List<Integer> res = preorderTraverse(node);
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i) + " ");
        }
    }
}

