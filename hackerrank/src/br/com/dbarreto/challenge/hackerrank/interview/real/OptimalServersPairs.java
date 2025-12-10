package br.com.dbarreto.challenge.hackerrank.interview.real;

import java.util.Arrays;

/**
 * Optimal Server Pairing
 *
 * You are given two integer arrays of equal length: responseTime and bootTime.
 * For each index i, responseTime[i] represents the server's response time
 * and bootTime[i] represents the server's boot time.
 *
 * A pair of servers (i, j) with i < j is considered optimal if:
 *     responseTime[i] + responseTime[j] > bootTime[i] + bootTime[j]
 *
 * To simplify the comparison, define for each server a score:
 *     score[i] = responseTime[i] - bootTime[i]
 *
 * Using this transformation, the optimality condition becomes:
 *     score[i] + score[j] > 0
 *
 * Your task is to compute how many server pairs (i, j) with i < j satisfy this condition.
 *
 * Example:
 *
 * responseTime = [10, 4, 7, 3]
 * bootTime     = [8, 6, 2, 5]
 *
 * score = [2, -2, 5, -2]
 * Sorted score = [-2, -2, 2, 5]
 *
 * Valid pairs where score[i] + score[j] > 0:
 * (-2 + 5) = 3
 * (-2 + 5) = 3
 * (2 + 5) = 7
 *
 * There are 3 optimal pairs.
 *
 * A common efficient approach is:
 * 1. Compute the score array.
 * 2. Sort it.
 * 3. Use a two-pointer technique to count how many pairs satisfy score[i] + score[j] > 0.
 *
 * Time complexity: O(n log n)
 */
public class OptimalServersPairs {

    static class Pair implements Comparable<Pair> {
        long score;
        int index;

        Pair(long score, int index) {
            this.score = score;
            this.index = index;
        }

        @Override
        public int compareTo(Pair other) {
            return Long.compare(this.score, other.score);
        }
    }

    public static void main(String[] args) {
        int[] response = {4, 2, 7, 1};
        int[] boot = {3, 5, 1, 2};
        System.out.println(countOptimalPairs(response, boot)); // example output
    }

    public static long countOptimalPairs(int[] responseTime, int[] bootTime) {
        int n = responseTime.length;
        Pair[] pairs = new Pair[n];

        for (int i = 0; i < n; i++) {
            long score = (long) responseTime[i] - (long) bootTime[i];
            pairs[i] = new Pair(score, i);
        }

        Arrays.sort(pairs); // sort by score

        long count = 0;
        int l = 0, r = n - 1;

        while (l < r) {
            if (pairs[l].score + pairs[r].score > 0) {
                // All pairs (l..r-1, r) where index[l] < index[r] are valid
                for (int k = l; k < r; k++) {
                    if (pairs[k].index < pairs[r].index) {
                        count++;
                    }
                }
                r--;
            } else {
                l++;
            }
        }

        return count;
    }
}
