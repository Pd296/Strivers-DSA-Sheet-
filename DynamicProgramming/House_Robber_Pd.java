/*
  
  Problem Link : https://leetcode.com/problems/house-robber/
  Date : 13th October 2025
  
 */

class Solution {
    public int rob(int[] nums) {
        
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);

        int maxAmountRobbed = houseRobberTopDown(dp,nums,n-1);
        return maxAmountRobbed ;
    }

    private int houseRobberTopDown(int[] dp,int[] nums,int n){
        
        if(n<0) return 0;
        if(n==0) return nums[0];
        if(dp[n] != -1) return dp[n];
        
        int robCurrentIndex = houseRobberTopDown(dp,nums,n-2) + nums[n];
        int skipCurrentIndex =  houseRobberTopDown(dp,nums,n-1) ;

        int maxRobbed = Math.max(robCurrentIndex,skipCurrentIndex);
        dp[n] = maxRobbed;
        return dp[n];
    }
}