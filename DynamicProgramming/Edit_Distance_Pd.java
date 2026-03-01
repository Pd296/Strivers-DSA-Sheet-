/*

   Problem Link : https://leetcode.com/problems/edit-distance/description/
   Date : 1st Mar 2026

 */

class Solution {
    public int minDistance(String word1, String word2) {
        
        // int len1 = word1.length();
        // int len2 = word2.length();

        // int[][] dp = new int[len1][len2];
        // for(int[] arr : dp ) Arrays.fill(arr,-1);

        // return minDistanceTopDown(len1-1,len2-1,word1,word2,dp);
        return minDistanceBottomUp(word1,word2);
    }

    private int minDistanceTopDown(int i,int j,String s1,String s2,int[][] dp){
        
        if(i<0) return j+1; // if word1 is empty, we need to insert all characters of word2
        if(j<0) return i+1; // if word2 is empty, we need to delete all characters of word1

        if(dp[i][j] != -1) return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j)){
            dp[i][j] = minDistanceTopDown(i-1,j-1,s1,s2,dp);
        }else{
            int delOp = 1 + minDistanceTopDown(i-1, j, s1, s2, dp);   // delete
            int insOp = 1 + minDistanceTopDown(i, j-1, s1, s2, dp);   // insert
            int repOp = 1 + minDistanceTopDown(i-1, j-1, s1, s2, dp); // replace
            dp[i][j] = Math.min(delOp, Math.min(insOp, repOp));
        }

        return dp[i][j];
    }

    private int minDistanceBottomUp(String s1,String s2){

        int len1 = s1.length();
        int len2 = s2.length();
        int[][] dp = new int[len1+1][len2+1]; // dp[i][j] represents the minimum edit distance between the first i characters of s1 and the first j characters of s2

        for(int col=0;col<=len2;col++) dp[0][col] = col; // if word1 is empty, we need to insert all characters of word2
        for(int row=0;row<=len1;row++) dp[row][0] = row; // if word2 is empty, we need to delete all characters of word1

        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){

                if(s1.charAt(i-1) == s2.charAt(j-1)) 
                    dp[i][j] =  dp[i-1][j-1]; // if the characters are the same, then we don't need to do any operation, so the edit distance is the same as the edit distance between the first i-1 characters of s1 and the first j-1 characters of s2
                else{
                    int delOp = 1 + dp[i-1][j]; //delete
                    int insOp = 1 + dp[i][j-1];   // insert
                    int repOp = 1 + dp[i-1][j-1]; // replace
                    dp[i][j] = Math.min(delOp, Math.min(insOp, repOp)); // take the minimum of the three operationss
                }
            }
        }

        return dp[len1][len2]; // return the minimum edit distance between the first len1 characters of s1 and the first len2 characters of s2
    }
}