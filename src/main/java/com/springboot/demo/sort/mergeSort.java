package com.springboot.demo.sort;

public class mergeSort {
    /**
     *
     就是使用分治法，先把分成两半，用中间点当作分割点，递归分割，分到最小
     把刚刚划分后的数组进行排序合并，从小组合到大组
     时间复杂度：O(N \log N)O(NlogN)，这里 NN 是数组的长度；
     空间复杂度：O(N)O(N)，辅助数组与输入数组规模相当。
     * */

    public static void mergeSort(int[] nums, int n) {
        if (n < 2) { return; }

        // int mid = left + (right - left) / 2;
        int mid = n / 2;
        //使用临时数组保存每一轮的排序结果
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = nums[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = nums[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(nums, l, r, mid, n - mid);
    }

    /**
     * 两个子数组的数字一一比较，并将较小的元素放入输入数组中
     * 复制到尾部的时候，另一组的剩余元素也被复制到属于数组里了
     */
    public static void merge(int[] nums, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                nums[k++] = l[i++];
            }
            else {
                nums[k++] = r[j++];
            }
        }
        while (i < left) {
            nums[k++] = l[i++];
        }
        while (j < right) {
            nums[k++] = r[j++];
        }
    }
}

/** https://www.baeldung.com/java-merge-sort
 * https://leetcode-cn.com/problems/sort-an-array/solution/fu-xi-ji-chu-pai-xu-suan-fa-java-by-liweiwei1419/
 * */