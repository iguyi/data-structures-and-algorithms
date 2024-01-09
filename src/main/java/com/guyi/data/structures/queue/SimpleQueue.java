package com.guyi.data.structures.queue;

/**
 * 简单队列的实现
 *
 * @author 孤诣
 */
public class SimpleQueue {

    /**
     * 测试
     */
    public static void main(String[] args) {
        int queueSize = 10;
        SimpleQueue queue = new SimpleQueue(queueSize);
        /*
        预期输出结果:
            0123456789队列已满
            10
        */
        for (int i = 0; i <= queueSize; i++) {
            queue.enQueue(i);
            System.out.print(i);
        }

        System.out.println();

        /*
        预期输出结果:
            0123456789队列为空
         */
        for (int i = 0; i <= queueSize; i++) {
            queue.deQueue();
        }
    }

    /**
     * 队列
     */
    private final int[] queue;

    /**
     * 队列最大容量
     */
    private final int size;

    /**
     * 队列头索引, 记录队头位置索引
     */
    private int front = -1;

    /**
     * 队列尾索引, 记录队尾位置索引
     */
    private int back = -1;

    /**
     * @param size - 队列最大容量
     */
    public SimpleQueue(int size) {
        this.queue = new int[size];
        this.size = size;
    }

    /**
     * 数据入队操作, data 为要入队的元素
     */
    public void enQueue(int data) {
        // 判断队列是否已满
        if (isPull()) {
            System.out.println("队列已满");
            return;
        }

        // 判断当前队列是否为空
        if (isEmpty()) {
            queue[++front] = data;
            back += 2;
            return;
        }

        // 到此队列不为空, 也未满
        queue[back++] = data;
    }

    /**
     * 数据入队操作
     */
    public void deQueue() {
        // 判断队列是否为空
        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }

        // 到此队列不为空
        System.out.print(queue[front++]);
    }

    /**
     * 判断队列是否已满
     */
    public boolean isPull() {
        return back == size;
    }

    /**
     * 判断队列是否为空
     */
    public boolean isEmpty() {
        return front == back;
    }

}