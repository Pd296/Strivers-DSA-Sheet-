/*
Date : 8th July 2025
Problem Link : https://leetcode.com/problems/subsets-ii/
 */
 
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        recurse(result,new ArrayList<Integer>(),nums,0,nums.length);
        return result;
        
    }
    private void recurse(List<List<Integer>> result,List<Integer> list,int[] nums,int index,int sizeOfArray){


        if(index == sizeOfArray){
            result.add(new ArrayList<>(list));
            return;
        }

        int currentElement=nums[index];
        //take the element
        list.add(currentElement);
        recurse(result,list,nums,index+1,sizeOfArray);

        //avoid duplicates
        while(index < nums.length-1 && nums[index]==nums[index+1]) index += 1;

        //don't take the element
        list.remove(list.size()-1);
        recurse(result,list,nums,index+1,sizeOfArray);

    }
}