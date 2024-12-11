package com.github.zjiajun.algorithm.linkedlist;

/**
 * @author zhujiajun
 * @version 1.0
 * @since 2021/7/30 14:17
 */
public class InverseNode<T> {

    public Node<T> inverse(Node<T> node) {
        Node<T> head = node;
        Node<T> prev = null;
        Node<T> next = null;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        InverseNode<Integer> inverseNode = new InverseNode<>();
        Node<Integer> n5 = new Node<>(5, null);
        Node<Integer> n4 = new Node<>(4, n5);
        Node<Integer> n3 = new Node<>(3, n4);
        Node<Integer> n2 = new Node<>(2, n3);
        Node<Integer> n1 = new Node<>(1, n2);
        System.out.println("翻转前:" + n1);
        Node<Integer> inverse = inverseNode.inverse(n1);
        System.out.println("翻转后:" + inverse);
    }
}
