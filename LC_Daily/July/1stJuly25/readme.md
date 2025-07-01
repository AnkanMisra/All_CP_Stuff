# Problem: 3330. Find the Original Typed String I

## Problem Description
Alice is attempting to type a specific string on her computer. However, she tends to be clumsy and may **press a key for too long**, resulting in a character being typed multiple times. Although Alice tried to focus on her typing, she is aware that she may still have done this **at most once**.

You are given a string `word`, which represents the **final output displayed on Alice's screen**. Return the **total number of possible original strings** that Alice might have intended to type.

## Input Format
- A string `word` representing the final output displayed on Alice's screen

## Output Format
- An integer representing the **total number of possible original strings** that Alice might have intended to type

## Examples

### Example 1
**Input:** `word = "abbcccc"`<br/>
**Output:** `5`<br/>
**Explanation:** The possible strings are: `"abbcccc"`, `"abbccc"`, `"abbcc"`, `"abbc"`, and `"abcccc"`.

### Example 2
**Input:** `word = "abcd"`<br/>
**Output:** `1`<br/>
**Explanation:** The only possible string is `"abcd"`.

### Example 3
**Input:** `word = "aaaa"`<br/>
**Output:** `4`

## Constraints
- **1 <= word.length <= 100**
- **word consists only of lowercase English letters**

## Notes
- Alice may have pressed a key for too long **at most once**
- Each possible original string corresponds to either the given string as-is, or the given string with some consecutive sequence of identical characters reduced by removing one or more characters from that sequence

