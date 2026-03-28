class Solution {
    public int minInsertions(String s) {
        
        int length = s.length();

        /* 
           The idea is to find the longest palindromic subsequence 
           in the string and then subtract it from the length of 
           the string to get the minimum insertions required to make
           the string a palindrome
        */
        
        // ans = length - longestPalindromicSubsequnce()
        String s2 = new StringBuilder(s).reverse().toString();
       
         // longest palindromic subsequence is same as
         //  longest common subsequence of the string and its reverse
        int answer = length - lcsBottomUp(s,s2);
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
