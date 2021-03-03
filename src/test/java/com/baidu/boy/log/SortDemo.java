package com.baidu.boy.log;

public class SortDemo {

    public static void main1(String[] args) {
//        int[] arr = new int[]{16, 5, 4, 3, 6, 7};
//        selectSort(arr);
//        buuble(arr);
//        insertSort(arr);
//        System.out.println(Arrays.toString(arr));


        int[] arr = new int[]{3, 7, 17, 23, 65, 71};
        System.out.println(middleSort(arr, 17));

    }

    /**
     * 选择排序  O(n²)
     * 1 第一个数和后面所有的数比较出最小值
     * 2 每次比较后，如果a > b 则互换
     *
     * @param arr
     */
    public static void selectSort(int[] arr) {
        if (arr == null || arr.length < 2) return;

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[minIndex] < arr[j] ? minIndex : j;
            }
            swap(arr, minIndex, i);
        }
    }

    /**
     * 冒泡算法  O(n²)
     * 1 第一个和第二个比，如果a>b,则互换
     * 2 下一圈从第二个开始
     * 3 比了n-1圈，等差数列
     *
     * @param arr
     */
    public static void buuble(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
    }

    public static void swap(int[] arr, int minIndex, int i) {
        int tem = arr[minIndex];
        arr[minIndex] = arr[i];
        arr[i] = tem;
    }

    /**
     * 插入算法 O(n²)
     * 1 b 和 c比较，b>c,互换
     * 2 若互换后，a>b,互换，一直换下去
     *
     * @param arr
     */
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            // 0~1
            // 0~2
            // 第二层在左，第一次在右
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

    /**
     * 二分查找  O(logN)
     *
     * @param arr
     * @param target
     */
    public static int middleSort(int[] arr, int target) {
        int left = 0, right = arr.length - 1; //注意

        while (left <= right) {  // 注意
            int mid = (left + right) / 2;

            if (arr[mid] < target)
                left = mid + 1;  // 注意
            else if (arr[mid] > target)
                right = mid - 1; // 注意
            else if (arr[mid] == target)
                return mid;
        }
        return -1;
    }

    /**
     * 数组中别的数都是出现偶数次，只有一个数出现了奇数次
     * 找出这个数
     * <p>
     * 同一个数异或偶数次为 eor
     * int arr[] = new int[]{1, 2, 1, 2, 4, 4, 4, 3, 3};
     *
     * @param arr
     */
    public static void selectZhiShu(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        System.out.println(eor);
    }

    public static void main2(String[] args) {
        int a = 3495874;
        System.out.println(Integer.toBinaryString(a));
        bit1Count(a);
    }

    /**
     * 取出一个int整型数中，最右侧的1，其它保持0
     * 11010101001010100011100
     * 取出 100
     *
     * @param num
     */
    public static void selectRight(int num) {
        System.out.println((~num + 1) & num);
    }

    /**
     * 数组中有俩个数，出现奇数次，是哪俩个数
     * 1 使用^ 获得 a^b
     * 2 使用  (~eor + 1)&eor  get rightOne
     * 3 数组中的数为俩类，一类为有rightOne，一类没有，
     * 使用  arr[i] & rightOne !=0 ,int eor2=0; eor2 ^arr[i]  找出 a
     * 4 b = a^b^a
     *
     * @param arr
     */
    public static void selectTwoSingle(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i]; // a^b
        }

        // 获取a^b 最右面的1
        int rightOne = (~eor + 1) & eor;

        int eor2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & rightOne) != 0) {
                eor2 ^= arr[i];
            }
        }
        System.out.println(eor2 + "--" + (eor2 ^ eor));
    }

    /**
     * 数出二进制中1的个数
     * 1 get rightOne
     * 2 使用 N ^ rightOne  抹掉左面的1
     * 3 重复1 2 步
     */
    public static void bit1Count(int N) {
        int count = 0;
        while (N > 0) {
            int rightOne = N & (~N + 1);
            count++;
            N ^= rightOne;
        }
        System.out.println(count);
    }

    // 归并排序
    public static void mergeSort(int[] arr, int L, int R) {
        if (L == R) return;

        int M = L + ((R - L) >> 1);
        mergeSort(arr, L, M);
        mergeSort(arr, M + 1, R);

        merge(arr, L, M, R);
    }

    // 左右合并
    private static void merge(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;

        while (arr[p1] <= arr[M] && arr[p2] <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (arr[p1] <= arr[M]) {
            help[i++] = arr[p1++];
        }

        while (arr[p2] <= arr[R]) {
            help[i++] = arr[p2++];
        }

        for (int j = 0; j < help.length; j++) {
            arr[L + j] = help[j];
        }
    }

    public static void mergeSortWhile(int[] arr) {
        if (null == arr || arr.length < 2) return;
        int N = arr.length;
        int mergeSize = 1;

        while (mergeSize < N) {
            int L = 0;

            while (L < N) {
                int M = L + mergeSize - 1;
                if (M >= N) break;
                int R = Math.min(N - 1, M + mergeSize);
                merge(arr, L, M, R);
                L = R + 1;
            }

            if (mergeSize > (N >> 1)) break;
            mergeSize <<= 1;
        }

    }
}
