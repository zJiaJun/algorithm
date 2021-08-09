package com.github.zjiajun.algorithm.stack;

import com.github.zjiajun.algorithm.linkedlist.Node;

/**
 * @author zhujiajun
 * @version 1.0
 * @since 2021/8/9 09:19
 *
 * 栈-链表实现,链式栈
 * 想象成叠盘子,先进后出,后进先出
 */
public class NodeStack<T> {

    private Node<T> data;

    public void push(T val) {
        Node<T> newNode = new Node<>(val);
        if (data != null) {
            newNode.next = data;
        }
        data = newNode;
    }

    public T pop() {
        if (data == null) {
            return null;
        }
        T val = this.data.data;
        data = data.next;
        return val;
    }

    public T peek() {
        if (data == null) {
            return null;
        }
        return this.data.data;
    }


    public boolean isEmpty() {
        return data == null;
    }
}
