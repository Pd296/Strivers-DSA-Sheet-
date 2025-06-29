

// 29-jun-2025
//link-https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/

class Solution {
    public int findMin(int[] nums) {
        int left=0;
        int right=nums.length-1;
        int mid=0;
        int ans=nums[0];
        while(left<right){
            mid=(right-left)/2 + left;
            //if(nums[left]<=nums[mid] && nums[mid]<=nums[right]) return nums[left];
            if(nums[left]<=nums[mid]){
                ans=Math.min(nums[left],ans);
                left=mid+1;
            }
            else if (nums[mid]<=nums[right]){
                ans=Math.min(nums[mid],ans);
                right=mid-1;
            }
        }
        ans=Math.min(nums[left],ans);
        return ans;
    }
}