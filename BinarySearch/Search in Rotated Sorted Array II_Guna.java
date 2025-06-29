
//28-jun-2025
//problem link-https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/
class Solution {
    public boolean search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        int mid=0;
         
        while(left<right){
            while(left<right && nums[left]==nums[right]) {
            if(nums[left]==target) return true;
                left++;
                right--;
            }
            if(left>=right) break;
            mid= (right-left)/2+left;
            if(nums[mid]==target) return true;
            else if(nums[left]<=nums[mid]){
                if(target>=nums[left] && target <nums[mid]) right=mid-1;
                else left=mid+1;
            }
            else{
                if(target>nums[mid] && target<=nums[right]) left=mid+1;
                else right=mid-1;
            }
            
        }
        if(left < nums.length && nums[left]==target) return true;
        return false;
    }
}