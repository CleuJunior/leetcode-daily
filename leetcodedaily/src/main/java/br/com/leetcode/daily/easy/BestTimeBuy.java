package br.com.leetcode.daily.easy;

public class BestTimeBuy {

    public static int maxProfit(int[] prices) {
        int buy = 0, sell = 1, maxProfit = 0;

        while (sell < prices.length) {
            if (prices[buy] < prices[sell]) {
                int profit = prices[sell] - prices[buy];
                maxProfit = Math.max(maxProfit, profit);
            } else {
                buy = sell;
            }
            sell++;
        }

        return maxProfit;
    }
}
