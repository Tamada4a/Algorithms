# 14. Longest Common Prefix
Write a function to find the longest common prefix string amongst an array of strings.  

If there is no common prefix, return an empty string `""`.

## Example 1:
<pre>
<b>Input:</b> strs = ["flower","flow","flight"]
<b>Output:</b> "fl"
</pre>

## Example 2:
<pre>
<b>Input:</b> strs = ["dog","racecar","car"]
<b>Output:</b> ""
<b>Explanation:</b> There is no common prefix among the input strings.
</pre>

## Constraints:
- `1 <= strs.length <= 200`
- `0 <= strs[i].length <= 200`.
- `strs[i]` consists of only lowercase English letters if it is non-empty.