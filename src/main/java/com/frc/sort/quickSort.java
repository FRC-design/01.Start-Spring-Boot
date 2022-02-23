package com.frc.sort;
import java.util.*;
    /**
     时间: 最好情况每次递归都平分数组，一共需要递归logn次，每次需要n时间，复杂度为O(n*logn)，
     最坏情况pivot每次都是最大或最小数，所有数都划一个数组，一共需要递归n次，每次需要n时间，总体复杂度为O(n^2)。
     平均总体时间复杂度为O(nlogn)。
     空间: 时间复杂度相关，递归需要的空间是固定的，空间复杂度就是递归层数（栈），平均/最好空间复杂度为O(logn)，最坏空间复杂度为O(n)
     稳定性：快速排序的分区过程涉及交换操作，是不稳定的排序算法
     
     挑一个pivot，遍历数组，比pivot小的放前面，大的放后面；
     这个操作结束后，这个pivot左边比他小，右边比他大，这个partition就完成了；
     再递归地对子数组进行相同的操作；
     **/
public class quickSort {
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
     * 把最右边的数设为pivot
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
    
    /**
     * 
     * https://leetcode-cn.com/problems/sort-an-array/solution/pai-xu-shu-zu-by-leetcode-solution/
     */
    public int randomizedPartition(int[] nums, int l, int r) {
        int i = new Random().nextInt(r - l + 1) + l; // 随机选一个作为我们的主元
        swap(nums, r, i);
        return partition1(nums, l, r);
    }
}
