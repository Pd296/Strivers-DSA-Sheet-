/*

Date : 21st June 2025
Problem link : https://leetcode.com/problems/maximum-subarray/

*/

class Solution {
    public int maxSubArray(int[] nums) {
        
        int n = nums.length;
        int globalMax = nums[0];
        int sum = nums[0];

        for(int i=1;i<n;i++){
            int currentElement = nums[i];
            if(sum < 0) sum = currentElement;
            else sum += currentElement;

            globalMax=Math.max(sum,globalMax);
        }
        return globalMax;
    }
}

/*
array = [-2,1,-3,4,-1,2,1,-5,4]

sum=arr[0], globalMax=arr[0]
for i=1 to n-1
if(sum < 0 ) sum = currentElement
else {
    sum+=currentElement;
}
globalMax=Math.max(sum,globalMax)



*/