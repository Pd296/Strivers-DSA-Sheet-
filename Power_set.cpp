#include<bits/stdc++.h>
class Solution {
public:	
    bool checkBit(int num, int i) {
        return (num & (1<<i)) == (1<<i);
    }
    vector<vector<int> > powerSet(vector<int>& nums) {
        //your code goes here
        int n = nums.length();
        vector<vector<int>> res;
        for(int i = 0;i < (1<<n);i++) {
            vector<int> temp;
            for(int j = 0; j < n; j++) {
                if(checkBit(i, j)) {
                    temp.push_back(nums[j]);
                }
            }
            res.push_back(temp);
        }
        return res;
    }
};
