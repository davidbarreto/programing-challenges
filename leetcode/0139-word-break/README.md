# Word Break (Difficulty: Medium)

[LeetCode Link](https://leetcode.com/problems/word-break/)

---

Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

&nbsp;
Example 1:

```
Input: s = &quot;leetcode&quot;, wordDict = [&quot;leet&quot;,&quot;code&quot;]
Output: true
Explanation: Return true because &quot;leetcode&quot; can be segmented as &quot;leet code&quot;.
```

Example 2:

```
Input: s = &quot;applepenapple&quot;, wordDict = [&quot;apple&quot;,&quot;pen&quot;]
Output: true
Explanation: Return true because &quot;applepenapple&quot; can be segmented as &quot;apple pen apple&quot;.
Note that you are allowed to reuse a dictionary word.
```

Example 3:

```
Input: s = &quot;catsandog&quot;, wordDict = [&quot;cats&quot;,&quot;dog&quot;,&quot;sand&quot;,&quot;and&quot;,&quot;cat&quot;]
Output: false
```

&nbsp;
Constraints:


	1 &lt;= s.length &lt;= 300
	1 &lt;= wordDict.length &lt;= 1000
	1 &lt;= wordDict[i].length &lt;= 20
	s and wordDict[i] consist of only lowercase English letters.
	All the strings of wordDict are unique.


