/*

   Problem Link : https://www.geeksforgeeks.org/problems/partitions-with-given-difference/1
   Date : 25th February 2026

 */

class Solution {
    public int countPartitions(int[] arr, int diff) {

        /*
        
        S1 - S2 = diff -> find the number of subsets which satisfy this condition
        S1 + S2 = totalSum 
        
        2*S1 = totalSum + diff
        S1 = (totalSum + diff ) / 2;
        
        
        1) If (d + totalSum) is odd, then division by 2 is not possible, thus, there is no valid partitions
        2) If d is greater than totalSum, then it is also impossible,
        thus, there is no valid partitions
        
        */
        
        int n = arr.length;
        int totalSum = 0;
        for(int num : arr ) totalSum += num;
        
        if((totalSum+diff) % 2 == 1 ) return 0; // if totalSum + diff is odd, cannot partition into two subsets
        if( diff > totalSum ) return 0; // if diff is greater than totalSum, cannot partition into two subsets
        
        int K = (totalSum + diff) / 2; // target sum for subset S1
        
        // regular count subsets with sum K problem
        int[][] dp = new int[n][K+1];
        if(arr[0] == 0) dp[0][arr[0]] = 2;
        else {
            for(int tar=0;tar<=K;tar++)
                if(tar == 0 || tar==arr[0]) dp[0][tar] = 1;
        }
        
        for(int ind = 1 ; ind < n ; ind++){
            for(int t = 0; t <= K ; t++){
                
                int skip = dp[ind-1][t];
                int pick = 0;
                if (arr[ind] <= t) // can pick the element if it does not exceed the totalSum
                    pick = dp[ind-1][t - arr[ind]];
        
                dp[ind][t] = pick + skip; // total ways
                
            }
        }
        
        return dp[n-1][K]; // number of subsets with sum K
    }
}

