/*

   Problem Link : https://www.geeksforgeeks.org/problems/perfect-sum-problem5633/1
   Date : 25th October 2025

 */

class Solution {
    public int perfectSum(int[] nums, int target) {
        //int n = nums.length;
        //int[][] dp = new int[n][target + 1];
        //for (int[] nums : dp) numsays.fill(nums, -1);
        //return isSubsetSumRecurse(nums, target, n - 1, dp);
        return isSubsetSumBottomUp(nums,target);
    }

    private static int isSubsetSumRecurse(int[] nums, int target, int index, int[][] dp) {
        
        if (index == 0) {
            if (target == 0 && nums[0] == 0) return 2;  // two ways: pick or not pick
            if (target == 0 || target == nums[0]) return 1; 
            return 0;
        }
        
        if (dp[index][target] != -1) return dp[index][target]; // memoization

        int skip = isSubsetSumRecurse(nums, target, index - 1, dp);
        int pick = 0;
        if (nums[index] <= target) // can pick the element if it does not exceed the target
            pick = isSubsetSumRecurse(nums, target - nums[index], index - 1, dp);

        dp[index][target] = pick + skip; // total ways
        return dp[index][target];
    }
    
    // Date : 25th Feb 2026
    
    // Bottom-Up DP approach
    private int isSubsetSumBottomUp(int[] nums,int target){
        
        int n = nums.length;
        int[][] dp = new int[n][target+1];
        if(nums[0] == 0) dp[0][nums[0]] = 2;
        else {
            for(int tar=0;tar<=target;tar++)
                if(tar == 0 || tar==nums[0]) dp[0][tar] = 1;
        }
        
        for(int ind = 1 ; ind < n ; ind++){
            for(int t = 0; t <= target ; t++){
                
                int skip = dp[ind-1][t];
                int pick = 0;
                if (nums[ind] <= t) // can pick the element if it does not exceed the target
                    pick = dp[ind-1][t - nums[ind]];
        
                dp[ind][t] = pick + skip; // total ways
                
            }
        }
        
        return dp[n-1][target];
    }
    
}
