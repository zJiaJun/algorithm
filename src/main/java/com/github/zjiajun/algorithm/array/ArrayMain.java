package com.github.zjiajun.algorithm.array;

/**
 * @author zhujiajun
 * @version 1.0
 * @since 2021/7/29 19:01
 */
public class ArrayMain {

    public static void main(String[] args) {
        LRUCacheArray<Integer, String> lruCacheArray = new LRUCacheArray<>(5);
        for (int i = lruCacheArray.getCapacity(); i > 0;i--) {
            lruCacheArray.put(i, String.valueOf(i * 10));
        }
        System.out.print("初始cache数据: ");
        lruCacheArray.print();

        System.out.println(lruCacheArray.get(5));
        lruCacheArray.print();
        System.out.println(lruCacheArray.get(4));
        lruCacheArray.print();
        lruCacheArray.put(6,"60");
        lruCacheArray.print();
    }
}
