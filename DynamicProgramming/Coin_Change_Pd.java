/*

   Problem Link : https://leetcode.com/problems/coin-change/description/
   Date : 30th October 2025

 */

class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int n = coins.length;
        int[][] dp = new int[n][amount+1]; // memoization table
        for(int[] arr : dp ) Arrays.fill(arr,-1); // initialize with -1
        int answer = coinChangeMemo(coins,amount,dp,n-1);
        return answer >= (int)1e9 ? -1 : answer;   // if answer is infinity, return -1
    }

    private int coinChangeMemo(int[] coins,int target,int[][] dp,int index){
        
        if(index == 0){ // base case: only one coin type available
            if( target % coins[0] == 0 ) return target / coins[0]; // can make the amount
            else return (int)1e9;  // cannot make the amount
        }
        
        if(dp[index][target] != -1 ) return dp[index][target]; 
        int notTake = coinChangeMemo(coins,target,dp,index-1); // not take the coin at index
        int take = (int) 1e9; // initialize take as infinity
        if(coins[index] <= target)  // can take the coin if it does not exceed the target
            take = 1 +  coinChangeMemo(coins,target-coins[index],dp,index); 
        
        int minimum = Math.min(take , notTake); // minimum of take and not take
        dp[index][target] = minimum; // store in dp table
        return minimum;
    }
}