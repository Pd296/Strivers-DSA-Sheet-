/*
Date : 27th June 2025 
Problem link : https://leetcode.com/problems/maximum-product-subarray/
*/

class Solution {
public:
    int maxProduct(vector<int>& nums) {
        int maxi = INT_MIN;
        int p = 0;
        int s = 0;
        int n = nums.size();
        for(int i = 0;i < n;i++) {
            if(p == 0) { p =1;}
            if(s == 0) { s = 1;}
            p = p * nums[i];
            s = s * nums[n-i-1];

            maxi = max(maxi, max(p,s));
        }
        return maxi;
        
    }
};
