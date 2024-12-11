package com.github.zjiajun.algorithm.sort;

import java.util.Arrays;

/**
 * @author zhujiajun
 * @version 1.0
 * @since 2021/11/8 12:20
 *
 * O(n*logn)
 */
public class MergeSort {

    public void mergeSort(int [] a, int n) {
        mergeSortInternally(a, 0, n-1);
    }

    private void mergeSortInternally(int [] a, int p, int r) {
        if (p >= r) return;
        int q = p + ((r - p) >> 1);
        mergeSortInternally(a, p, q);
        mergeSortInternally(a, q + 1, r);
        merge(a, p, q, r);

    }

    private void merge(int [] a, int p, int q, int r) {
        int i = p;
        int j = q + 1;
        int k = 0;
        int [] tmp = new int[r-p+1];
        while (i<=q && j<=r) {
            if (a[i] <= a[j]) {
                tmp[k++] = a[i++];
            } else {
                tmp[k++] = a[j++];
            }
        }
        int start = i;
        int end = q;
        if (j <= r) {
            start = j;
            end = r;
        }
        while (start <= end) {
            tmp[k++] = a[start++];
        }
        for (i=0;i<=r-p;++i) {
            a[p+i] = tmp[i];
        }
        System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int [] a = new int[]{11,8,3,9,7,1,2,5};
        mergeSort.mergeSort(a, a.length);
    }
}
