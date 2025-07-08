
//date-7-jul-2025
// link-https://leetcode.com/problems/subsets/description/

class Solution {
    void helper(int[] nums,List<Integer> temp,List<List<Integer>> ans,int i){
        if(i==nums.length){
            ans.add(new ArrayList(temp));
            return;
        }
        temp.add(nums[i]);
        helper(nums,temp,ans,i+1);
        temp.remove(temp.size()-1);
        helper(nums,temp,ans,i+1);
        return;
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        helper(nums,temp,ans,0);
        return ans;
    }
}