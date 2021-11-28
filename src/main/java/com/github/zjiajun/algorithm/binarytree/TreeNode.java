package com.github.zjiajun.algorithm.binarytree;

/**
 * @author zhujiajun
 * @version 1.0
 * @since 2021/11/28 14:20
 */
public class TreeNode<T> {

    public T val;
    public TreeNode<T> left;
    public TreeNode<T> right;

    public TreeNode(T val, TreeNode<T> left, TreeNode<T> right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
