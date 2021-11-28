package com.github.zjiajun.algorithm.sort;

/**
 * @author zhujiajun
 * @version 1.0
 * @since 2021/11/28 20:42
 */
public class KthElement {

    public int findKthLargest(int [] data, int k) {
        return _findKthLargest(data, data.length - k, 0, data.length - 1);
    }

    private int _findKthLargest(int [] data, int k, int p, int r) {
        int q = partition(data, p, r);
        if (k == q) {
            return data[q];
        } else if (k > q) {
            return _findKthLargest(data, k, q + 1, r);
        } else {
            return _findKthLargest(data, k, p, q - 1);
        }
    }

    private int partition(int [] data, int p, int r) {
        int pivot = data[r];
        int i = p;
        for (int j = p;j < r;j++) {
            if (data[j] < pivot) {
                int tmp = data[i];
                data[i] = data[j];
                data[j] = tmp;
                i++;
            }
        }
        int tmp = data[i];
        data[i] = data[r];
        data[r] = tmp;
        return i;
    }

    public static void main(String[] args) {
        int [] data = {3,2,1,5,6,4};
        KthElement kthElement = new KthElement();
        int element = kthElement.findKthLargest(data, 1);
        System.out.println(element);
    }
}
