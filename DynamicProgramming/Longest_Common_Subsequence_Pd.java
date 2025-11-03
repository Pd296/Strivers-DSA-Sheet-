/*

   Problem Link : https://leetcode.com/problems/longest-common-subsequence/description/
   Date : 3rd November 2025

 */

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n][m];
        for(int[] arr : dp ) Arrays.fill(arr,-1);
        return lcsMemo(text1,text2,n-1,m-1,dp);
    }

    private int lcsMemo(String s1,String s2,int index1,int index2,int[][] dp){
         
        if(index1 < 0 || index2 < 0 ) return 0;

        if(dp[index1][index2] != -1 ) return dp[index1][index2];
     
        //matching case 
        int matchCase = 0;
        if( s1.charAt(index1) == s2.charAt(index2) ){
            matchCase = 1 + lcsMemo(s1,s2,index1-1,index2-1,dp);
            dp[index1][index2]=matchCase;
        }else{
        int notMatchCase = Math.max(
                           lcsMemo(s1,s2,index1-1,index2,dp),
                           lcsMemo(s1,s2,index1,index2-1,dp)
                          );
            dp[index1][index2] = notMatchCase;
        }
        
        return dp[index1][index2];

    }
}