// Problem Link : https://leetcode.com/problems/combination-sum/
class Solution {
public:

    void findCombination(int ind, vector<int>& candidates, int target, vector<vector<int>>& ans, vector<int>& temp) {
        if(ind == candidates.size()) {
            if(target == 0) {
                ans.push_back(temp);
            }
            return;
        }
        if(candidates[ind] <= target) {
            //we can pick the element
            temp.push_back(candidates[ind]);
            findCombination(ind, candidates, target-candidates[ind], ans, temp); // we can have one ele multiple times 
            temp.pop_back();
        }
        findCombination(ind+1, candidates, target, ans, temp);
    }
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<int> temp;
        vector<vector<int>> ans;
        int n = candidates.size();
        findCombination(0,candidates, target, ans, temp);
        return ans;
    }
};
