/*

   Problem Link : https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
   Date : 2nd Mar 2026

 */


class Solution {
    public int maxProfit(int[] prices) {

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int price : prices) {
            if(price < minPrice) {
                minPrice = price;  // better buying day found
            } else {
                maxProfit = Math.max(maxProfit, price - minPrice);
            }
        }

        return maxProfit;
    }
}