/*

   Problem Link : https://leetcode.com/problems/shortest-common-supersequence/description/
   Date : 28th Feb 2026

 */


class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        
        int[][] dp = lcsBottomUp(str1,str2); // returns the whole dp array
        String scs = findShortestCommonSuperSequence(dp,str1,str2);
        return scs;
    }
    
    // This function returns the whole dp array instead of just the 
    // length of LCS because we need the dp array to find the SCS string
    private int[][] lcsBottomUp(String text1,String text2){

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

        return dp;
    }
    
    // This function finds the SCS string using the dp array of LCS
    private String findShortestCommonSuperSequence(int[][] dp,String str1,String str2){
        //find the LCS String
        int i=str1.length();
        int j=str2.length();
     
        StringBuilder sb = new StringBuilder();
        while(i>0 && j>0){

            if(str1.charAt(i-1) == str2.charAt(j-1)){
                sb.append(str1.charAt(i-1));
                i-=1;
                j-=1;
            }else if(dp[i][j-1] > dp[i-1][j]){
                sb.append(str2.charAt(j-1)); // add the character from str2 to the result
                j-=1;
            }else{
                sb.append(str1.charAt(i-1));  // add the character from str1 to the result
                i-=1;
            }   
            
        }
        
        // If there are remaining characters in str1 add them to the result
        while(i > 0){
            sb.append(str1.charAt(i-1));
            i-=1;
        }
        
        // If there are remaining characters in str2 add them to the result
        while(j > 0){
            sb.append(str2.charAt(j-1));
            j-=1;
        }
        
        // The string is built in reverse order so we need to reverse it before returning
        String result = sb.reverse().toString();
        return result;
    }
}