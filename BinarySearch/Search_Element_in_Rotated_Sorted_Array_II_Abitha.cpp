/*
Date : 30th June 2025
Problem link: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
*/

class Solution {
public:
    bool search(vector<int>& nums, int target) {
        int lo = 0;
        int hi = nums.size()-1;
        while(lo <= hi) {
            int mid = (lo+hi)/2;
            if(nums[mid] == target) {
                return true;
            }
            if(nums[lo] == nums[mid] && nums[mid] == nums[hi]) {
                lo++;
                hi--;
                continue;
            }
            
            if(nums[lo] <= nums[mid]) {
                //sorted left half
                if(nums[lo] <= target && target <= nums[mid]) {
                    hi = mid-1;
                }
                else{
                    lo = mid+1;
                }
            }
            else{
                if(nums[mid] <= target && nums[hi] >= target) {
                    lo = mid+1;
                }
                else{
                    hi = mid-1;
                }
            }
        }
        return false;
        
    }
};
