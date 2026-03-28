/*

   Problem Link : https://www.geeksforgeeks.org/problems/printing-longest-increasing-subsequence/1
   Date : 13th Mar 2026

 */

class Solution {
    public ArrayList<Integer> getLIS(int arr[]) {

        int n = arr.length;
        int[] dp = new int[n];
        int[] hash = new int[n];
        Arrays.fill(dp,1); // every element is a subsequence of length 1
        for(int i=0;i<n;i++) hash[i] = i; // initialize hash to point to itself
        
        int max = 1; // length of longest increasing subsequence
        int lastIndex = 0; // index of the last element of the longest increasing subsequence

        for(int ind=1;ind<n;ind++){
            for(int prev=0;prev<ind;prev++){
                 
                // if the current element is greater than the previous element 
                // and including it increases the length of the subsequence
                if(arr[ind] > arr[prev] && 1 + dp[prev] > dp[ind]){
                    dp[ind] = 1 + dp[prev];
                    hash[ind] = prev;
                }
            }
            
            // update max and lastIndex if we found a longer subsequence
            if(dp[ind] > max){
                max = dp[ind];
                lastIndex = ind;
            }
        }
        
        // reconstruct the longest increasing subsequence using the hash array
        ArrayList<Integer> result = new ArrayList<>();
        result.add(arr[lastIndex]);
        while(hash[lastIndex] != lastIndex){
            lastIndex = hash[lastIndex];
            result.add(arr[lastIndex]);
        }
        
        // reverse the result to get the correct order of the longest increasing subsequence
        Collections.reverse(result);

        return result;
    }
}