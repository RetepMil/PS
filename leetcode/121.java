class Solution {
    public int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE, maxProfit = 0;
        for (int price : prices) {
            buy = Math.min(buy, price);
            maxProfit = Math.max(maxProfit, price - buy);
        }
        return maxProfit;
    }
}
