/**
 * The idea here is to avoid the simulation - As an O(n^2) algorithm fails with time limit exceeded.
 * As the moves are always between elements that are side-by-side,
 * for each 0 found, add the number of 1s found until now.
 *
 * Runtime: 8 ms
 * Memory: 48.04 MB
 */
class Solution {
    public long minimumSteps(String s) {

        long steps = 0;
        int blacks = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                steps += blacks;
            } else {
                blacks++;
            }
        }

        return steps;
    }
}