# Word Pattern (Difficulty: Easy)

[LeetCode Link](https://leetcode.com/problems/word-pattern/)

---

Given a pattern and a string s, find if s&nbsp;follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s. Specifically:


	Each letter in pattern maps to exactly one unique word in s.
	Each unique word in s maps to exactly one letter in pattern.
	No two letters map to the same word, and no two words map to the same letter.


&nbsp;
Example 1:


Input: pattern = &quot;abba&quot;, s = &quot;dog cat cat dog&quot;

Output: true

Explanation:

The bijection can be established as:


	&#39;a&#39; maps to &quot;dog&quot;.
	&#39;b&#39; maps to &quot;cat&quot;.



Example 2:


Input: pattern = &quot;abba&quot;, s = &quot;dog cat cat fish&quot;

Output: false


Example 3:


Input: pattern = &quot;aaaa&quot;, s = &quot;dog cat cat dog&quot;

Output: false


&nbsp;
Constraints:


	1 &lt;= pattern.length &lt;= 300
	pattern contains only lower-case English letters.
	1 &lt;= s.length &lt;= 3000
	s contains only lowercase English letters and spaces &#39; &#39;.
	s does not contain any leading or trailing spaces.
	All the words in s are separated by a single space.


