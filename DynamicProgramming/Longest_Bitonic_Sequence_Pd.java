/*

   Problem Link : https://www.geeksforgeeks.org/problems/longest-bitonic-subsequence0824/1
   Date : 17th Mar 2026

 */

import java.util.function.BiPredicate;
class Solution {
    
    public static int longestBitonicSequence(int n, int[] nums) {
        // code here
        
        int[] dp1 = longestSubsequenceFromStart(nums); // increasing from start
        int[] dp2 = longestSubsequenceFromEnd(nums);// increasing from end

        int ans = 0;
        for(int i = 0; i < n; i++) {
            if(dp1[i] > 1 && dp2[i] > 1) { // valid peak
                ans = Math.max(ans, dp1[i] + dp2[i] - 1);
            }
        }
        return ans;
                    
    }
    
    private static int[] longestSubsequenceFromStart(int[] nums){
        int n = nums.length;
        int[] dp = new int[n];
        
        Arrays.fill(dp,1); // every element is a subsequence of length 1
        int max = 1;
        for(int ind=1;ind<n;ind++){
            for(int prev=0;prev<ind;prev++){
                 
                if(nums[prev] < nums[ind]  && 1 + dp[prev] > dp[ind]){
                    dp[ind] = 1 + dp[prev];
                }
            }
        }
        
        return dp;
    }
    
    private static int[] longestSubsequenceFromEnd(int[] nums){
        int n = nums.length;
        int[] dp = new int[n];
        
        Arrays.fill(dp,1); // every element is a subsequence of length 1
        int max = 1;
        for(int ind=n-2;ind>=0;ind--){
            for(int prev=n-1;prev>ind;prev--){
                 
                if(nums[prev] < nums[ind] && 1 + dp[prev] > dp[ind]){
                    dp[ind] = 1 + dp[prev];
                }
            }
        }
        
        return dp;
    }

}
