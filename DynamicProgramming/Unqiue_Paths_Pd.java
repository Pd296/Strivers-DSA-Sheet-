/* 

  Problem Link : https://leetcode.com/problems/unique-paths/description/
  Date : 16th October 2025
  
 */

class Solution {
    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n];
        for(int[] arr : dp ) Arrays.fill(arr,-1);

        int maxWaysToReachEnd = uniquePathsMemoization(dp,m-1,n-1);
        return maxWaysToReachEnd;
    }

    private int uniquePathsMemoization(int[][] dp,int row,int col){

        if(row < 0 || col < 0) return 0;
        if(row == 0 && col == 0 ){
             return 1;
        }

        if(dp[row][col] != -1 ) return dp[row][col];

        int WaysToReachCurrent = uniquePathsMemoization(dp,row,col-1) // coming from left 
                                 +
                                 uniquePathsMemoization(dp,row-1,col); // coming from up
        
        dp[row][col] = WaysToReachCurrent;
        return WaysToReachCurrent;
    }
}