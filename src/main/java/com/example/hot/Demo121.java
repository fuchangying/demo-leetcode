package com.example.hot;

public class Demo121 {
    public int maxProfit(int[] prices) {

        int minDay = prices[0];
        int ans = 0;

        for (int price : prices) {
            if (price < minDay) {
                minDay = price;
            }
            if (price - minDay > ans) {
                ans = price - minDay;
            }
        }

        return ans;
    }
}
