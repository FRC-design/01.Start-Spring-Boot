package com.frc.sort;

/**
 *首先在未排序序列中找到最小元素，存放到排序序列的起始位置。
 * 再从剩余未排序元素中继续寻找最小元素，然后放到已排序序列的末尾。
 * O(n^2)，空间复杂度O（1），稳定
 */

public class selectSort {
    public int[] sort(int[] nums) {
        int len = nums.length;
        // 循环不变量：[0, i) 有序，且该区间里所有元素就是最终排定的样子
        for (int i = 0; i < len - 1; i++) {
            // 选择区间 [i, len - 1] 里最小的元素的索引，交换到下标 i
            int minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (nums[j] < nums[minIndex]) {
                    // 记录目前能找到的最小值元素的下标
                    minIndex = j;
                }
            }// 将找到的最小值和i位置所在的值进行交换
            swap(nums, i, minIndex);
        }
        return nums;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

}
