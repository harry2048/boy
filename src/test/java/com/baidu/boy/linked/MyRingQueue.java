package com.baidu.boy.linked;

/**
 * 环形数组实现队列
 *
 *    pop ↓  |   |  push ↓
 *           |   |
 *           |   |
 *           |   |
 *           |   |
 */
public class MyRingQueue {
    public int[] arr;
    // popIndex
    public int popi;
    // pushIndex
    public int pushi;
    // arr.size
    public int size;
    // arr.MaxSize
    public final int limit;

    public MyRingQueue(int lim) {
        limit = lim;
        popi = 0;
        pushi = 0;
        size = 0;
        arr = new int[lim];
    }

    public void add(int value) {
        if (size == limit) {
            throw new RuntimeException("满了");
        }
        size++;
        arr[pushi] = value;
        pushi = nextIndex(pushi);
    }

    public int pop() {
        if (size == 0) {
            throw new RuntimeException("没了");
        }
        size--;
        int cur = arr[popi];
        popi = nextIndex(popi);
        return cur;
    }

    /**
     * 下一个index
     * @param currentIndex
     * @return
     */
    public int nextIndex(int currentIndex) {
        return currentIndex < limit - 1 ? currentIndex + 1 : 0;
    }
}
