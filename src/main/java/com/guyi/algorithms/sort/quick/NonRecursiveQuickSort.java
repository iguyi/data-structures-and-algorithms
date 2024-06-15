package com.guyi.algorithms.sort.quick;

import java.util.Arrays;
import java.util.Stack;

/**
 * 快速排序算法的实现 - 非递归方式
 *
 * @author 孤诣
 * @see QuickSort: 递归实现方式
 */
public class NonRecursiveQuickSort {
    public static void main(String[] args) {
        // 数据准备
        int[] dataArray = {7, 0, 9, 5, 6, 8, 4, 3, 1, 2};
        System.out.println("排序前: " + Arrays.toString(dataArray));

        quickSort(dataArray);

        System.out.println("排序后: " + Arrays.toString(dataArray));
    }

    /**
     * 快速排序算法实现
     *
     * @param source - 源数组
     */
    public static void quickSort(int[] source) {
        if (source == null || source.length <= 1) {
            return;
        }

        // stack 用于存储数组排序状态
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(source.length - 1);

        while (!stack.isEmpty()) {
            int endIndex = stack.pop();
            int startIndex = stack.pop();

            // 分区
            int lastPivotIndex = partition(source, startIndex, endIndex);

            // 将最新状态 push 到右子数组
            if (lastPivotIndex - 1 > startIndex) {
                stack.push(startIndex);
                stack.push(lastPivotIndex - 1);
            }

            // 将最新状态 push 到左子数组
            if (lastPivotIndex + 1 < endIndex) {
                stack.push(lastPivotIndex + 1);
                stack.push(endIndex);
            }
        }
    }

    /**
     * 分区, 本来操作的基准元素的最终位置将被确定。
     *
     * @param source     - 源数组
     * @param startIndex - 排序起始位置
     * @param endIndex   - 排序结束位置
     * @return 本轮操作完成后，基准元素所在位置
     */
    private static int partition(int[] source, int startIndex, int endIndex) {
        // 基准元素, 这里选择最后一个元素
        int pivot = source[endIndex];
        int leftIndex = startIndex - 1;

        // 确定基准元素的最终位置
        for (int rightIndex = startIndex; rightIndex <= endIndex - 1; rightIndex++) {
            if (source[rightIndex] <= pivot) {
                leftIndex++;
                swap(source, leftIndex, rightIndex);
            }
        }

        swap(source, leftIndex + 1, endIndex);
        return leftIndex + 1;
    }

    /**
     * 交互数组中两元素的位置
     *
     * @param source - 源数组
     * @param i      - 第一个元素的索引
     * @param j      - 第二个元素的索引
     */
    private static void swap(int[] source, int i, int j) {
        int temp = source[i];
        source[i] = source[j];
        source[j] = temp;
    }
}
