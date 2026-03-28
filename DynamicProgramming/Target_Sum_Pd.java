/*

   Problem Link : https://leetcode.com/problems/target-sum/description/
   Date : 1st November 2025

 */

class Solution {
    private int n = 0;
    private Map<String, Integer> memo = new HashMap<>(); // memoization map
    public int findTargetSumWays(int[] nums, int target) {
        n = nums.length;
        return findTargetWays(nums,0,target);
    }
    private int findTargetWays(int[] nums,int index,int target){
        
        // Base case
        if (index == n) { 
            return target == 0 ? 1 : 0; // if target is met, count as 1 way
        }

         // Memoization key
        String key = index + "," + target; // unique key for current state
        if (memo.containsKey(key)) return memo.get(key);

        // Choose +
        int add = findTargetWays(nums, index + 1, target - nums[index]); // add the current number

        // Choose -
        int subtract = findTargetWays(nums, index + 1, target + nums[index]); // subtract the current number
        int total = add + subtract; // total ways
        memo.put(key, total);
        return total;
    }
}
