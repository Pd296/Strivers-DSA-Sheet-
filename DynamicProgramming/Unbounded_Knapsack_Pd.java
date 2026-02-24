/*

   Problem Link : https://www.geeksforgeeks.org/problems/knapsack-with-duplicate-items4201/1
   Date : 2nd November 2025

 */

class Solution {
    static int knapSack(int val[], int wt[], int capacity) {
        // code here
        
        int n = val.length;
        int[][] dp = new int[n][capacity+1];
        for(int[] arr : dp ) Arrays.fill(arr,-1);
        int answer = knapSackMemo(val,wt,dp,capacity,n-1);
        return answer < 0 ? 0 : answer;
        
    }
    private static int knapSackMemo(int[] val,int[] wt,int[][] dp,int target,int index){
        
        if (target == 0) return 0; // no capacity left 
        if (index == 0) {
            return (target / wt[0]) * val[0]; // can take as many of item 0 as possible
        }
        
        if(dp[index][target] != -1 ) return dp[index][target]; // return already computed value
        int value = val[index]; // value of current item

        int notTake = knapSackMemo(val,wt,dp,target,index-1);  // not take the item at index
        int take = 0;
        if(wt[index] <= target) // can take the item if it does not exceed the target
            take = value + knapSackMemo(val,wt,dp,target-wt[index],index);
        
        int max = Math.max(notTake , take ); // maximum value by taking and not taking
        dp[index][target] = max; // store in dp table
        return max;
        
    }
}


/*

   Problem Link : https://www.geeksforgeeks.org/problems/knapsack-with-duplicate-items4201/1
   Date : 24th Feb 2026

 */


class Solution {
    public int knapSack(int val[], int wt[], int capacity) {
        // code here
        
        int n=val.length;
        int[][] dp = new int[n][capacity+1];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        //return unboundedKnapsackTopDown(n-1,capacity,wt,val,dp);
        
        return bottomUp(wt,val,capacity);
    }
    
    private int unboundedKnapsackTopDown(int ind,int capacity,int[] wt,int[] val,int[][] dp){
        
        if(ind == 0){
            if(wt[0] <= capacity) return ((int)(capacity/wt[0])) * val[0];
            else return 0;
        }
        
        if(dp[ind][capacity] != -1 ) return dp[ind][capacity];
        
        int notTake = 0  + unboundedKnapsackTopDown(ind-1,capacity,wt,val,dp);
        int Take = Integer.MIN_VALUE;
        if(wt[ind] <= capacity)
            Take = val[ind] + unboundedKnapsackTopDown(ind,capacity-wt[ind],wt,val,dp);
        
        int maxValue = Math.max(notTake , Take);
        dp[ind][capacity] = maxValue;
        
        return maxValue;
    }
    
    private int bottomUp(int[] wt , int[] val,int capacity){
        
        int n = wt.length;
        int[][] dp = new int[n][capacity+1];
        
        for(int weight=0; weight<=capacity;weight++){
            dp[0][weight] = ((int)(weight/wt[0])) * val[0];
        }
        
        for(int ind = 1 ; ind < n ; ind ++){
            for(int weight = 0; weight <= capacity ; weight++){
                
                  int notTake = dp[ind-1][weight];
                  int Take = Integer.MIN_VALUE;
                  if(wt[ind] <= weight)
                        Take = val[ind] + dp[ind][weight-wt[ind]];
                    
                  int maxValue = Math.max(notTake , Take);
                  dp[ind][weight] = maxValue;
            }
        }
        return dp[n-1][capacity];
    }
}



