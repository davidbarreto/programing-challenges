class Solution {
    public int coinChange(int[] coins, int amount) {
        int qtd = coinChange(coins, amount, new HashMap<>());
        return qtd == Integer.MAX_VALUE ? -1 : qtd;
    }

    private int coinChange(int[] coins, int amount, Map<Integer, Integer> memo) {

        if (amount < 0) {
            return Integer.MAX_VALUE;
        }

        if (amount == 0) {
            return 0;
        }

        if (memo.containsKey(amount)) {
            return memo.get(amount);
        }

        int min = Integer.MAX_VALUE;
        for (int c : coins) {
            min = Math.min(min, coinChange(coins, amount - c, memo));
        }

        int result = min == Integer.MAX_VALUE ? min : min + 1;
        memo.put(amount, result);

        return result;
    }
}