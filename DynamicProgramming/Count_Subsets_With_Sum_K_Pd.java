/*

   Problem Link : https://www.geeksforgeeks.org/problems/perfect-sum-problem5633/1
   Date : 25th October 2025

 */

class Solution {
    public int perfectSum(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n][target + 1];
        for (int[] arr : dp) Arrays.fill(arr, -1);
        return isSubsetSumRecurse(nums, target, n - 1, dp);
    }

    private static int isSubsetSumRecurse(int[] arr, int target, int index, int[][] dp) {
        

        if (index == 0) {
            if (target == 0 && arr[0] == 0) return 2;  // two ways: pick or not pick
            if (target == 0 || target == arr[0]) return 1; 
            return 0;
        }
        
        if (dp[index][target] != -1) return dp[index][target]; // memoization

        int skip = isSubsetSumRecurse(arr, target, index - 1, dp);
        int pick = 0;
        if (arr[index] <= target) // can pick the element if it does not exceed the target
            pick = isSubsetSumRecurse(arr, target - arr[index], index - 1, dp);

        dp[index][target] = pick + skip; // total ways
        return dp[index][target];
    }
}
