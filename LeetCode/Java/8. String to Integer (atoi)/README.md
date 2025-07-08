# 8. String to Integer (atoi)
Implement the `myAtoi(string s)` function, which converts a string to a 32-bit signed integer.  

The algorithm for `myAtoi(string s)` is as follows:
1. **Whitespace**: Ignore any leading whitespace (`" "`).
2. **Signedness**: Determine the sign by checking if the next character is `'-'` or `'+'`, assuming positivity if neither present.
3. **Conversion**: Read the integer by skipping leading zeros until a non-digit character is encountered or the end of the string is reached. If no 
digits were read, then the result is 0.
4. **Rounding**: If the integer is out of the 32-bit signed integer range <code>[-2<sup>31</sup>, 2<sup>31</sup> - 1]</code>, then round the integer to remain in the range. Specifically, 
integers less than <code>-2<sup>31</sup></code> should be rounded to <code>-2<sup>31</sup></code>, and integers greater than <code>2<sup>31</sup> - 1</code> should be rounded to <code>2<sup>31</sup> - 1</code>.

Return the integer as the final result.

## Example 1:
<pre>
<b>Input:</b> s = "42"
<b>Output:</b> 42
<b>Explanation:</b>
The underlined characters are what is read in and the caret is the current reader position.
Step 1: "42" (no characters read because there is no leading whitespace)
         ^
Step 2: "42" (no characters read because there is neither a '-' nor '+')
         ^  
Step 3: "<ins>42</ins>" ("42" is read in)
           ^
</pre>

## Example 2:
<pre>
<b>Input:</b> s = " -042"
<b>Output:</b> -42
<b>Explanation:</b>
Step 1: "   -042" (leading whitespace is read and ignored)
            ^
Step 2: "   -042" ('-' is read, so the result should be negative)
             ^
Step 3: "   -<ins>042</ins>" ("042" is read in, leading zeros ignored in the result)
               ^
</pre>

## Example 3:
<pre>
<b>Input:</b> s = "1337c0d3"
<b>Output:</b> 1337
<b>Explanation:</b>
Step 1: "1337c0d3" (no characters read because there is no leading whitespace)
         ^
Step 2: "1337c0d3" (no characters read because there is neither a '-' nor '+')
         ^
Step 3: "<ins>1337</ins>c0d3" ("1337" is read in; reading stops because the next character is a non-digit)
             ^
</pre>

## Example 4:
<pre>
<b>Input:</b> s = "0-1"
<b>Output:</b> 0
<b>Explanation:</b>
Step 1: "0-1" (no characters read because there is no leading whitespace)
         ^
Step 2: "0-1" (no characters read because there is neither a '-' nor '+')
         ^
Step 3: "<ins>0</ins>-1" ("0" is read in; reading stops because the next character is a non-digit)
          ^
</pre>

## Example 5:
<pre>
<b>Input:</b> s = ""words and 987"
<b>Output:</b> 0
<b>Explanation:</b>
Reading stops at the first non-digit character 'w'.
</pre>

## Constraints:
- `0 <= s.length <= 200`
- `s` consists of English letters (lower-case and upper-case), digits (`0-9`), `' '`, `'+'`, `'-'`, and `'.'`.
