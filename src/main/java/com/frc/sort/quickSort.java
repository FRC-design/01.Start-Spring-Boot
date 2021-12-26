package com.frc.sort;
import java.util.*;

public class quickSort {
    /**
     时间复杂度：O(N \log N)O(NlogN)，这里 NN 是数组的长度；
     空间复杂度：O(\log N)O(logN)，这里占用的空间主要来自递归函数的栈空间。
     快速排序每一次都定位一个元素，
     然后用partition去递归地，对这个pivot左右两部分进行排序，让左边小，右边大；
     */
    public void sort(int[] num){
        quicksort(num, 0, num.length-1);
    }

    private void quicksort(int[] num, int left, int right) {
        if (left <right) {
            int index = partition1(num, left, right);
            quicksort(num, left, index-1);
            quicksort(num, index, right);
        }
    }
    /**
     * https://leetcode-cn.com/problems/sort-an-array/solution/pai-xu-shu-zu-by-leetcode-solution/
     */
    public int randomizedPartition(int[] nums, int l, int r) {
        int i = new Random().nextInt(r - l + 1) + l; // 随机选一个作为我们的主元
        swap(nums, r, i);
        return partition1(nums, l, r);
    }
    /**
     * 把最右边的数设为pivot
     *
     */
    public int partition1(int[] nums, int l, int r) {
        int pivot = nums[r];
        int i = l - 1;
        for (int j = l; j <= r - 1; ++j) {
            if (nums[j] <= pivot) {
                i = i + 1;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, r);
        return i + 1;
    }

    private void swap(int[] num, int left, int right) {
        int temp = num[left];
        num[left] = num[right];
        num[right] = temp;
    }
}