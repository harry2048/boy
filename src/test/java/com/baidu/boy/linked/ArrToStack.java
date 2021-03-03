package com.baidu.boy.linked;

/**
 * 数组实现栈
 * 使用index标记
 *
 * 3
 * 2
 * 1
 * 0  index
 */
public class ArrToStack {
    public int[] arr;
    public int index; // 移动指针
    public final int limit; // 总大小

    public ArrToStack(int size) {
        arr = new int[size];
        index = 0;
        limit = size;
    }

    public void push(int val) {
        if (index > limit) {
            throw new RuntimeException("满了");
        }
        arr[index] = val;
        index ++;
    }

    public int pop() {
        if (index == 0) {
            throw new RuntimeException("没了");
        }
        int val = arr[index - 1];
        arr[index - 1] = 0;
        index --;
        return val;
    }

    public static void main(String[] args) {
        ArrToStack ats = new ArrToStack(7);
        ats.push(1);
        ats.push(2);

        System.out.println(ats.pop());
        System.out.println(ats.pop());
    }
}
