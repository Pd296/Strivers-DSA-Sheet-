// Problem Link : https://leetcode.com/problems/longest-increasing-subsequence/
// Date : 19th Oct 2025


class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        int n = nums.size();
        if (n == 1) return 1;
        vector<int> dp(n, 1);
        int maxi = INT_MIN;
        for(int i = 1;i < n;i++) {
            for(int j = 0;j < i;j++) {
                if(nums[i] > nums[j]) { //we can extend the LIS that ends at j
                    dp[i] = max(dp[i], dp[j] + 1);
                }
            }
            maxi = max(maxi, dp[i]);
        }
        return maxi;
    }
};

// TC : n*n
// sc : n
// dp stores the max length of increasing subsequence which ends at index i. 
