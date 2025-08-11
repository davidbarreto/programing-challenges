# Surrounded Regions (Difficulty: Medium)

[LeetCode Link](https://leetcode.com/problems/surrounded-regions/)

---

You are given an m x n matrix board containing letters &#39;X&#39; and &#39;O&#39;, capture regions that are surrounded:


	Connect: A cell is connected to adjacent cells horizontally or vertically.
	Region: To form a region connect every &#39;O&#39; cell.
	Surround: The region is surrounded with &#39;X&#39; cells if you can connect the region with &#39;X&#39; cells and none of the region cells are on the edge of the board.


To capture a surrounded region, replace all &#39;O&#39;s with &#39;X&#39;s in-place within the original board. You do not need to return anything.

&nbsp;
Example 1:


Input: board = [[&quot;X&quot;,&quot;X&quot;,&quot;X&quot;,&quot;X&quot;],[&quot;X&quot;,&quot;O&quot;,&quot;O&quot;,&quot;X&quot;],[&quot;X&quot;,&quot;X&quot;,&quot;O&quot;,&quot;X&quot;],[&quot;X&quot;,&quot;O&quot;,&quot;X&quot;,&quot;X&quot;]]

Output: [[&quot;X&quot;,&quot;X&quot;,&quot;X&quot;,&quot;X&quot;],[&quot;X&quot;,&quot;X&quot;,&quot;X&quot;,&quot;X&quot;],[&quot;X&quot;,&quot;X&quot;,&quot;X&quot;,&quot;X&quot;],[&quot;X&quot;,&quot;O&quot;,&quot;X&quot;,&quot;X&quot;]]

Explanation:

In the above diagram, the bottom region is not captured because it is on the edge of the board and cannot be surrounded.


Example 2:


Input: board = [[&quot;X&quot;]]

Output: [[&quot;X&quot;]]


&nbsp;
Constraints:


	m == board.length
	n == board[i].length
	1 &lt;= m, n &lt;= 200
	board[i][j] is &#39;X&#39; or &#39;O&#39;.


