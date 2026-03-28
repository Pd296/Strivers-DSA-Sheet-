/*
  
  Problem Link : https://leetcode.com/problems/minimum-falling-path-sum/description/
  Date : 16th October 2025
  
 */


class Solution {
    public int minFallingPathSum(int[][] matrix) {

        int n = matrix.length;
        int[][] dp = new int[n][n];
        for (int[] arr : dp)
            Arrays.fill(arr, -1);
        
        //memoization runs into TLE for larger n value

        // int minimumFallingSum = Integer.MAX_VALUE;
        // for(int col=0;col<n;col++){
        //     int minimumColSum = minFallingPathSumMemo(matrix,dp,n-1,col);
        //     minimumFallingSum = Math.min(minimumFallingSum,minimumColSum);
        // }
         
        //tabulation method
        int minimumFallingSum = minFallingPathSumTabulation(matrix, dp);
        return minimumFallingSum;
    }

    private int minFallingPathSumTabulation(int[][] matrix, int[][] dp) {
        int n = matrix.length;
        // base case: fill the first row of dp with the first row of matrix
        for (int column = 0; column < n; column++)
            dp[0][column] = matrix[0][column];

        // fill the dp table
        for (int currRow = 1; currRow < matrix.length; currRow++) {
            for (int currCol = 0; currCol < n; currCol++) {

                int currentValue = matrix[currRow][currCol];
                int minFallingPathSum = Integer.MAX_VALUE;

                // check all three possible paths from the above row
                for (int pathColumn = -1; pathColumn <= 1; pathColumn++) {
                    int aboveRowColumn = currCol + pathColumn;
                    if (aboveRowColumn >= matrix[0].length || aboveRowColumn < 0)
                        continue; // skip out of bounds

                    // calculate the falling path sum for the current path
                    int currentMinFallingPathSum = currentValue
                            +
                            dp[currRow - 1][aboveRowColumn];

                    // update the minimum falling path sum
                    minFallingPathSum = Math.min(currentMinFallingPathSum, minFallingPathSum);
                }
                // store the result in dp table
                dp[currRow][currCol] = minFallingPathSum;
            }
        }
        
        // find the minimum value in the last row of dp table
        int minimum = Integer.MAX_VALUE;
        for (int ele : dp[n - 1])
            minimum = Math.min(ele, minimum);
        return minimum;
    }

    private int minFallingPathSumMemo(int[][] matrix, int[][] dp, int row, int col) {

        if (row == 0)
            return matrix[row][col];
        if (dp[row][col] != -1)
            return dp[row][col];

        int currentValue = matrix[row][col];
        int minFallingPathSum = Integer.MAX_VALUE;
        for (int pathColumn = -1; pathColumn <= 1; pathColumn++) {
            int aboveRowColumn = col + pathColumn;
            if (aboveRowColumn >= matrix[0].length || aboveRowColumn < 0)
                continue;

            int currentMinFallingPathSum = currentValue
                    +
                    minFallingPathSumMemo(matrix, dp, row - 1, aboveRowColumn);
            minFallingPathSum = Math.min(currentMinFallingPathSum, minFallingPathSum);
        }

        dp[row][col] = minFallingPathSum;
        return minFallingPathSum;
    }
}