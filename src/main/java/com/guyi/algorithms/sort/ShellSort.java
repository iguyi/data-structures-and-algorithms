package com.guyi.algorithms.sort;

import java.util.Arrays;

/**
 * 希尔排序
 *
 * @author 孤诣
 */
public class ShellSort {
    public static void main(String[] args) {
        // 数据准备
        int[] array = {5, 0, 3, 9, 4, 1, 7, 6, 2, 8};
        System.out.println(Arrays.toString(array));

        // 利用希尔排序对数据进行排序
        shellSort(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 希尔排序算法的实现
     *
     * @param source 源数组
     */
    public static void shellSort(int[] source) {
        if (source == null) {
            return;
        }

        // 初始增量为数组长度的一半
        int dataNum = source.length;
        int gapFactor = 2;
        for (int gap = dataNum / gapFactor; gap > 0; gap /= gapFactor) {
            // 从第 gap 个元素开始，逐个对其所在的组进行直接插入排序操作
            for (int i = gap; i < dataNum; i++) {
                int current = source[i];
                int j = i;

                // 寻找合适的插入位置
                while (j - gap >= 0 && current < source[j - gap]) {
                    source[i] = source[j - gap];
                    j -= gap;
                }

                // 插入合适的位置
                source[j] = current;
            }
        }
    }
}
