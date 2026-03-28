/*
  
  Problem Link : https://leetcode.com/problems/house-robber-ii/
  Date : 13th October 2025
  
 */

class Solution {
    public int rob(int[] nums) {
        
        int n = nums.length;
        if(n==1) return nums[0]; //edge case if there is only one house
       
        int[] nums1 = Arrays.copyOfRange(nums, 0, n - 1);
        int[] nums2 = Arrays.copyOfRange(nums, 1, n );

        int[] dp1 = new int[nums1.length];
        int[] dp2 = new int[nums2.length];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);

        // both len1 and len2 are of same length ,
        // we don't require two variables actually .
        // but still to have a clean and consistent code I have intialized
        int len1 = nums1.length;
        int len2 = nums2.length; 


        int excludingLastIndex = houseRobberTopDown(dp1,nums1,len1-1); // exclude last house
        int excludingFirstIndex = houseRobberTopDown(dp2,nums2,len2-1); // exclude first house
        return Math.max(excludingLastIndex,excludingFirstIndex);
    }

    private int houseRobberTopDown(int[] dp,int[] nums,int n){
        
        if(n<0) return 0;
        if(n==0) return nums[0];
        if(dp[n] != -1) return dp[n];
        
        int robCurrentIndex = houseRobberTopDown(dp,nums,n-2) + nums[n];
        int skipCurrentIndex =  houseRobberTopDown(dp,nums,n-1) ;

        int maxRobbed = Math.max(robCurrentIndex,skipCurrentIndex);
        dp[n] = maxRobbed;
        return dp[n];
        
    }
}