Problem Link : https://leetcode.com/problems/house-robber/



class Solution {
public:
    int maxRob(vector<int>& dp, vector<int> nums, int ind) {
        if(ind < 0) return 0;
        if (ind == 0) return nums[0];
        if(dp[ind] != -1)   return dp[ind];
        int pick = nums[ind] + maxRob(dp, nums, ind-2);
        int notPick = maxRob(dp, nums, ind-1);
        dp[ind] = max(pick, notPick);
        return dp[ind];
    }
    int rob(vector<int>& nums) {
        int n = nums.size();
        vector<int> dp(n, -1);
        return maxRob(dp, nums, n-1); //start from end
        
    }
};
