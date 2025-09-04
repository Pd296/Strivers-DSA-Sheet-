/*
  Problem Link : https://leetcode.com/problems/russian-doll-envelopes/
  Date : 4th Sept 2025 
  
 */

import java.util.*;

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
    Arrays.sort(envelopes, (a, b) -> {
        if (a[0] == b[0]) {
            return b[1]-a[1];
        } else {
            return a[0]-b[0];
        }
    });
   //the heights to find the Longest Increasing Subsequence (LIS).
    int[] heights = new int[envelopes.length];
    for (int i = 0; i < envelopes.length; i++) {
        heights[i] = envelopes[i][1];
    }

    List<Integer> dp = new ArrayList<>();

    for(int h: heights){
        //If the key is not found, returns -(insertion point the index where the key would be inserted to keep the list sorted) - 1
        int idx = Collections.binarySearch(dp,h);
        if(idx<0){
            idx=-(idx+1);
        }
        if(idx==dp.size()){
            dp.add(h);
        }else{
            dp.set(idx,h);
        }
    }
    
    return dp.size();
    }

}
