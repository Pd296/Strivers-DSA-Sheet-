/*

   Problem Link : https://leetcode.com/problems/distinct-subsequences/description/
   Date : 1st Mar 2026

 */

class Solution {
    public int numDistinct(String s, String t) {
        
        // int len1 = s.length();
        // int len2 = t.length();
        // int[][] dp = new int[len1][len2];
        // for(int[] arr: dp ) Arrays.fill(arr,-1);
        // return distinctSubsequencesTopDown(len1-1,len2-1,s,t,dp);  

        return distinctSubsequencesBottomUp(s,t);
    }

    private int distinctSubsequencesTopDown(int i,int j,String s,String t,int[][] dp){
        if(j<0) return 1;
        if(i<0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(s.charAt(i) == t.charAt(j)){
            dp[i][j] = distinctSubsequencesTopDown(i-1,j-1,s,t,dp)
                         +
                       distinctSubsequencesTopDown(i-1,j,s,t,dp);
        }else{
            dp[i][j] = distinctSubsequencesTopDown(i-1,j,s,t,dp);
        }

        return dp[i][j];
 
    }

    private int distinctSubsequencesBottomUp(String s,String t){

        int len1 = s.length();
        int len2 = t.length();
        int[][] dp = new int[len1+1][len2+1];

        for(int col=0;col<=len2;col++) dp[0][col] = 0;
        for(int row=0;row<=len1;row++) dp[row][0] = 1;

        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                   dp[i][j]  = dp[i-1][j-1] + dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[len1][len2];
    }
}