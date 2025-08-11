# Simplify Path (Difficulty: Medium)

[LeetCode Link](https://leetcode.com/problems/simplify-path/)

---

You are given an absolute path for a Unix-style file system, which always begins with a slash &#39;/&#39;. Your task is to transform this absolute path into its simplified canonical path.

The rules of a Unix-style file system are as follows:


	A single period &#39;.&#39; represents the current directory.
	A double period &#39;..&#39; represents the previous/parent directory.
	Multiple consecutive slashes such as &#39;//&#39; and &#39;///&#39; are treated as a single slash &#39;/&#39;.
	Any sequence of periods that does not match the rules above should be treated as a valid directory or file name. For example, &#39;...&#39; and &#39;....&#39; are valid directory or file names.


The simplified canonical path should follow these rules:


	The path must start with a single slash &#39;/&#39;.
	Directories within the path must be separated by exactly one slash &#39;/&#39;.
	The path must not end with a slash &#39;/&#39;, unless it is the root directory.
	The path must not have any single or double periods (&#39;.&#39; and &#39;..&#39;) used to denote current or parent directories.


Return the simplified canonical path.

&nbsp;
Example 1:


Input: path = &quot;/home/&quot;

Output: &quot;/home&quot;

Explanation:

The trailing slash should be removed.


Example 2:


Input: path = &quot;/home//foo/&quot;

Output: &quot;/home/foo&quot;

Explanation:

Multiple consecutive slashes are replaced by a single one.


Example 3:


Input: path = &quot;/home/user/Documents/../Pictures&quot;

Output: &quot;/home/user/Pictures&quot;

Explanation:

A double period &quot;..&quot; refers to the directory up a level (the parent directory).


Example 4:


Input: path = &quot;/../&quot;

Output: &quot;/&quot;

Explanation:

Going one level up from the root directory is not possible.


Example 5:


Input: path = &quot;/.../a/../b/c/../d/./&quot;

Output: &quot;/.../b/d&quot;

Explanation:

&quot;...&quot; is a valid name for a directory in this problem.


&nbsp;
Constraints:


	1 &lt;= path.length &lt;= 3000
	path consists of English letters, digits, period &#39;.&#39;, slash &#39;/&#39; or &#39;_&#39;.
	path is a valid absolute Unix path.


