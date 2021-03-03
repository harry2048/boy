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
public class ArrToStack2 {
    static class Node{
        public int val;

        public Node(int value) {
            val = value;
        }
    }

    public Node[] arr;
    public int index; // 移动指针
    public final int limit; // 总大小

    public ArrToStack2(int size) {
        arr = new Node[size];
        index = 0;
        limit = size;
    }

    public void push(Node val) {
        if (index > limit) {
            throw new RuntimeException("满了");
        }
        arr[index] = val;
        index ++;
    }

    public Node pop() {
        if (index == 0) {
            throw new RuntimeException("没了");
        }
        Node val = arr[index - 1];
        arr[index - 1] = null;
        index --;
        return val;
    }

    public static void main(String[] args) {
        ArrToStack2 ats = new ArrToStack2(7);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        ats.push(node1);
        ats.push(node2);

        System.out.println(ats.pop().val);
        System.out.println(ats.pop().val);
    }
}
