package com.github.zjiajun.algorithm.binarytree;

/**
 * @author zhujiajun
 * @version 1.0
 * @since 2021/11/28 15:02
 *
 * 二叉树遍历时间复杂度O(n)
 */
public class BinaryTree<T> {

    //前序遍历
    public void preOrder(TreeNode<T> root) {
        if (root == null) return;
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    //中序遍历
    public void inOrder(TreeNode<T> root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
    }

    //后序遍历
    public void postOrder(TreeNode<T> root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val);
    }

    public static void main(String[] args) {
        TreeNode<Integer> node6 = new TreeNode<>(6, null, null);
        TreeNode<Integer> node7 = new TreeNode<>(7, null, null);
        TreeNode<Integer> node5 = new TreeNode<>(5, node6, node7);
        TreeNode<Integer> node4 = new TreeNode<>(4, null, null);
        TreeNode<Integer> node2 = new TreeNode<>(2, node4, node5);
        TreeNode<Integer> node3 = new TreeNode<>(3, null, null);
        TreeNode<Integer> node1 = new TreeNode<>(1, node2, node3);

        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        binaryTree.preOrder(node1);
        System.out.println("前序遍历结束");
        binaryTree.inOrder(node1);
        System.out.println("中序遍历结束");
        binaryTree.postOrder(node1);
        System.out.println("后序遍历结束");
    }


}
