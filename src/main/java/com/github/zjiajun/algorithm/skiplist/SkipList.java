package com.github.zjiajun.algorithm.skiplist;

import java.util.Arrays;

/**
 * @author zhujiajun
 * @version 1.0
 * @since 2021/11/5 21:55
 */
public class SkipList {


    private static final float SKIPLIST_P = 0.5f;
    private static final int MAX_LEVEL = 16;

    private int levelCount = 1;

    private Node head = new Node();

    public Node find(int data) {
        Node p = head;
        for (int i = levelCount - 1; i >=0;--i) {
            while (p.forwards[i] != null && p.forwards[i].data < data) {
                p = p.forwards[i];
            }
        }
        if (p.forwards[0] != null && p.forwards[0].data == data) {
            return p.forwards[0];
        } else {
            return null;
        }
    }

    public void insert(int data) {
        int level = randomLevel();
        Node newNode = new Node();
        newNode.data = data;
        newNode.maxLevel = level;
        Node[] update = new Node[level];
        for (int i = 0;i < level; ++i) {
            update[i] = head;
        }
        Node p = head;
        for (int i = level - 1; i >= 0; --i) {
            while (p.forwards[i] != null && p.forwards[i].data < data) {
                p = p.forwards[i];
            }
            update[i] = p;
        }

        for (int i = 0; i < level; ++i) {
            newNode.forwards[i] = update[i].forwards[i];
            update[i].forwards[i] = newNode;
        }
        if (levelCount < level) {
            levelCount = level;
        }

    }

    public void delete(int data) {

    }

    private int randomLevel() {
        int level = 1;
        while (Math.random() < SKIPLIST_P && level < MAX_LEVEL) {
            level += 1;
        }
        return level;
    }

    public void printAll() {
        Node p = head;
        while (p.forwards[0] != null) {
            System.out.print(p.forwards[0] + " ");
            p = p.forwards[0];
        }
        System.out.println();
    }

    private static class Node {

        public int data = -1;

        public Node[] forwards = new Node[MAX_LEVEL];

        private int maxLevel = 0;

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", forwards=" + Arrays.toString(forwards) +
                    ", maxLevel=" + maxLevel +
                    '}';
        }
    }

    public static void main(String[] args) {
        SkipList skipList = new SkipList();
        for (int i = 0; i < 30; i++) {
            skipList.insert(i);
        }
        skipList.printAll();
        Node node = skipList.find(23);
        System.out.println(node);
    }

}
