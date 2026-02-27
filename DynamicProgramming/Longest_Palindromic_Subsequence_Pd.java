/*

   Problem Link : https://leetcode.com/problems/longest-palindromic-subsequence/description/
   Date : 27th Feb 2026

 */

/*
   I could have simply used the longest common subsequence code by 
   reversing the string and finding the longest common subsequence 
   between the original string and the reversed string 

   lcs(s,s.reverse()) => lps(s)
*/
class Solution {
    public int longestPalindromeSubseq(String s) {
        
        int len = s.length();
        int[][] dp = new int[len][len];
        for(int[] arr : dp ) Arrays.fill(arr,-1);
        //return lpsTopDown(s,s,0,len-1,dp);
        return lpsBottomUp(s);
    }

        private int lpsTopDown(String s1,String s2,int ind1,int ind2,int[][] dp){
        if(ind1 >= s1.length() || ind2 < 0 ) return 0;
        if( ind1 > ind2 ) return 0;
        if (ind1 == ind2) return 1 ;

        if(dp[ind1][ind2] != -1 ) return dp[ind1][ind2];
        int match = 0;
        int notMatch = 0;
        if(s1.charAt(ind1) == s2.charAt(ind2))
             match = 2 + lpsTopDown(s1,s2,ind1+1,ind2-1,dp);
        else{
             notMatch=Math.max(
                            lpsTopDown(s1,s2,ind1,ind2-1,dp),
                            lpsTopDown(s1,s2,ind1+1,ind2,dp)
                              );
        }
    
        int maxLcs = Math.max(match,notMatch);
        dp[ind1][ind2] = maxLcs;
        return maxLcs;
    }

    private int lpsBottomUp(String s){

       int len = s.length();
       int[][] dp = new int[len][len];

       for(int i=0;i<len;i++) dp[i][i] = 1; // base case 

       for(int i=len-1;i>=0;i--){
         for(int j=i+1;j<len;j++){
            if (s.charAt(i) == s.charAt(j))
               dp[i][j] = 2 + dp[i+1][j-1];
            else 
               dp[i][j] = Math.max( dp[i][j-1] , dp[i+1][j] );
         }
       }
        
         return dp[0][len-1];
    }
}

