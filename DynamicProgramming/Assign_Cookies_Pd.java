/*

   Problem Link : https://leetcode.com/problems/assign-cookies/
   Date : 29th October 2025

 */

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        
        Arrays.sort(g);
        Arrays.sort(s);
        int l1 = g.length;
        int l2 = s.length;
        int j = l2-1;

        int count = 0;

        for(int i=l1-1;i>=0;i--){  
            if(j < 0 ) break;
            int size = s[j];
            int greed = g[i];
            if(j>= 0 && greed <= size ){
                count += 1;
                j-=1;
            }
        }
        return count;
    }
}