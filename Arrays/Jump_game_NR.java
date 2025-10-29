/*
  Problem Link : https://leetcode.com/problems/jump-game/description/
  Date : 31st August 2025 
  
 */
class Solution {
    public boolean canJump(int[] nums) {
        int i=0;
        int len = nums.length;
        int curr=0;
        if(len == 1) return true;
        while(i<nums.length && (nums[i]!= 0 || (nums[i]== 0&& curr>i))){
                curr=curr>(i+nums[i])?curr:(i+nums[i]);
                i++;
        }
        if(curr >= len-1) return true;
        return false;
    }
}
