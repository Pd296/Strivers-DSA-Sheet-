

// Date 30-jun-2025
//problem link-https://leetcode.com/problems/find-peak-element/description/

class Solution {
    public int findPeakElement(int[] nums) {
        /*
        point-1 peak element exist only when the accending or dec order is broken
        point-1 if the nums are in asc order then there has to be a peak element at right side and vice versa
        */
        int n=nums.length-1;
        if(nums.length==1) return 0;
        if(nums[0]>nums[1]) return 0;
        if(nums[n]>nums[n-1]) return n;
        int left=1;
        int right=n-1;
        int mid=(left+right)/2;
        while(left<right){
            mid=(left+right)/2;
            if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]) return mid;
            else if(nums[mid]>nums[mid-1]) left=mid+1;
            else right=mid-1;
        }
        return left;
    }
}