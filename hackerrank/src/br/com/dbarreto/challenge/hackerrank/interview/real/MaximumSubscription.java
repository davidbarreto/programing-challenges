package br.com.dbarreto.challenge.hackerrank.interview.real;

import java.util.*;

/**
 * Maximum Subscription
 *
 * You are given an array costs of base prices for n products and a budget maxSpent.
 * When purchasing subscriptions, the effective price of each product increases based on how many products you decide to buy.
 *
 * If you decide to buy exactly k products, then the effective price of product i (1-indexed) becomes:
 * cost[i] + i * k
 *
 * The total cost for choosing k products is the sum of the k smallest effective prices.
 *
 * Goal:
 * Determine the maximum number of products k that can be purchased without exceeding maxSpent, and compute the minimum achievable total cost for that k.
 *
 * Example:
 *
 * costs = [4, 1, 6, 3]
 * maxSpent = 20
 * If you choose k = 2, the adjusted prices become:
 *
 * product 1: 4 + 1*2 = 6
 * product 2: 1 + 2*2 = 5
 * product 3: 6 + 3*2 = 12
 * product 4: 3 + 4*2 = 11
 * Taking the two cheapest:
 *
 * 5 + 6 = 11
 * If you try k = 3:
 *
 * 4 + 1*3 = 7
 * 1 + 2*3 = 7
 * 6 + 3*3 = 15
 * 3 + 4*3 = 15
 * → three smallest = 7 + 7 + 15 = 29 > 20
 * So the maximum you can buy is:
 *
 * k = 2
 * total cost = 11
 */

public class MaximumSubscription {

    public static void main(String[] args) {
        // Example
        int[] costs = {4, 1, 6, 3};
        long maxSpent = 20;

        Result r = maxSubscription(costs, maxSpent);
        System.out.println("Max products: " + r.k);
        System.out.println("Min cost: " + r.cost);
    }

    static class Result {
        int k;
        long cost;
        Result(int k, long cost) { this.k = k; this.cost = cost; }
    }

    private static Result maxSubscription(int[] costs, long maxSpent) {
        int left = 0, right = costs.length;
        long bestCost = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            long c = computeCost(costs, mid);

            if (c <= maxSpent) {
                // feasible → try more
                left = mid + 1;
                bestCost = c;
            } else {
                right = mid - 1;
            }
        }

        return new Result(right, bestCost);
    }

    private static long computeCost(int[] costs, int k) {
        if (k == 0) return 0;

        int n = costs.length;
        long[] adjusted = new long[n];

        for (int i = 0; i < n; i++) {
            // product indices are 1-based in the problem
            adjusted[i] = costs[i] + (long)(i + 1) * k;
        }

        Arrays.sort(adjusted);

        long total = 0;
        for (int i = 0; i < k; i++) {
            total += adjusted[i];
        }

        return total;
    }
}
