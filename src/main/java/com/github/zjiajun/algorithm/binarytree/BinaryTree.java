package com.github.zjiajun.algorithm.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhujiajun
 * @version 1.0
 * @since 2021/11/28 15:02
 * 基于链表left和right
 * 二叉树遍历时间复杂度O(n)
 */
public class BinaryTree<T> {

    //按层遍历,广度优先遍历
    public void levelOrder(TreeNode<T> root) {
        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode<T> node = queue.poll();
            System.out.println(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    //前序遍历, 深度优先遍历
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

    private static TreeNode<Integer> initTree() {
        TreeNode<Integer> root = new TreeNode<>(1);
        TreeNode<Integer> node2 = new TreeNode<>(2);
        TreeNode<Integer> node3 = new TreeNode<>(3);
        TreeNode<Integer> node4 = new TreeNode<>(4);
        TreeNode<Integer> node5 = new TreeNode<>(5);
        TreeNode<Integer> node6 = new TreeNode<>(6);
        TreeNode<Integer> node7 = new TreeNode<>(7);
        TreeNode<Integer> node8 = new TreeNode<>(8);
        TreeNode<Integer> node9 = new TreeNode<>(9);
        TreeNode<Integer> node10 = new TreeNode<>(10);
        TreeNode<Integer> node11 = new TreeNode<>(11);

        root.left = node2;
        root.right = node3;

        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        node4.left = node8;
        node4.right = node9;
        node6.left = node10;
        node7.left = node11;

        return root;
    }

    public static void main(String[] args) {

        TreeNode<Integer> root = initTree();
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        binaryTree.levelOrder(root);
        System.out.println("按层遍历结束");
        binaryTree.preOrder(root);
        System.out.println("前序遍历结束");
        binaryTree.inOrder(root);
        System.out.println("中序遍历结束");
        binaryTree.postOrder(root);
        System.out.println("后序遍历结束");
    }


}
