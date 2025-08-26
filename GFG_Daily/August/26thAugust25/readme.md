
# Problem: Check if a String is Subsequence of Other

## Problem Description
Given two strings `s1` and `s2`, you have to **check that s1 is a subsequence of s2** or not.

**Note:** A subsequence is a sequence that can be derived from another sequence by **deleting some elements without changing the order** of the remaining elements.

## Input Format
- Two strings `s1` and `s2`

## Output Format
- Return `true` if `s1` is a subsequence of `s2`, otherwise return `false`

## Examples

### Input
`s1 = "AXY", s2 = "YADXCP"`<br/>

### Output
`false`<br/>

**Explanation:** `s1` is not a subsequence of `s2` as **'Y' appears before 'A'**.

### Input
`s1 = "gksrek", s2 = "geeksforgeeks"`<br/>

### Output
`true`<br/>

**Explanation:** If we combine the bold characters of "`g`ee`k`s`fo`r`g`e`e`k`s", it equals to `s1`. So **s1 is a subsequence of s2**.

## Constraints
- **1 ≤ s1.size(), s2.size() ≤ 10^6**

