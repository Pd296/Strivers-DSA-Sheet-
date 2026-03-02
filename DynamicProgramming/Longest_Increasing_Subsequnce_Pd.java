/*

   Problem Link : https://leetcode.com/problems/longest-increasing-subsequence/description/
   Date : 2nd Mar 2026

 */

class Solution {
    public int lengthOfLIS(int[] nums) {
        // int n = nums.length;
        // int[][] dp = new int[n][n+1];
        // for(int[] arr : dp )Arrays.fill(arr,-1);
        // return LIS(0,-1,nums,dp);
        return LISBottomUp(nums);
    }
    private int LIS(int ind,int prevIndex,int[] nums,int[][] dp){
        
        if(ind >= nums.length) return 0;
        if(dp[ind][prevIndex+1] != -1 ) return dp[ind][prevIndex+1];

        int dontTake = LIS(ind+1,prevIndex,nums,dp);
        int take = 0;
        if(prevIndex == -1 || nums[ind] > nums[prevIndex] ) 
            take = 1 + LIS(ind+1,ind,nums,dp);
        
        int maxLIS = Math.max(dontTake,take);
        dp[ind][prevIndex+1] = maxLIS;
        return maxLIS;
    }

    private int LISBottomUp(int[] nums){

        int n = nums.length;
        int[][] dp = new int[n+1][n+1];
        
        for(int j=0;j<=n;j++) dp[n][j] = 0;

        for(int ind=n-1;ind>=0;ind--){
            for(int prevIndex=n-1;prevIndex>=-1;prevIndex--){

                int dontTake = dp[ind+1][prevIndex+1];
                int take = 0;
                if(prevIndex == -1 || nums[ind] > nums[prevIndex] ) 
                    take = 1 + dp[ind+1][ind+1];
                
                int maxLIS = Math.max(dontTake,take);
                dp[ind][prevIndex+1] = maxLIS;

            }
        }

        return dp[0][0];
    }
}