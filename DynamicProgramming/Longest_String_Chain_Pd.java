 /*

   Problem Link : https://leetcode.com/problems/longest-string-chain/description/
   Date : 17th Mar 2026

 */

class Solution {
    public int longestStrChain(String[] words) {
       
        /*

          The idea is to sort the array of words based on their lengths and then use
          dynamic programming to find the longest increasing subsequence where the 
          condition for increasing is that the current word can be formed by adding 
          one character to the previous word 

        */

        Arrays.sort(words,(a, b) -> Integer.compare(a.length(), b.length())); 
        System.out.println(words[0]);
        int n = words.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1); // every element is a subsequence of length 1
        int max = 1; // length of longest increasing subsequence

        for(int ind=1;ind<n;ind++){
            for(int prev=0;prev<ind;prev++){

                // if the current word can be formed by adding one character to the previous word
                if(isPossible(words[prev],words[ind]) && 1 + dp[prev] > dp[ind]){
                    dp[ind] = 1 + dp[prev];
                }
            }
            
            // update max and lastIndex if we found a longer subsequence
            if(dp[ind] > max){
                max = dp[ind];
            }
        }
    
        return max;
    }
 
    // This function checks if we can form the current word by 
    // adding one character  to the previous word
    private boolean isPossible(String prev,String current){

        // Base case
        if (current.length() != prev.length() + 1) return false;

        int p1 = 0;
        int p2 = 0;
        int len2 = current.length();
        int len1 = prev.length();

        while(p2 < len2){
           if(p1<len1 && prev.charAt(p1) == current.charAt(p2)){
              p1+=1;
              p2+=1;
           }else{
              p2+=1;
           }
        }
        if(p1 == len1 && p2 == len2 ) return true;
        return false;
    }
}