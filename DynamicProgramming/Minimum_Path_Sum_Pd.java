/*

    * Problem Link : https://leetcode.com/problems/minimum-path-sum/description/
    * Date : 16th October 2025
    
 */

class Solution {
    public int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int[] arr : dp ) Arrays.fill(arr,-1); // initialize dp array with -1

        int minPathSum = minPathSumMemoization(grid,dp,m-1,n-1); // find the minimum path sum to reach bottom-right cell
        return minPathSum;  
    }

    private int minPathSumMemoization(int[][] grid,int[][] dp,int row,int col){

        if(row == 0 && col == 0) return grid[0][0]; // base case: starting cell
        if(dp[row][col] != -1 ) return dp[row][col]; // already calculated
        
        int currGridValue = grid[row][col] ; 
        
        int comingFromLeft = Integer.MAX_VALUE;
        if(col > 0) // check if not in Zeroth column and then only go left
        comingFromLeft =  currGridValue +  minPathSumMemoization(grid,dp,row,col-1); 
        int comingFromUp = Integer.MAX_VALUE;
        if(row > 0) // check if not in Zeroth row and then only go up
        comingFromUp  =  currGridValue + minPathSumMemoization(grid,dp,row-1,col);

        // minimum path sum to reach current cell
        int minPathSumUptoCurrent = Math.min(comingFromLeft,comingFromUp); 
        

        dp[row][col] =  minPathSumUptoCurrent; // store the result in dp array
        return minPathSumUptoCurrent; 
    }
}