package com.frc.sort;

/**
 * 归并排序的递归树，树种每层元元素的个数最多是n，每层最多进行n次比较，而递归树最多只有log2n层，合在一起就是nlog2n了
 * 空间复杂度：O(n)，每次合并需要新的堆空间。递归树最多只有log2n层，O(logn)的栈空间。加起来：O(n)
 * 稳定性：合并的时候，相同元素的前后顺序不变，是稳定的排序算法。
 *
 * 归并排序就是一种分治。它首先将数组不断地二分，直到最后每个部分只包含 1 个数。
 * 然后再对每个部分分别进行排序，最后将排序好的相邻的两部分合并在一起，整个数组就有序了
 */

public class MergeSort {
    int[] tmp;
    public int[] sortArray(int[] nums) {
        tmp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void mergeSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = (l + r) / 2;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        int i = l, j = mid + 1;
        int cnt = 0; //记录tmp数组位置
        while (i <= mid && j <= r) {
            if (nums[i] <= nums[j]) {
                tmp[cnt++] = nums[i++];
            } else {
                tmp[cnt++] = nums[j++];
            }
        }
        while (i <= mid) {
            tmp[cnt++] = nums[i++];
        }
        while (j <= r) {
            tmp[cnt++] = nums[j++];
        }
        for (int k = 0; k < r - l + 1; ++k) {
            nums[k + l] = tmp[k];
        }
    }
}

