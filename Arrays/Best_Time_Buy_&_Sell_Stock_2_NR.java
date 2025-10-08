//Problem statement - https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
//29 Sept 2025
class Solution {
    public int maxProfit(int[] prices) {
        int max=0;
        int j=0;
        for(int i=1;i<prices.length;i++){
            if(prices[j]>prices[i]){
                j=i;
            }
            if(prices[j]<prices[i] && i!=prices.length-1 && prices[i]<prices[i+1]) continue;
            if(max<max+(prices[i]-prices[j])){
                max=max+(prices[i]-prices[j]);
                j=i;
            }
        }
        return max;
    }
}
