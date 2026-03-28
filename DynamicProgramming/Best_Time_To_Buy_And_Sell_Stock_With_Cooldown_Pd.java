/*

   Problem Link : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/
   Date : 2nd Mar 2026

 */

class Solution {
    public int maxProfit(int[] prices) {
        
        int n = prices.length;
        int coolDown = 0; //initially 0 , but two states  > 0/1 
        int[][][] dp = new int[n][2][2];
        for(int i=0;i<n;i++){
            for(int[] arr : dp[i]) Arrays.fill(arr,-1);
        }

        return maxProfitTopDownPd(0,coolDown,1,prices,dp); 

    }

    //my first solution (works , but can be simplified)
    private int maxProfitTopDownPd(int ind,int k,int buy,int[] price,int[][][] dp){
        
        if(ind >= price.length) return 0;
        
        if(dp[ind][k][buy] != -1 ) return dp[ind][k][buy];
        int max = 0;
        if(buy == 1){

            if(k==0){ //if coolDown is 0 , then we can buy or not buy . 
               int buyNow = -price[ind] + maxProfitTopDownPd(ind+1,k,0,price,dp);
               int dontBuy = 0 + maxProfitTopDownPd(ind+1,k,1,price,dp);
               max = Math.max(buyNow,dontBuy);
            }else if(k==1){ //if coolDown is 1 , then we cannot buy 
               int cantBuy = 0 + maxProfitTopDownPd(ind+1,0,1,price,dp); // we skip this day and next day we can buy (coolDown becomes 0)
               max = cantBuy;
            }
        }else{ 
            int sellNow = price[ind] + maxProfitTopDownPd(ind+1,1,1,price,dp);
            int dontSell = 0 + maxProfitTopDownPd(ind+1,k,0,price,dp);
            max = Math.max(sellNow,dontSell);
        }

        dp[ind][k][buy] = max;
        return max;
    }
}

//Best solution ->  cleaner and efficient solution 
// class Solution {
//     public int maxProfit(int[] prices) {
//         int n = prices.length;
//         int[][] dp = new int[n][2];

//         for(int i = 0; i < n; i++)
//             Arrays.fill(dp[i], -1);

//         return solve(0, 1, prices, dp);
//     }

//     private int solve(int ind, int buy, int[] price, int[][] dp) {

//         if(ind >= price.length)
//             return 0;

//         if(dp[ind][buy] != -1)
//             return dp[ind][buy];

//         if(buy == 1) {
//             int buyNow = -price[ind] + solve(ind+1, 0, price, dp);
//             int skip = solve(ind+1, 1, price, dp);
//             return dp[ind][1] = Math.max(buyNow, skip);
//         } else {
//             int sellNow = price[ind] + solve(ind+2, 1, price, dp); // cooldown is handled here
//             int skip = solve(ind+1, 0, price, dp);
//             return dp[ind][0] = Math.max(sellNow, skip);
//         }
//     }
// }