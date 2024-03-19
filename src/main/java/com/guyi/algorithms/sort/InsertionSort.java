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
        straightInsertionSort(dataArray);
        System.out.println("排序后: " + Arrays.toString(dataArray));
    }

    /**
     * 插入排序算法的实现
     *
     * @param source 源数组
     */
    public static void straightInsertionSort(int[] source) {
        if (source == null) {
            return;
        }

        // 多少个元素就要比较多少轮
        for (int i = 0; i < source.length - 1; i++) {
            // 寻找合适位置插入
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
}
