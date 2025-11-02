/*

   Problem Link : https://www.geeksforgeeks.org/problems/knapsack-with-duplicate-items4201/1
   Date : 2nd November 2025

 */

class Solution {
    static int knapSack(int val[], int wt[], int capacity) {
        // code here
        
        int n = val.length;
        int[][] dp = new int[n][capacity+1];
        for(int[] arr : dp ) Arrays.fill(arr,-1);
        int answer = knapSackMemo(val,wt,dp,capacity,n-1);
        return answer < 0 ? 0 : answer;
        
    }
    private static int knapSackMemo(int[] val,int[] wt,int[][] dp,int target,int index){
        
        if (target == 0) return 0; // no capacity left 
        if (index == 0) {
            return (target / wt[0]) * val[0]; // can take as many of item 0 as possible
        }
        
        if(dp[index][target] != -1 ) return dp[index][target]; // return already computed value
        int value = val[index]; // value of current item

        int notTake = knapSackMemo(val,wt,dp,target,index-1);  // not take the item at index
        int take = 0;
        if(wt[index] <= target) // can take the item if it does not exceed the target
            take = value + knapSackMemo(val,wt,dp,target-wt[index],index);
        
        int max = Math.max(notTake , take ); // maximum value by taking and not taking
        dp[index][target] = max; // store in dp table
        return max;
        
    }
}