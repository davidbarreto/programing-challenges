class Solution {

    public int maxProfit(int[] prices) {
    
        int max = Integer.MIN_VALUE;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            int profit = prices[i] - minPrice;
            if (profit > max){
                max = profit;
            }
        }
        
        return max;
    }
}