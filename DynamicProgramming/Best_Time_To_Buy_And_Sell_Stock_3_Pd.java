/*

   Problem Link : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/
   Date : 2nd Mar 2026

 */

class Solution {
    public int maxProfit(int[] prices) {
        
        // int n = prices.length;
        // int maxTransactionsAllowed = 2;
        // int[][][] dp = new int[n][maxTransactionsAllowed+1][2];
        // for(int i=0;i<n;i++){
        //     for(int[] arr : dp[i]) Arrays.fill(arr,-1);
        // }

        // return maxProfitTopDown(0,maxTransactionsAllowed,1,prices,dp); 
        return maxProfitBottomUp(prices);
    }
    private int maxProfitTopDown(int ind,int k,int buy,int[] price,int[][][] dp){
        
        if(k == 0) return 0;
        if(ind == price.length) return 0;
        
        if(dp[ind][k][buy] != -1 ) return dp[ind][k][buy];
        int max = 0;
        if(buy == 1){
            int buyNow = -price[ind] + maxProfitTopDown(ind+1,k,0,price,dp);
            int dontBuy = 0 + maxProfitTopDown(ind+1,k,1,price,dp);
            max = Math.max(buyNow,dontBuy);
        }else{ 
            int sellNow = price[ind] + maxProfitTopDown(ind+1,k-1,1,price,dp);
            int dontSell = 0 + maxProfitTopDown(ind+1,k,0,price,dp);
            max = Math.max(sellNow,dontSell);
        }

        dp[ind][k][buy] = max;
        return max;
    }

    private int maxProfitBottomUp(int[] price){

        int n = price.length;
        int maxTransactionsAllowed = 2;
        int[][][] dp = new int[n+1][maxTransactionsAllowed+1][2];
        

        // We can skip filling the dp for ind == n and k == 0 because they are already 0 by default.
        //  But we can fill them for better understanding of base cases.

/*
        // if(k == 0) return 0;
        for(int i=0;i<n;i++){ //price index
            for(int j=0;j<2;j++){ // buy or not buy
                dp[i][0][j] = 0; 
            }
        }
        
        // if(ind == price.length) return 0;
        for(int k=0;k<=maxTransactionsAllowed;k++){ // transacation states
            for(int j=0;j<2;j++){  // buy or not buy
                dp[n][k][j] = 0;
            }
        }
*/

        /*
           Base case:
           dp[n][k][buy] = 0  (already 0 by default)
           dp[ind][0][buy] = 0 (already 0 by default)
         */

        for(int ind=n-1;ind>=0;ind--){
            for(int k=1;k<=maxTransactionsAllowed;k++){
                for(int buy=0;buy<=1;buy++){
                    
                    int max = 0;
                    if(buy==1){
                        int buyNow = -price[ind] + dp[ind+1][k][0];
                        int dontBuy = 0 + dp[ind+1][k][1];
                        max = Math.max(buyNow,dontBuy);
                    }else{
                        int sellNow = price[ind] + dp[ind+1][k-1][1];
                        int dontSell = 0 + dp[ind+1][k][0];
                        max = Math.max(sellNow,dontSell);
                    }

                    dp[ind][k][buy] = max;
                }
            }
        }

        return dp[0][maxTransactionsAllowed][1]; // max profit from index 0 with 2 transactions allowed and we can buy
    }
}