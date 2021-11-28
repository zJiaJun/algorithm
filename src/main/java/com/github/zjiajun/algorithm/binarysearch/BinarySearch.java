package com.github.zjiajun.algorithm.binarysearch;

/**
 * @author zhujiajun
 * @version 1.0
 * @since 2021/11/6 13:39
 *
 * O(logn)
 */
public class BinarySearch {

    public int bSearch(int [] data, int val) {
        int low = 0;
        int high = data.length - 1;
        while (low <= high) {
           /*
               int mid = (low + high) / 2;
               可能会存在益处问题
            */
//            int mid = low + (high - low) / 2;
            int mid = low + ((high - low) >> 1);
            if (data[mid] == val) {
                return mid;
            } else if (data[mid] < val) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }


    public int bSearchInternally(int [] data, int val) {
        return _bSearchInternally(data, 0, data.length - 1, val);
    }

    /**
     * 递归二分查找
     * @param data 数据
     * @param low  low index
     * @param high high index
     * @param val  value
     * @return index
     */
    private int _bSearchInternally(int [] data, int low, int high, int val) {
        if (low > high) return -1;
        int mid = low + ((high - low) >> 1);
        if (data[mid] == val) {
            return mid;
        } else if (data[mid] < val) {
            return _bSearchInternally(data, mid + 1, high, val);
        } else {
            return _bSearchInternally(data, low, mid - 1, val);
        }
    }

    //查找第一个值等于给定值的下标
    //{1,3,4,5,6,8,8,8,11,18} index = 5
    public int searchFirstVal(int [] data, int val) {
        int low = 0;
        int high = data.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (data[mid] > val) {
                high = mid - 1;
            } else if (data[mid] < val) {
                low = mid + 1;
            } else
                if (mid == 0 || data[mid-1] != val) {
                    return mid;
                } else {
                    high = mid - 1;
                }
        }
        return -1;
    }

    public static void main(String[] args) {
        //不存在重复元素的有序数组
        int [] data = new int[]{1,2,3,4,5,6,7,8,9,10};
        BinarySearch binarySearch = new BinarySearch();
        int i = binarySearch.bSearch(data, 7);
        System.out.println(i);
        int j = binarySearch.bSearchInternally(data, 7);
        System.out.println(j);
        int firstIndex = binarySearch.searchFirstVal(new int[]{1, 3, 4, 5, 6, 8, 8, 8, 11, 18}, 8);
        System.out.println(firstIndex);


    }
}
