/*
Date : 21st June 2025
Problem link : https://leetcode.com/problems/majority-element-ii/description/
*/

#include<bits/stdc++.h>
class Solution {
public:
    vector<int> majorityElementTwo(vector<int>& nums) {
        // unordered_map <int, int> mp;
        // int n = nums.size();
        // vector<int> res;
        // for(int i = 0;i < nums.size();i++) {
        //     mp[nums[i]]++;
        // }
        // for(auto i:mp) {
        //     if(i.second > n/3) {
        //         res.push_back(i.first);
        //     }
        // }
        // return res;

        int cnt1 = 0;
        int cnt2 = 0;
        int e1 = INT_MIN;
        int e2 = INT_MIN;
        int n = nums.size();
        for(int i = 0;i < n;i++) {
            if(cnt1 == 0 && nums[i] != e2) {
                cnt1++;
                e1 = nums[i];
            }
            else if(cnt2 == 0 && nums[i] != e1) {
                cnt2++;
                e2 = nums[i];
            }
            else if(e1 == nums[i]) {
                cnt1++;
            }
            else if(e2 == nums[i]) {
                 cnt2++;
            }
            else {
                cnt1--;
                cnt2--;
            }
        }
        int c1 = 0, c2 = 0;
        for(int i = 0;i < n;i++) {
            if(nums[i] == e1) {
                c1++;
            }
            else if(nums[i] == e2) {
                c2++;
            }
        }
        vector<int> a;
        if(c1 > n/3) {
            a.push_back(e1);
        }
        if(c2 > n/3) {
            a.push_back(e2);
        }
        return a;
    }
};
