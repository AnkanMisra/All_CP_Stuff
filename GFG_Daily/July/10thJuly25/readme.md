
# Problem: Find the longest string

## Problem Description
Given an array of strings `words[]`, find the **longest string** in `words[]` such that **every prefix** of it is also present in the array `words[]`.

- If there are **multiple strings** with the same maximum length, return the **lexicographically smallest** one.

## Input Format
- The first line contains an integer `n` (**1 ≤ n ≤ 10^3**), the number of strings in the array.
- The next line contains `n` space-separated strings representing the array `words[]`.

## Output Format
- Output a single string: the **longest string** in `words[]` such that every prefix of it is also present in `words[]`.

## Examples

### Input
`words[] = ["p", "pr", "pro", "probl", "problem", "pros", "process", "processor"]`<br/>

### Output
`pros`<br/>

**Explanation:** `"pros"` is the longest word with all prefixes (`"p"`, `"pr"`, `"pro"`, `"pros"`) present in the array `words[]`.

### Input
`words[] = ["ab", "a", "abc", "abd"]`<br/>

### Output
`abc`<br/>

**Explanation:** Both `"abc"` and `"abd"` have all the prefixes in `words[]`. Since `"abc"` is lexicographically smaller than `"abd"`, the output is `"abc"`.

## Constraints
- `1 ≤ words.length ≤ 10^3`
- Each string consists of lowercase English letters only.

## Notes
- Every prefix of a string `s` is any substring `s[0:i]` for `1 ≤ i ≤ len(s)`.
- The answer must be present in the original array `words[]`.

