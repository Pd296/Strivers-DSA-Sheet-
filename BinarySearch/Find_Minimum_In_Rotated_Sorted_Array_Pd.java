/*
Date : 29th June 2025
Problem link: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
*/

class Solution {
    public int findMin(int[] nums) {
        
        int n = nums.length;
        int low = 0;
        int high = n-1;

        while(low < high){
            int mid = low + (high-low)/2;
            //right half is not sorted , so min is at right half
            if(nums[mid] > nums[high])
                low=mid + 1;
             else 
                high=mid;
            }

        return nums[low];
    }
}