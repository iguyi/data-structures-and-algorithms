package com.guyi.algorithms.sort;

import java.util.Arrays;

/**
 * 插入排序的实现
 *
 * @author 孤诣
 */
public class InsertionSort {
    public static void main(String[] args) {
        // 数据准备
        int[] dataArray = {7, 0, 9, 5, 6, 8, 4, 3, 1, 2};
        System.out.println("排序前: " + Arrays.toString(dataArray));

        // 排序
        insertionSort(dataArray);
        System.out.println("排序后: " + Arrays.toString(dataArray));
    }

    /**
     * 插入排序算法的实现
     *
     * @param source 源数组
     */
    public static void insertionSort(int[] source) {
        if (source == null) {
            return;
        }

        // 多少个元素就要比较多少轮
        for (int i = 0; i < source.length - 1; i++) {
            // 寻找合适位置并插入
            for (int j = i + 1; j > 0; j--) {
                // 如果前一个元素比后一个元素小, 本轮比较结束
                if (source[j - 1] < source[j]) {
                    break;
                }

                // 前一个元素比后一个元素大, 交换位置
                int temp = source[j];
                source[j] = source[j - 1];
                source[j - 1] = temp;
            }
        }
    }

    /**
     * 插入排序算法的实现
     *
     * @param source 源数组
     */
    public static void insertionSort2(int[] source) {
        if (source == null) {
            return;
        }

        int length = source.length;

        // 从数组第二个元素开始遍历
        for (int i = 1; i < length; i++) {
            // 当前待排序元素
            int current = source[i];

            // 有序部分最大元素的下标
            int j = i - 1;

            // 找到合适的插入位置
            while (j >= 0 && source[j] > current) {
                // 比当前待排序元素大的有序元素后移
                source[j + 1] = source[j];
                j--;
            }

            // 将当前元素插入到正确位置
            source[j + 1] = current;
        }
    }
}
