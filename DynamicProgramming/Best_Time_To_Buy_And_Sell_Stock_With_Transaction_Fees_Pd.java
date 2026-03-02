/*

   Problem Link : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/
   Date : 2nd Mar 2026

 */

class Solution {
    int fees = 0;
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        fees = fee;
        for (int i = 0; i < n; i++)
            Arrays.fill(dp[i], -1);

        return solve(0, 1, prices, dp);
    }

    private int solve(int ind, int buy, int[] price, int[][] dp) {

        if (ind >= price.length)
            return 0;

        if (dp[ind][buy] != -1)
            return dp[ind][buy];

        if (buy == 1) {
            int buyNow = -(price[ind] + fees) + solve(ind + 1, 0, price, dp);
            int skip = solve(ind + 1, 1, price, dp);
            return dp[ind][1] = Math.max(buyNow, skip);
        } else {
            int sellNow = price[ind] + solve(ind + 1, 1, price, dp);
            int skip = solve(ind + 1, 0, price, dp);
            return dp[ind][0] = Math.max(sellNow, skip);
        }
    }
}