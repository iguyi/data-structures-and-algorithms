package com.guyi.algorithms.sort;

import java.util.Arrays;

/**
 * 选择排序
 *
 * @author 孤诣
 */
public class SelectionSort {
    public static void main(String[] args) {
        // 数据准备
        int[] array = {5, 0, 3, 9, 4, 1, 7, 6, 2, 8};
        System.out.println(Arrays.toString(array));

        // 利用选择排序对数据进行排序
        selectionSort(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 选择排序算法的实现
     *
     * @param source 源数组
     */
    public static void selectionSort(int[] source) {
        if (source == null) {
            return;
        }

        int length = source.length;

        // 共比较 length-1 轮，i 就是本轮放置最小元素的位置
        for (int i = 0; i < length - 1; i++) {
            // 记录本轮最小元素的索引
            int min = source[i];

            // 寻找本轮最小元素
            for (int j = i + 1; j < length; j++) {
                if (source[min] > source[j]) {
                    min = j;
                }
            }

            // 本轮【最小元素】和【 i 位置上的元素】位置互换
            if (i != min) {
                int temp = source[i];
                source[i] = source[min];
                source[min] = temp;
            }
        }
    }
}
