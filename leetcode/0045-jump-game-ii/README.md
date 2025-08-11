# Jump Game II (Difficulty: Medium)

[LeetCode Link](https://leetcode.com/problems/jump-game-ii/)

---

You are given a 0-indexed array of integers nums of length n. You are initially positioned at&nbsp;index 0.

Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at index i, you can jump to any index (i + j)&nbsp;where:


	0 &lt;= j &lt;= nums[i] and
	i + j &lt; n


Return the minimum number of jumps to reach index n - 1. The test cases are generated such that you can reach index&nbsp;n - 1.

&nbsp;
Example 1:

```
Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
```

Example 2:

```
Input: nums = [2,3,0,1,4]
Output: 2
```

&nbsp;
Constraints:


	1 &lt;= nums.length &lt;= 104
	0 &lt;= nums[i] &lt;= 1000
	It&#39;s guaranteed that you can reach nums[n - 1].


