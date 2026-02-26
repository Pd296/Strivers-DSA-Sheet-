/*

   Problem Link : https://leetcode.com/problems/longest-common-subsequence/description/
   Date : 3rd November 2025
   Revision Date : 26th February 2026

 */

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1][len2];
        for(int[] arr : dp ) Arrays.fill(arr,-1);
        //return lcsTopDown(text1,text2,len1-1,len2-1,dp);
        return lcsBottomUp(text1,text2);
    }

    private int lcsTopDown(String s1,String s2,int ind1,int ind2,int[][] dp){

        if(ind1 < 0 || ind2 < 0 ) return 0;
        if(dp[ind1][ind2] != -1 ) return dp[ind1][ind2];
        int match = 0;
        int notMatch = 0;
        if(s1.charAt(ind1) == s2.charAt(ind2))
             match = 1 + lcsTopDown(s1,s2,ind1-1,ind2-1,dp);
        else{
             notMatch=Math.max(
                            lcsTopDown(s1,s2,ind1,ind2-1,dp),
                            lcsTopDown(s1,s2,ind1-1,ind2,dp)
                              );
        }
    
        int maxLcs = Math.max(match,notMatch);
        dp[ind1][ind2] = maxLcs;
        return maxLcs;
    }
   
    private int lcsBottomUp(String text1,String text2){

        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1+1][len2+1];
        
        for(int i=0;i<=len1;i++) dp[i][0] = 0;
        for(int j=0;j<=len2;j++) dp[0][j] = 0;

        for(int ind1 = 1;ind1 <= len1 ; ind1++){
            for(int ind2 = 1 ;ind2 <= len2 ; ind2++){
                
                int match=0;
                int notMatch=0;
                if(text1.charAt(ind1-1) == text2.charAt(ind2-1))
                    match = 1 + dp[ind1-1][ind2-1];
                else{
                    notMatch=Math.max(
                                    dp[ind1][ind2-1],
                                    dp[ind1-1][ind2]
                                    );
                }
            
                int maxLcs = Math.max(match,notMatch);
                dp[ind1][ind2] = maxLcs;   
            }
        }

        return dp[len1][len2];
    }
}