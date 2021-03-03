package com.baidu.boy.linked;

import static com.baidu.boy.log.SortDemo.swap;

public class NederlandenSortDemo {
    /**
     * 给定一个数据和左右边界，返回=区域的左右边界
     * @param arr
     * @param L
     * @param R
     * @return
     */
    public static int[] nederlandenSort(int[] arr, int L, int R) {
        if (null == arr || arr.length == 0) {
            return new int[]{-1, -1};
        }

        if (arr.length == 1) {
            return new int[]{0, 0};
        }

        if (arr.length == 2) {
            return new int[]{L, R};
        }
        int index = 0;
        int less = L-1;
        int more = R;
        while (index < more) {
            if (arr[index] < arr[R]) {
                swap(arr, ++less, index++);
            }else if (arr[index] == arr[R]) {
                index++;
            } else {
                swap(arr, index, --more);
            }

        }
        swap(arr, index - 1, R);
        return new int[]{less + 1, more};
    }
}
