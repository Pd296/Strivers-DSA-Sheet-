
//date-8-jul-2025
//problem link-https://leetcode.com/problems/combination-sum/description/

class Solution {
    void helper (int[] candidates,int target,int cur_sum,int i,List<Integer> temp,List<List<Integer>> ans){
        if(cur_sum>target || i>=candidates.length) return;
        if(cur_sum==target){
            ans.add(new ArrayList<>(temp));
            return;
        }
        temp.add(candidates[i]);
        helper(candidates,target,cur_sum+candidates[i],i,temp,ans);
        //helper(candidates,target,cur_sum+candidates[i],i+1,temp,ans);
        temp.remove(temp.size()-1);
        helper(candidates,target,cur_sum,i+1,temp,ans);
        return;
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        helper(candidates,target,0,0,temp,ans);
        return ans;
    }
}