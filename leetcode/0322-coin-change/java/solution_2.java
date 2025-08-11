class Solution {
    public int coinChange(int[] coins, int amount) {

        int maxAmount = amount + 1;
        int[] dp = new int[maxAmount];
        Arrays.fill(dp, maxAmount);

        dp[0] = 0;
        for (int currentAmount = 1; currentAmount <= amount; currentAmount++) {
            for (int coin : coins) {
                if (currentAmount - coin >= 0) {
                    dp[currentAmount] = Math.min(dp[currentAmount], 1 + dp[currentAmount - coin]);
                }
            }
        }
    
        return dp[amount] == maxAmount ? -1 : dp[amount];
    }

}