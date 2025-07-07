// Problem link : https://leetcode.com/problems/subsets/description/

class Solution {
public:
    bool checkBit(int ele, int bit) {
        return (ele & (1<<bit)) == (1<<bit);
    }
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> res;
        int n = nums.size();
        for(int i = 0;i < (1<<n);i++) {
            vector<int> ans;
            for(int j = 0;j < n; j++) {
                if(checkBit(i,j)) {
                    ans.push_back(nums[j]);
                }
            }
            res.push_back(ans);
        }
        return res;
    }
};


// 000
// 001
// 010
// 011
// 100
// 101
// 110
// 111
