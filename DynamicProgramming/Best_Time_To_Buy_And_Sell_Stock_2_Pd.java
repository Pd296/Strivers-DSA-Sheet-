/*

   Problem Link : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
   Date : 2nd Mar 2026

 */


class Solution {
    public int maxProfit(int[] prices) {
        
        /* Intuition is to buy on dip and sell on peak */ 
        int profit = 0;
        int n = prices.length;
        for (int i = 0; i < n - 1; i++) {
            int currentPrice = prices[i];
            int nextPrice = prices[i + 1];
            if (currentPrice < nextPrice) {
                profit += nextPrice - currentPrice;
            }
        }
        return profit;
    }
}