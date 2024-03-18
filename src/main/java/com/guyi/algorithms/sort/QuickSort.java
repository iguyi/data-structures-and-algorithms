package com.guyi.algorithms.sort;

import java.util.Arrays;

/**
 * 快速排序算法的实现 - 递归方式<br/>
 * 博客链接: http://t.csdnimg.cn/fhFTu
 *
 * @author 孤诣
 * @see NonRecursiveQuickSort: 非递归实现方式
 */
public class QuickSort {
    public static void main(String[] args) {
        // 数据准备
        int[] dataArray = {7, 0, 9, 5, 6, 8, 4, 3, 1, 2};
        System.out.println("排序前: " + Arrays.toString(dataArray));

        // 利用快速排序算法进行排序
        quickSort(dataArray, 0, dataArray.length - 1);
        System.out.println("排序后: " + Arrays.toString(dataArray));
    }

    /**
     * 快速排序算法实现
     *
     * @param source     - 源数组
     * @param startIndex - 排序起始位置
     * @param endIndex   - 排序结束位置
     */
    public static void quickSort(int[] source, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return;
        }

        // 分区
        int lastPivotIndex = partition(source, startIndex, endIndex);

        // 上一个基准元素位置已经确定, 后续排序就不需要考虑上一个基准元素了
        quickSort(source, startIndex, (lastPivotIndex - 1));
        quickSort(source, (lastPivotIndex + 1), endIndex);
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
        // 基准元素
        int pivot = source[startIndex];

        // 初始化相关指针
        int pivotIndex = startIndex;
        int leftIndex = startIndex;
        int rightIndex = endIndex;

        while (leftIndex < rightIndex) {
            // 右侧元素小于基准元素
            while (leftIndex < rightIndex) {
                if (source[rightIndex] < pivot) {
                    source[leftIndex] = source[rightIndex];
                    pivotIndex = rightIndex;
                    leftIndex++;
                    break;
                }
                rightIndex--;
            }

            // 左侧元素小于基准元素
            while (leftIndex < rightIndex) {
                if (source[leftIndex] > pivot) {
                    source[rightIndex] = source[leftIndex];
                    pivotIndex = leftIndex;
                    rightIndex--;
                    break;
                }
                leftIndex++;
            }
        }

        // 将基准元素填入 pivotIndex 指向的位置
        source[pivotIndex] = pivot;
        return pivotIndex;
    }
}
