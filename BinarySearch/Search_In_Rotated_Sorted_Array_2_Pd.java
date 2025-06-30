/*
Date : 28th June 2025
Problem Link : https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
*/

class Solution {
    public boolean search(int[] nums, int target) {
        
        int n = nums.length;
        int low = 0;
        int high = n-1;

        while( low <= high){

            int mid = low + (high-low)/2;
            if(nums[mid]==target) return true;
            
             // When we cannot determine which part is sorted due to duplicates
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++;
                high--;
                continue;
            }
            //if left is sorted 
            if(nums[low] <= nums[mid]){
                if(target >= nums[low] && target < nums[mid]){
                    high=mid-1;
                }else{
                    low=mid+1;
                }

            }//if right is sorted
            else{
                 if(target > nums[mid] && target <= nums[high]){
                     low=mid+1;
                 }else{
                     high=mid-1;
                 }
            }
        }
        return false;
    }
}