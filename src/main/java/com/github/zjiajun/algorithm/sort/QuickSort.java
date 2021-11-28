package com.github.zjiajun.algorithm.sort;

import java.util.Arrays;

/**
 * @author zhujiajun
 * @version 1.0
 * @since 2021/11/28 19:54
 *
 * 快排时间复杂度O(nlogn)
 */
public class QuickSort {

    public int [] sort(int [] data) {
        _sort(data, 0, data.length-1);
        return data;
    }

    private void _sort(int [] data, int p, int r) {
        if (p >= r) return;
        int q = partition(data, p, r);
        _sort(data, p, q-1);
        _sort(data, q+1, r);
    }

    private int partition(int[] data, int p, int r) {
        int pivot = data[r];
        int i = p;
        for (int j = p;j < r;j++) {
            if (data[j] < pivot) {
                //swap, i and j
                int tmp = data[i];
                data[i] = data[j];
                data[j] = tmp;
                i++;
            }
        }
        //swap i and r
        int tmp = data[i];
        data[i] = data[r];
        data[r] = tmp;
        return i;
    }

    public static void main(String[] args) {
        int [] data = {6,11,3,9,8};
        QuickSort quickSort = new QuickSort();
        int[] sort = quickSort.sort(data);
        System.out.println(Arrays.toString(sort));
    }
}
