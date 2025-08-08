
# Problem: Longest Prefix Suffix

## Problem Description
Given a string `s` of lowercase English alphabets, find the **length of the longest proper prefix** which is also a **suffix**.

## Input Format
A single string `s` containing only lowercase English alphabets.

## Output Format
Return an integer representing the **length of the longest proper prefix** that is also a suffix.

## Examples

### Input

`s = "abab"`<br/>

### Output

`2`<br/>

**Explanation:** The string `"ab"` is the longest prefix and suffix.

### Input

`s = "aabcdaabc"`<br/>

### Output

`4`<br/>

**Explanation:** The string `"aabc"` is the longest prefix and suffix.

### Input

`s = "aaaa"`<br/>

### Output

`3`<br/>

**Explanation:** `"aaa"` is the longest prefix and suffix.

## Constraints
- **1 ≤ s.size() ≤ 10^6**
- `s` contains only lowercase English alphabets

## Notes
- **Prefix and suffix can be overlapping** but they should **not be equal to the entire string**
- A proper prefix means it cannot be the entire string itself

