class Solution {
    public int maxProfit(int[] prices) {
        int answer = 0;
        int diff = 0;
        int prevPrice = prices[0];
        for (int price : prices) {
            if (price >= prevPrice) {
                diff += (price - prevPrice);
            }
            else {
                answer += diff;
                diff = 0;
            }
            prevPrice = price;
        }
        return answer + diff;
    }
}
