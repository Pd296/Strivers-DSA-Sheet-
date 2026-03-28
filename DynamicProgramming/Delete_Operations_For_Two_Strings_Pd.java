/*

   Problem Link : https://leetcode.com/problems/delete-operation-for-two-strings/description/
   Date : 27th Feb 2026

 */

class Solution {
    public int minDistance(String word1, String word2) {
        
     /*
       Idea is to keep the LCS of two strings intact . 
       
       Delete the rest of the characters (other than LCS) from word1
       Delete the rest of the characters (other than LCS) from word2
       
       int len1 = word1.length;
       int len2 = word2.length;

       Formuala => ans = (len1 - LCS) + (len2 - LCS) =>  len1+len2 - 2*LCS 

     */
        
        int len1 = word1.length();
        int len2 = word2.length();
  
        int answer = len1+len2 - 2*lcsBottomUp(word1,word2) ;
        return answer;

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