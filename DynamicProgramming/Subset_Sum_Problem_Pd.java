/*

      Problem Link : https://www.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1
      Date : 17th October 2025

*/

class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        int n = arr.length;
        Boolean[][] dp = new Boolean[n][sum + 1];
        return isSubsetSumRecurse(arr, sum, 0, 0, n, dp); // start from index 0 and current sum 0
    }

    private static Boolean isSubsetSumRecurse(int[] arr, int sum, int currSum, int index, int n, Boolean[][] dp) {
        if (currSum == sum) return true; // found a subset with the given sum
        if (index >= n || currSum > sum) return false; // out of bounds or exceeded sum

        if (dp[index][currSum] != null) return dp[index][currSum]; // already calculated

        boolean pick = isSubsetSumRecurse(arr, sum, currSum + arr[index], index + 1, n, dp); // pick the current element
        boolean skip = isSubsetSumRecurse(arr, sum, currSum, index + 1, n, dp); // skip the current element

        return dp[index][currSum] = pick || skip; // store the result in dp array
    }
}
