/*

   Problem Link: https://www.geeksforgeeks.org/problems/geek-jump/1
   Date : 13th October 2025

 */
class Solution {
    int minCost(int[] height) {
        // code here
        int n = height.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        //int minCostToReachEnd = findMinCostMemoization(height,dp,n-1);
        int minCostToReachEnd = findMinCostTabulation(height);
        return minCostToReachEnd;
    }
    
    int findMinCostMemoization(int[] height,int[] dp,int n){
        
        if(n==0) return 0;
        if(dp[n] != -1) return dp[n];
        
        int oneStepBack = findMinCostMemoization(height,dp,n-1) + Math.abs(height[n] - height[n-1]);
        int twoStepsBack = n > 1 ? findMinCostMemoization(height,dp,n-2) + Math.abs(height[n] - height[n-2]) : Integer.MAX_VALUE ; 
        
        dp[n] = Math.min(oneStepBack,twoStepsBack);
        return dp[n];
    }
    
    int findMinCostTabulation(int[] height){
        
        int n = height.length;
        //dp[0]=0;
        int prevCost = 0;
        int prev2Cost = 0;
        int currentCost = 0;
        
        for(int i=1;i<n;i++){
            
            int firstStepCost = prevCost + Math.abs(height[i-1] - height[i]);
            int secondStepCost = Integer.MAX_VALUE;
            if(i>1) secondStepCost = prev2Cost + Math.abs(height[i-2] - height[i]);
            
            currentCost = Math.min(firstStepCost,secondStepCost);
            prev2Cost = prevCost;
            prevCost = currentCost;
        }
        
        return currentCost;
    }
}