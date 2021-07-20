package com.github.zjiajun.algorithm.stack;

/**
 * @author zhujiajun
 * @version 1.0
 * @since 2021/7/20 23:30
 */
public class StackMain {

    public static void main(String[] args) {
        ArrayStack<Integer> arrayStack = new ArrayStack<>(10);
        for (int i = 0; i < 10; i++) {
            arrayStack.push(i);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(arrayStack.pop());
        }

    }
}
