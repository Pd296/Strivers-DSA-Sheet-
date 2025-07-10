// Problem Link : https://leetcode.com/problems/combination-sum-ii/

class Solution {
public:
    void findCombination(int ind, vector<int> candidates, int target, vector<vector<int>>& ans, vector<int>& temp) {
        if(target == 0) {
                ans.push_back(temp);
        }
        for(int i = ind; i < candidates.size(); i++) {
            //skip duplicates
            if(i > ind && candidates[i] == candidates[i-1]) continue;
            if(candidates[i] > target) break;
            temp.push_back(candidates[i]);
            findCombination(i+1, candidates, target-candidates[i], ans, temp);
            temp.pop_back();

        }
    }
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        sort(candidates.begin(), candidates.end());
        vector<vector<int>> ans;
        vector<int> temp;
        findCombination(0, candidates, target, ans, temp);
        return ans;
    }
};
