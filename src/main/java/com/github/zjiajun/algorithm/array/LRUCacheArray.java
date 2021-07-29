package com.github.zjiajun.algorithm.array;

import java.util.Arrays;

/**
 * @author zhujiajun
 * @version 1.0
 * @since 2021/7/29 17:42
 *
 * 最近最少使用
 * 通过数组实现, 数组下标0就是最近使用, 下标越大越少使用
 */
public class LRUCacheArray<K,V> {

    private static class Data<K,V>  {
        final K key;
        final V val;

        public Data(K key, V val) {
            this.key = key;
            this.val = val;
        }

        public K getKey() {
            return key;
        }

        public V getVal() {
            return val;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "key=" + key +
                    ", val=" + val +
                    '}';
        }
    }

    private int size;
    private int capacity;
    private Data<K,V> [] data;

    public LRUCacheArray(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.data = new Data[capacity];
    }

    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (data[i].key == key) {
                Data<K,V> current = data[i];
                for (int j = size-1; j > 0; j--) {
                    data[j] = data[j-1];
                }
                data[0] = current;
                return current.val;
            }
        }
        return null;
    }

    public void put(K key, V val) {
        if (size == capacity) {
            data[--size] = null;
        }
        Data<K,V> value = new Data<>(key, val);
        for (int i = size; i > 0 ; i--) {
            data[i] = data[i-1];
        }
        data[0] = value;
        size++;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    public void print() {
        System.out.println(Arrays.toString(data));
    }
}
