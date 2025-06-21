/*
Date : 21st June 2025
Problem link : https://leetcode.com/problems/majority-element-ii/description/
*/

#include<bits/stdc++.h>
class Solution {
public:
    vector<int> majorityElementTwo(vector<int>& nums) {
        unordered_map <int, int> mp;
        int n = nums.size();
        vector<int> res;
        for(int i = 0;i < nums.size();i++) {
            mp[nums[i]]++;
        }
        for(auto i:mp) {
            if(i.second > n/3) {
                res.push_back(i.first);
            }
        }
        return res;
    }
};
