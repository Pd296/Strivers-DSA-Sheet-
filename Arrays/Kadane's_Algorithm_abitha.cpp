/*
Date : 21st June 2025
Problem link : https://leetcode.com/problems/maximum-subarray/
*/

class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int maxi;
        int res = nums[0];
        int n = nums.size();
        for(int i = 1;i < n;i++) {
            nums[i] = max(nums[i-1]+nums[i], nums[i]);
            res = max(nums[i], res);
        }
        return res;
    }
    // int maxSubArray(vector<int>& nums) {
    //     int n = nums.size();
    //     for(int i = 1;i < n;i++) {
    //         nums[i] += nums[i-1];
    //     }
    //     int maxi = INT_MIN;
    //     for(int i = 0;i < n;i++) {
    //         for(int j = i;j < n;j++) {
    //             int sum = (i == 0) ? (nums[j]) : (nums[j]-nums[i-1]);
    //             // cout << sum << " " << "i is" << i << "j is " << j << '\n'; 
    //             maxi = max(maxi, sum);
    //             // cout << "maxi is" << maxi << '\n';
    //         }
    //     }
    //     return maxi;
    // }

    // O(n^2)
};

// 2 3 -8 7 -1 2 3

// m = 2 5 -3 7 6 8 11
// r = 2 5 5 7 7 8 11

// 2 5 -3
