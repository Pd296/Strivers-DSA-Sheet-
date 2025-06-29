/*
Date : 28th June 2025
Problem Link : https://takeuforward.org/plus/dsa/problems/find-the-repeating-and-missing-number
*/

class Solution {
    public int[] findMissingRepeatingNumbers(int[] nums) {
         
        int n = nums.length;
        long totalSum = n*(n+1)/2;
        long totalSquareSum = n*(n+1)*(2*n+1)/6;
        
        long currSum = 0;
        long currSquareSum=0;
        for(int i=0;i<n;i++){
              currSum += nums[i];
              currSquareSum += nums[i]* nums[i];
        }

        //first equation -> x - y 
        // x=> repeatingNumber , y=> missingNumber
        long val1 = currSum - totalSum; // x- y

        //second equation -> x^2 - y^2
        long val2 = currSquareSum - totalSquareSum;
        
        // x^2- y^2 = (x-y) * (x+y)
        long val3 = val2 / val1 ; // x+y

        long x  = (val1 + val3) /2 ; 
        long y = x - val1;

        return new int[]{(int)x,int()y};
    }
}