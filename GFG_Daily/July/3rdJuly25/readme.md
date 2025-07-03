```
# Problem: Longest Substring with K Uniques

## Problem Description
You are given a string `s` consisting only lowercase alphabets and an integer `k`. Your task is to **find the length of the longest substring that contains exactly k distinct characters**.

## Input Format
- A string `s` consisting only of lowercase alphabets
- An integer `k` representing the **exact number of distinct characters** required

## Output Format
- Return the **length of the longest substring** with exactly `k` distinct characters
- If **no such substring exists**, return `-1`

## Examples

### Input
`s = "aabacbebebe", k = 3`<br/>
### Output
`7`<br/>
**Explanation:** The longest substring with exactly 3 distinct characters is **"cbebebe"**, which includes 'c', 'b', and 'e'.

### Input
`s = "aaaa", k = 2`<br/>
### Output
`-1`<br/>
**Explanation:** There's no substring with 2 distinct characters.

### Input
`s = "aabaaab", k = 2`<br/>
### Output
`7`<br/>
**Explanation:** The entire string **"aabaaab"** has exactly 2 unique characters 'a' and 'b', making it the longest valid substring.

## Constraints
- `1 ≤ s.size() ≤ 10^5`
- `1 ≤ k ≤ 26`

## Notes
- The substring must contain **exactly k distinct characters**, not at most or at least
- Only lowercase alphabets are present in the input string
- Consider all possible substrings when finding the maximum length
```

