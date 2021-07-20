package com.github.zjiajun.algorithm.stack;

/**
 * @author zhujiajun
 * @version 1.0
 * @since 2021/7/20 22:08
 *
 * 栈-数组实现
 * 想象成叠盘子,先进后出,后进先出
 *
 */
public class ArrayStack<T> {

    private int size;
    private int capacity;
    private T [] data;


    public ArrayStack(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.data = (T[]) new Object[capacity];
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }


    /**
     * 入栈
     * @param val 数据
     */
    public void push(T val) {
        if (size == capacity) {
            return;
        }
        data[size++] = val;
    }

    /**
     * 出栈
     * @return T
     */
    public T pop() {
        if (size == 0) return null;
        return data[--size];
    }

    /**
     * 获取数据
     * @return
     */
    public T peek() {
        if (size == 0) return null;
        return data[size-1];
    }
}
