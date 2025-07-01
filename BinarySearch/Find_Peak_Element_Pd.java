/*
Date : 1st July 2025
Problem Link : https://leetcode.com/problems/find-peak-element/
*/

class Solution {
    public int findPeakElement(int[] nums) {
        
        int n = nums.length;
        int low = 0;
        int high = n-1;

        while(low < high){

            int mid = low + (high - low ) / 2;

            //there is always a peak towards the side which we are moving
            if(nums[mid] < nums[mid+1]) low = mid + 1;
            else high = mid;
        }
        return low ;
    }
}

/*
 nums = [1,2,1,3,5,6,4]
*/