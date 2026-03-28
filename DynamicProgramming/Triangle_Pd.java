/*

    * Problem Link : https://leetcode.com/problems/triangle/description/
    * Date : 16th October 2025
    
 */

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
    int n = triangle.size();
    int[][] dp = new int[n][n];
    for(int[] arr : dp ) Arrays.fill(arr,-1); // initialize dp array with -1

    int minPathSum = Integer.MAX_VALUE;
    // find the minimum path sum to reach bottom row at each column
    for(int col=0;col<n;col++){
        int currColumnSum = minimumTotalMemoization(triangle,dp,n-1,col); 
        minPathSum = Math.min(minPathSum,currColumnSum);
    }
    
    return minPathSum;
    }

    private int minimumTotalMemoization(List<List<Integer>> triangle,int[][] dp,int row,int col){
      if(row == 0 ) return triangle.get(0).get(0); // base case: top of the triangle
      if(dp[row][col] != -1 ) return dp[row][col]; // already calculated

      int currGridValue = triangle.get(row).get(col); 

      int comingFromStraightUp = Integer.MAX_VALUE;
      if (col < triangle.get(row - 1).size()) // check if coming from valid position
      comingFromStraightUp =  currGridValue + minimumTotalMemoization(triangle,dp,row-1,col);
      int comingFromLeftUp = Integer.MAX_VALUE;

      if(col > 0) // check if coming from valid position
      comingFromLeftUp  =  currGridValue + minimumTotalMemoization(triangle,dp,row-1,col-1);
    
      int minPathSumUptoCurrent = Math.min(comingFromLeftUp,comingFromStraightUp); // minimum path sum to reach current cell

      dp[row][col] =  minPathSumUptoCurrent; // store the result in dp array
      return minPathSumUptoCurrent; 
    }
}