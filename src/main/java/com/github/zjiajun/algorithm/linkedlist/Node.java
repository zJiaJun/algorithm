package com.github.zjiajun.algorithm.linkedlist;

/**
 * @author zhujiajun
 * @version 1.0
 * @since 2021/7/20 23:19
 */
public class Node<T> {

    public T data;
    public Node<T> next;

    public Node() {
    }

    public Node(T data) {
        this.data = data;
    }

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}
