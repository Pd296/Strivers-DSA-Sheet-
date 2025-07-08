/*

Date : 8th July 2025
Problem Link : https://leetcode.com/problems/combination-sum-ii/

 */

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        //candidates = candidates.filter( ele -> ele < target);
        recurse(result,new ArrayList<>(),candidates,target,0,0);
        return result;
    }

    private void recurse( List<List<Integer>> result,List<Integer> list,int[] candidates,int target,int sum,int index){
       
        if(sum > target ) return ;
        if(sum == target ){
            System.out.println("Target Achieved : list "+list);
            result.add(new ArrayList<>(list));
            return ;
        }

        if(index >= candidates.length) return;

        int currentNumber = candidates[index];
        // skip the number coz the sum will always be greater than target 
        if(currentNumber > target ) return;

        //pick the number 
        sum += currentNumber;
        list.add(currentNumber);
        recurse(result,list,candidates,target,sum,index+1);

        //remove the number
        sum -= currentNumber;
        list.remove(list.size()-1);
        
        //avoid duplicates
        while(index < candidates.length-1 && candidates[index]==candidates[index+1]) index++ ;

        recurse(result,list,candidates,target,sum,index+1);

    }
}