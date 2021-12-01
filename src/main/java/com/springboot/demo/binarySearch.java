package com.springboot.demo;

public class binarySearch {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};

        System.out.println(new binarySearch().search(nums, 1));

    }
    public int search(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            int mid = (high - low) / 2 + low;
            int num = nums[mid];
            if(num == target){
                return mid;
            }else if(num > target){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return -1;
    }


}
