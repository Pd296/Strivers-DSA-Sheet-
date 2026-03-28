/*

   Problem Link : https://www.geeksforgeeks.org/problems/rod-cutting0840/1
   Date : 3rd November 2025

 */

class Solution {
    public int cutRod(int[] price) {
        // code here
        int n = price.length;
        int[][] dp = new int[n][n + 1]; // dp array for memoization
        for (int[] arr : dp) Arrays.fill(arr, -1);
        return cutRodMemo(price,dp,n,n-1);
    }
    private int cutRodMemo(int[] price,int[][] dp,int target,int index){
        
        if(target == 0 ) return 0; // no length left to cut
        if(index == 0) {
            return target * price[0]; // can only cut pieces of length 1
        } 
        
        if(dp[index][target] != -1) return dp[index][target]; // return already computed value

        int cutRodHere = 0;
        if( (index + 1) <=  target ) // can cut the rod of length (index + 1)
            cutRodHere = price[index] + cutRodMemo(price,dp,target-(index+1),index); // cut here and continue cutting
            
        int dontCutRod = cutRodMemo(price,dp,target,index-1); // do not cut here, move to smaller piece
        
        int max = Math.max(cutRodHere,dontCutRod); // maximum of cutting and not cutting
        dp[index][target]=max; // store in dp table
        return max;
    } 
}