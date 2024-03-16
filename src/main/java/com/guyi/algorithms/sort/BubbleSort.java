package com.guyi.algorithms.sort;

import java.util.Arrays;

/**
 * 冒泡排序的实现<br/>
 * 博客链接: http://t.csdnimg.cn/Mhxli
 *
 * @author 孤诣
 */
public class BubbleSort {
    public static void main(String[] args) {
        // 数据准备
        int[] dataArray = {7, 0, 9, 5, 6, 8, 4, 3, 1, 2};
        System.out.println("排序前: " + Arrays.toString(dataArray));

        // 排序
        // bubbleSort(dataArray);
        bubbleSortPro(dataArray);
        System.out.println("排序后: " + Arrays.toString(dataArray));
    }

    /**
     * 冒泡排序算法的实现
     *
     * @param source - 源数据
     */
    public static void bubbleSort(int[] source) {
        // 数组中元素的个数
        int itemNum = source.length;

        // 外层循环, 决定排序次数
        for (int i = 0; i < itemNum; i++) {
            // 内层循环, 决定比较次数
            for (int j = 0; j < itemNum - 1; j++) {
                if (source[j] > source[j + 1]) {
                    swap(source, j, (j + 1));
                }
            }
        }
    }

    /**
     * 冒泡排序算法的实现 - 优化
     *
     * @param source - 源数据
     */
    public static void bubbleSortPro(int[] source) {
        // 数组中未排序元素的个数, 这些元素总是位于已排序元素的前面
        int disorderItemNum = source.length;

        // 外层循环, 决定排序次数
        while (disorderItemNum > 0) {
            // 内层循环, 决定比较次数
            for (int i = 0; i < disorderItemNum - 1; i++) {
                if (source[i] > source[i + 1]) {
                    swap(source, i, (i + 1));
                }
            }
            // 更新数组中未排序元素的个数
            disorderItemNum--;
        }
    }

    /**
     * 将一个数组的两个元素位置互换
     *
     * @param source - 源数组
     * @param i      - 第一个元素
     * @param j      - 第二个元素
     */
    private static void swap(int[] source, int i, int j) {
        int temp = source[i];
        source[i] = source[j];
        source[j] = temp;
    }
}
