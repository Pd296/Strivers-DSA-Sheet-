/*

    Problem Link: https://leetcode.com/problems/climbing-stairs/
    Date : 13th October 2025
    
 */

class Solution {
    public int climbStairs(int n) {
        
        if(n < 2) return 1; // base case

        int numberOfWaysToReachStepPrev2 = 1; // to store the number of ways to reach the step (i-2)
        int numberOfWaysToReachStepPrev = 1; // to store the number of ways to reach the step (i-1)
        int numberOfWaysToReachStep = 0; // to store the number of ways to reach the current step
        
        // iterating from step 2 to step n
        for(int i=2;i<=n;i++){
            numberOfWaysToReachStep = numberOfWaysToReachStepPrev2 + numberOfWaysToReachStepPrev;
            numberOfWaysToReachStepPrev2 = numberOfWaysToReachStepPrev;
            numberOfWaysToReachStepPrev = numberOfWaysToReachStep;
        }

        return numberOfWaysToReachStep;
    }
}