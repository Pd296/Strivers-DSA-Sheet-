/*
  Problem Link : https://leetcode.com/problems/longest-palindromic-substring/
  Date : 31st August 2025 
 */

class Solution {
    int start=0,end=0;

    public String longestPalindrome(String s) {
       char chars[]=s.toCharArray();
       getString(chars,0);
       return s.substring(start,end+1);
    }
    public void getString(char[] chars,int i){
        int left=i;
        int right=i;
        int n=chars.length;
        if(i>=n-1) return;
        while(right<n-1 &&chars[right]==chars[right+1]){
            right++;
        }
        i=right;
        while(left>0 && right<n-1 && chars[left-1]==chars[right+1]){
            left--;
            right++;
        }
        if(right-left >end -start){
            end=right;
            start=left;
        }
        getString(chars,i+1);
        
    }
}
