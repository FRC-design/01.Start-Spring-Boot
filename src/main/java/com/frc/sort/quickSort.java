package com.frc.sort;

public class quickSort {
    /**
     *
     时间复杂度：O(N \log N)O(NlogN)，这里 NN 是数组的长度；
     空间复杂度：O(\log N)O(logN)，这里占用的空间主要来自递归函数的栈空间。
     快速排序每一次都定位一个元素，
     然后用partition去递归地，对这个pivot左右两部分进行排序，让左边小，右边大；
     */
    public  void sort(int[] num){
        quicksort(num, 0, num.length-1);
    }
    private  void quicksort(int[] num, int left, int right) {
        if (left <right) {
            int index = partition(num, left, right);
            quicksort(num, left, index-1);
            quicksort(num, index, right);
        }

    }

    private int partition(int[] num, int left, int right) {
        if(num==null ){
            return 0;
        }
        if( left<0 || right>=num.length){
            return  0;
        }
        int pivot = num[left + (right - left) / 2];
        while(left<=right){
            while (num[left] < pivot) {
                left++;
            }
            while (num[right] > pivot) {
                right--;
            }
            if (left<=right) {
                swap(num, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    private void swap(int[] num, int left, int right) {
        int temp = num[left];
        num[left] = num[right];
        num[right] = temp;
    }
}