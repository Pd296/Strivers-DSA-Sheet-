/*

   Problem Link : https://leetcode.com/problems/number-of-longest-increasing-subsequence/description/
   Date : 17th Mar 2026

 */


class Solution {
    public int findNumberOfLIS(int[] nums) {
        
        int n = nums.length;
        int[] dp = new int[n];
        int[] count = new int[n];

        Arrays.fill(dp,1); // every element is a subsequence of length 1
        Arrays.fill(count,1); // every subsequence of any length has at least one way to be formed 

        int max = 1; // length of longest increasing subsequence

        for(int ind=1;ind<n;ind++){
            for(int prev=0;prev<ind;prev++){
                 
                // if the current element is greater than the previous element 
                // and including it increases the length of the subsequence
                if(nums[ind] > nums[prev] && 1 + dp[prev] > dp[ind]){
                    dp[ind] = 1 + dp[prev];
                    count[ind] = count[prev]; //inherit the count from the previous index
                }else if(nums[ind] > nums[prev] && 1 + dp[prev] == dp[ind]){
                    count[ind] += count[prev]; // if we find another subsequence of the same length, we add its count to the current index
                }
            }

            if(dp[ind] > max) max = dp[ind]; // update max if we found a longer subsequence
            
        }
        
        int numberOfWays = 0;
        for(int i=0;i<n;i++){
            // if the length of the longest increasing subsequence 
            //  at index i is equal to max, we add the count of that index to the number of ways
            if(dp[i] == max ) numberOfWays += count[i];
        }

        return numberOfWays;
    }
}
