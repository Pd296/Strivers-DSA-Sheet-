
//date-8-jul-2025
//link-https://leetcode.com/problems/combination-sum-ii/description/

class Solution {
    void helper (int[] candidates,int target,int cur_sum,int i,List<Integer> temp,List<List<Integer>> ans){
        if(cur_sum==target){
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(cur_sum>target || i>=candidates.length) return;
        
        temp.add(candidates[i]);
        //helper(candidates,target,cur_sum+candidates[i],i,temp,ans);
        helper(candidates,target,cur_sum+candidates[i],i+1,temp,ans);
        temp.remove(temp.size()-1);
        while(i<candidates.length-1 && candidates[i]==candidates[i+1]) i++;
        helper(candidates,target,cur_sum,i+1,temp,ans);
        return;
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates,target,0,0,temp,ans);
        return ans;
    }
}