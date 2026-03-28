/*

   Problem Link : https://www.geeksforgeeks.org/problems/longest-common-substring1452/1
   Date : 27th Feb 2026

 */

class Solution {
    public int longCommSubstr(String s1, String s2) {
  
        int len1 = s1.length();
        int len2 = s2.length();
        
        int[][] dp = new int[len1+1][len2+1];
        for(int i=0;i<=len1;i++) dp[i][0]=0;  // base case
        for(int j=0;j<=len2;j++) dp[0][j]=0;  // base case
        
        int ans = 0;
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                
                // if the characters match, then we can extend the length of common substring by 1
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                     dp[i][j] = 1 + dp[i-1][j-1];
                     ans = Math.max(ans,dp[i][j]);
                // if the characters do not match, then we cannot extend the length of common substring, so we reset it to 0
                }else{
                     dp[i][j] = 0;
                } 
            }
        }
        
        return ans; // return the length of longest common substring
    }
}