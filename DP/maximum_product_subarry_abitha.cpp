// problem link : https://leetcode.com/problems/maximum-product-subarray/submissions/1805731227/
// Date : 19th October 2025

class Solution {
public:
    int maxProduct(vector<int>& nums) {
        int maxi = INT_MIN;
        int prefixSum = 1, suffixSum = 1;
        int n = nums.size();
        for(int i = 0;i < n;i++) {
            if(prefixSum == 0) { prefixSum = 1;}
            if(suffixSum == 0) { suffixSum = 1;}
            prefixSum *= nums[i];
            suffixSum *= nums[n-1-i];
            maxi = max(maxi, max(prefixSum, suffixSum));
        }
        return maxi;
        
    }
};
