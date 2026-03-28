/*
  
  Problem Link : https://www.naukri.com/code360/problems/ninja-s-training_3621003?interviewProblemRedirection=true&search=ninja&leftPanelTabValue=PROBLEM
  Date : 16th October 2025
  
 */

import java.util.Arrays;
public class Solution {
    public static int ninjaTraining(int n, int matrix[][]) {

        // dp[i][j] = maximum points earned till day i with last action j
        int[][] dp = new int[n][4];
        for(int[] arr : dp ) Arrays.fill(arr,-1);
        
        // lastAction = 3 means no action was performed on previous day
        int maxMeritPoints = ninjaTrainingMemoization(matrix,dp,n-1,3); 
        return maxMeritPoints;
    }

     private static int ninjaTrainingMemoization(int[][] matrix,int[][] dp,int currDay,int lastAction){

        // base case
        if(currDay == 0 ){
            int maxPointsEarnedDay0 = 0;
            for(int i=0;i<3;i++){
                if( i == lastAction) continue;
                int pointsEarnedDay0 = matrix[currDay][i];
                maxPointsEarnedDay0 = Math.max(maxPointsEarnedDay0,pointsEarnedDay0);
            }

            dp[currDay][lastAction]=maxPointsEarnedDay0;
            return maxPointsEarnedDay0;
        }
        
        // check if already calculated 
        if(dp[currDay][lastAction] != -1 ) return dp[currDay][lastAction];

        // calculate the maximum points earned
        int maxPointsEarned = 0;
        for(int i=0;i<3;i++){
             if( i == lastAction) continue;
             int pointsEarnedUptoThisDay = matrix[currDay][i] + ninjaTrainingMemoization(matrix,dp,currDay-1,i);
             maxPointsEarned = Math.max(maxPointsEarned,pointsEarnedUptoThisDay);
        }

        // store the result in dp array
        dp[currDay][lastAction] = maxPointsEarned;

        return maxPointsEarned;
    }

}