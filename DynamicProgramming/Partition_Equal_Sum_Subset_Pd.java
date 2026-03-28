/*

   Problem Link : https://leetcode.com/problems/partition-equal-subset-sum/
   Date : 22nd October 2025

 */

class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        for(int ele : nums ) totalSum += ele;
        // if total sum is odd, cannot partition into two equal subsets
        if( totalSum % 2 == 1 ) return false; 
     
        int targetSum = totalSum / 2;
        Boolean[][] dp = new Boolean[n][targetSum+1]; // memoization array

        // check if there's a subset with sum equal to targetSum
        return isSubsetSumRecurse(nums,targetSum,0,0,n,dp); 
    }
    
    // Helper function to check for subset sum using recursion with memoization
    private static Boolean isSubsetSumRecurse(int[] arr, int sum, int currSum, int index, int n, Boolean[][] dp) {
        if (currSum == sum)
            return true;
        if (index >= n || currSum > sum)
            return false;

        if (dp[index][currSum] != null)
            return dp[index][currSum];

        boolean pick = isSubsetSumRecurse(arr, sum, currSum + arr[index], index + 1, n, dp);
        boolean skip = isSubsetSumRecurse(arr, sum, currSum, index + 1, n, dp);

        return dp[index][currSum] = pick || skip;
    }
}