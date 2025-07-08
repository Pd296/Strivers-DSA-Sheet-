/*

Date : 8th July 2025
Problem Link : https://leetcode.com/problems/combination-sum/

*/


class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        //Arrays.sort(candidates); not needed for this problem 
        List<List<Integer>> result = new ArrayList<>();
        recurse(result,new ArrayList<>(),candidates,target,0,0);
        return result;
    }

    private void recurse(List<List<Integer>> result,List<Integer> list , int[] candidates , int target , int index,int sum){
        
        if(index >= candidates.length) return ;
        if(sum > target ) return ;
        if(sum == target ){
            //System.out.println("Target Achieved : " + list);
            result .add(new ArrayList<>(list));
            return ;
        }

        int currentNumber = candidates[index];

        //pick the currentNumber 
        sum += currentNumber;
        list.add(currentNumber);
        recurse(result,list,candidates,target,index,sum);
        
        //remove the number
        sum -= currentNumber;
        list.remove(list.size()-1);
        recurse(result,list,candidates,target,index+1,sum);
    } 
}