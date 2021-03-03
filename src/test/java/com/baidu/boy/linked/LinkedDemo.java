package com.baidu.boy.linked;

import java.util.Arrays;

/**
 * 链表
 */
public class LinkedDemo {

    // 单向列表Node
    public static class Node<T> {
        public T value;
        public Node<T> next;
        public Node<T> last;

        public Node(T val) {
            value = val;
        }
    }

    // 双向列表Node
    public static class DoubleNode {
        public int value;
        public DoubleNode next;
        public DoubleNode pre;

        public DoubleNode(int val) {
            value = val;
        }

        @Override
        public String toString() {
            return "DoubleNode{" +
                    "value=" + value +
                    '}';
        }
    }

    /**
     * 单链表反转
     * 有head节点就足够
     *
     * @param head
     * @return
     */
    public static Node reverseNode(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            // 记录head.next
            next = head.next;
            // 移动head
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 双链表反转
     *
     * @param head
     * @return
     */
    public static DoubleNode reverseDoubleNode(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            // 方向转换
            head.pre = next;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main1(String[] args) {
//        DoubleNode node1 = new DoubleNode(1);
//        DoubleNode node2 = new DoubleNode(2);
//        DoubleNode node3 = new DoubleNode(3);
//        node1.next = node2;
//        node2.next = node3;
//        node2.pre = node1;
//        node3.pre = node2;
//
//        System.out.println(reverseDoubleNode(node1));

        System.out.println(3 >> 1 + 1);

    }

    // 双链表
    public static class DoubleEndsQueue<T> {
        public Node<T> head;
        public Node<T> tail;

        public void addFromHead(T node) {
            Node<T> cur = new Node<T>(node);
            if (head == null) {
                head = cur;
                tail = cur;
            } else {
                cur.next = head;
                head.last = cur;
                head = cur;
            }
        }

        public void addFromBottom(T node) {
            Node<T> cur = new Node<T>(node);
            if (tail == null) {
                tail = cur;
                head = cur;
            } else {
                cur.last = tail;
                tail.next = cur;
                tail = cur;
            }
        }

        public T popFromHead() {
            if (null == head) return null;

            Node<T> cur = head;
            // down relation
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.last = null;
                cur.next = null;
            }

            return cur.value;
        }

        public T popFromBottom() {
            if (tail == null) return null;

            Node<T> cur = tail;
            if (head == tail) {
                head = null;
                tail = null;
                // down tail
            } else {
                tail = tail.last;
                tail.next = null;
                cur.last = null;
            }
            return cur.value;
        }
    }

    public static void main2(String[] args) {
        int[] arr = new int[]{3, 9, 6, 2, 7, 4, 19};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 归并排序
     * 左边排序，右边排序，俩边结果合并
     *
     * @param arr
     * @param L
     * @param R
     */
    public static void mergeSort(int[] arr, int L, int R) {
        if (L == R) return;// 出口

        int mid = L + ((R - L) >> 1);
        mergeSort(arr, L, mid);
        mergeSort(arr, mid + 1, R);

        merge(arr, L, mid, R);
    }

    private static void merge(int[] arr, int L, int M, int R) {
        int result[] = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;

        while (p1 <= M && p2 <= R) {
            // 左右对比，小的放入result，然后移动指针
            result[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= M) {
            // add p1
            result[i++] = arr[p1++];
        }
        while (p2 <= R) {
            // add p2
            result[i++] = arr[p2++];
        }

        for (int j = 0; j < result.length; j++) {
            // L start
            arr[L + j] = result[j];
        }
    }

    public static void main3(String[] args) {
        int[] arr = {1, 5, 3, 6, 8, 3, 5, 2, 9, 5, 6, 3, 1};
        System.out.println(getRepidNum(arr));
    }

    /**
     * 找出数组中第一个重复的数字
     *
     * @param arr
     */
    public static int getRepidNum(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int a = arr[i];
                if (a == arr[j]) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main4(String[] args) {
        int[] arr = new int[]{3, 9, 6, 2, 7, 4, 19};
        mergeSortWhile(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 归并排序，while写法
     *
     * @param arr
     */
    public static void mergeSortWhile(int[] arr) {
        if (null == arr || arr.length == 1) return;

        int mergeSize = 1;
        int N = arr.length;

        // mergeSize在增加
        while (mergeSize < N) {
            int L = 0;

            // L在增加
            while (L < N) {
                int M = L + mergeSize - 1;
                if (M >= N) break;

                // 选小的
                int R = Math.min(M + mergeSize, N - 1);
                merge(arr, L, M, R);
                L = R + 1;
            }

            if (mergeSize > N >> 1) break;
            mergeSize <<= 1;
        }
    }

    /**
     * 荷兰国旗
     * 把数组分成三块
     * 小于num的在左边，等于num的在中间，大于num的在右边
     * 1.当前位置的数等于num，当前index++
     * 2.当前位置的数小于num，小于区右移一位，当前index++
     * 3.当前位置的数大于num，大于区左面一个和当前数替换，大于区左移一位，当前index不变
     */
    public void nederlandenSort(int[] arr, int num) {
        int left = 0;
        int right = arr.length;
        int index = 0;

        while (index < arr.length && index != right) {
            if (arr[index] == num) {
                index++;
            } else if (arr[index] < num) {
                left++;
                index++;
            }else {
                swap(arr,index,--right);
            }
        }
    }

    /**
     * 荷兰国旗，在L和R之间，返回与arr[R]相等的左边界和右边界的索引
     * @param arr
     * @param L
     * @param R
     */
    public static int[] nederlandenSort2(int[] arr, int L, int R) {
        if (L > R) {
            return new int[]{-1,-1};
        }
        if (L == R) {
            return new int[] {L, R};
        }
        int less = L-1; // 左区域的索引
        int more = R;   // 右区域的索引
        int index = L;  // 从L开始
        // 当索引碰到右边界时，停止
        while (index < more) {
            if (arr[index] == arr[R]) {
                index++;
            } else if (arr[index] < arr[R]) {
                // 当前数与小于区域右一个++less数交换，当前index++
                swap(arr,index++,++less);
            }else{
                swap(arr, index, --more);
            }
        }
        // 最后将R位置的数与大于区域左边界的数交换
        swap(arr, more,R);
        return new int[]{less + 1, more};
    }

    public static void main5(String[] args) {
        int[] arr = new int[] {2,3,5,6,2,6,8,6};
        int[] ints = nederlandenSort2(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(ints));
        System.out.println(Arrays.toString(arr));

    }
    public static void swap(int[] arr, int minIndex, int i) {
        int tem = arr[minIndex];
        arr[minIndex] = arr[i];
        arr[i] = tem;
    }

    /**
     * 快排2.0，配合使用荷兰国旗
     */
    public static void quickSort2(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        process2(arr, 0, arr.length - 1);
    }

    private static void process2(int[] arr, int L, int R) {
        // 递归的出口
        if (L >= R) {
            return;
        }
        int[] midArr = nederlandenSort2(arr, L, R);
        process2(arr,L, midArr[0]-1);
        process2(arr, midArr[1]+1, R);
    }

    public static void main6(String[] args) {
        int[] arr = new int[] {35,6,8,3,7,9,12,34,52};
        quickSort2(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void process3(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        // 随机选一个数，与R进行交换
        swap(arr,L+(int)(Math.random()*(R-L+1)), R);
        int[] midArr = nederlandenSort2(arr, L, R);
        process3(arr, L, midArr[0]-1);
        process3(arr, midArr[1]+1, R);
    }

    public static void main(String[] args) {
        int L = 4;
        int R = 9; // [0,1)  [0,6) [4,10)
        int i = L + (int) (Math.random() * (R - L + 1));
        System.out.println(i);
    }

}




















