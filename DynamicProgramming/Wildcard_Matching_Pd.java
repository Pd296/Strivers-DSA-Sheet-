/*

   Problem Link : https://leetcode.com/problems/wildcard-matching/description/
   Date : 1st Mar 2026

 */

class Solution {
    public boolean isMatch(String s, String p) {
        // int n = s.length();
        // int m = p.length();

        // Boolean[][] dp = new Boolean[n][m];
        // return match(n-1, m-1, s, p, dp);
        return matchBottomUp(s,p);
    }

    private boolean match(int i, int j, String s, String p, Boolean[][] dp) {

        if (i < 0 && j < 0) return true;
        if (j < 0) return false;

        if (i < 0) {
            for (int k = 0; k <= j; k++)
                if (p.charAt(k) != '*') return false;
            return true;
        }

        if (dp[i][j] != null) return dp[i][j];

        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            return dp[i][j] = match(i-1, j-1, s, p, dp);
        }

        if (p.charAt(j) == '*') {
            boolean takeChar = dp[i-1][j];   // '*' matches 1 char
            boolean skipStar = dp[i][j-1];   // '*' matches 0 char
            return dp[i][j] = takeChar || skipStar;
        }

        return dp[i][j] = false;
    }

    private boolean matchBottomUp(String s,String p){

        int n = s.length();
        int m = p.length();

        Boolean[][] dp = new Boolean[n+1][m+1];
        
        dp[0][0]=true;
        for(int row=1;row<=n;row++)dp[row][0]=false;
        for (int col = 1; col <= m; col++) {
            if (p.charAt(col - 1) == '*')
                dp[0][col] = dp[0][col - 1];
            else
                dp[0][col] = false;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
               if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?') {
                    dp[i][j] = dp[i-1][j-1];
               }else if(p.charAt(j-1) == '*'){
                    boolean takeChar = dp[i-1][j]; //'*' matches 1 char
                    boolean skipStar = dp[i][j-1]; // '*' matches 0 char
                    dp[i][j] = takeChar || skipStar;
               }else dp[i][j]=false;
            }
        }
        return dp[n][m];
    }
}