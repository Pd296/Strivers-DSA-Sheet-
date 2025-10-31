/*

   Problem Link : https://leetcode.com/problems/coin-change-ii/description/
   Date : 31st October 2025

 */

class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] arr : dp ) Arrays.fill(arr,-1);
        int answer = coinChangeMemo(coins,amount,dp,n-1);
        return answer;
    }
    private int coinChangeMemo(int[] coins,int target,int[][] dp,int index){
        
        if(index == 0){
            if( target % coins[0] == 0  ) return 1; // can make the amount
            else return 0; // cannot make the amount
        }
        
        if(dp[index][target] != -1 ) return dp[index][target];

        int notTake = coinChangeMemo(coins,target,dp,index-1); // not take the coin at index
        int take = 0;  // initialize take as 0
        if(coins[index] <= target)  // can take the coin if it does not exceed the target
            take =  coinChangeMemo(coins,target-coins[index],dp,index);
        
        int ways = take + notTake; // total ways by taking and not taking
        dp[index][target] = ways; // store in dp table
        return ways;    
    }
}



