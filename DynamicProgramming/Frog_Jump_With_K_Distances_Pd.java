/*
  
  Problem Link : https://takeuforward.org/plus/dsa/problems/frog-jump-with-k-distances
  Date : 14th October 2025
  
 */

class Solution {
    public int frogJump(int[] heights, int k) {
        
        int n = heights.length;
        int[] dp = new int[n];
        dp[0]=0;

        for(int i=1;i<=n-1;i++){

            int minSteps = Integer.MAX_VALUE;
            for(int j=1;j<=k;j++){
                if(i-j < 0) break;
                int energyRequired = dp[i-j] + Math.abs(heights[i]-heights[i-j]);
                minSteps=Math.min(minSteps,energyRequired);
                dp[i]=minSteps;
            }
        }

        return dp[n-1];
    }
}