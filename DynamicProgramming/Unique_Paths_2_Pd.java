/* 

  Problem Link : https://leetcode.com/problems/unique-paths-ii/description/
  Date : 16th October 2025
  
 */

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];
        for(int[] arr : dp ) Arrays.fill(arr,-1);

        int maxWaysToReachEnd = uniquePathsMemoization(obstacleGrid,dp,m-1,n-1);
        return maxWaysToReachEnd;
    }

    private int uniquePathsMemoization(int[][] obstacleGrid,int[][] dp,int row,int col){

        if(row < 0 || col < 0) return 0; // out of bounds
        if(obstacleGrid[row][col] == 1 ) return 0; // cell is blocked
        if(row == 0 && col == 0 ){
             return 1;
        }

        if(dp[row][col] != -1 ) return dp[row][col]; // already calculated

        // calculate the number of ways to reach the current cell
        int WaysToReachCurrent = uniquePathsMemoization(obstacleGrid,dp,row,col-1) // coming from left 
                                 +
                                 uniquePathsMemoization(obstacleGrid,dp,row-1,col); // coming from up
        
        dp[row][col] = WaysToReachCurrent; // store the result
        return WaysToReachCurrent;
    }
}