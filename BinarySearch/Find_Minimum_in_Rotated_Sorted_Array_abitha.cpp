/*
Date : 30th June 2025
Problem link: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
*/

class Solution {
public:
    int findMin(vector<int>& nums) {
        int n = nums.size();
        int ans = INT_MAX;
        int lo = 0, hi = n-1;
        while(lo <= hi) {
            int mid = (lo+hi)/2;
            if(nums[lo] <= nums[mid] && nums[mid] <= nums[hi]) {
                //checking in sorted array, so no need to check furtherr
                ans = min(ans, nums[lo]);
                break;
            }
            if(nums[lo] <= nums[mid]) {
                //sorted left half
                ans = min(ans, nums[lo]);
                lo = mid+1;
            }
            else{ 
                ans = min(ans, nums[mid]);
                hi = mid-1;
            }
        }
        return ans;
    }
};
