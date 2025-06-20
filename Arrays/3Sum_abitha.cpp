/*
Date : 20th June 2025 
Problem link : https://leetcode.com/problems/3sum/
*/

class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        int n = nums.size();
        vector<vector<int>> res;
        set<vector<int>> s;
        sort(nums.begin(), nums.end());
        for(int i = 0;i < n; i++) {
            int j = i+1;
            int k = n-1;
            while(j < k) {
                int tsum = nums[i]+nums[j]+nums[k];
                if(tsum == 0) {
                    s.insert({nums[i], nums[j], nums[k]});
                    j++;
                    k--;
                }
                else if(tsum < 0) {
                    j++;
                }
                else{
                    k--;
                }
            }
        }
        for(auto i: s) {
            res.push_back(i);
        }
        return res;
        
    }
};
