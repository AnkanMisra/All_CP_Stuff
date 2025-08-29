
# Problem: Smallest Window Containing All Characters

## Problem Description
Given two strings `s` and `p`. Find the **smallest substring** in `s` consisting of **all the characters** (including duplicates) of the string `p`. Return **empty string** in case no such substring is present.

If there are **multiple such substrings of the same length** found, return the one with the **least starting index**.

## Input Format
- Two strings `s` and `p`
- `s`: The main string to search in
- `p`: The pattern string containing characters to find

## Output Format
- Return the **smallest substring** of `s` that contains all characters of `p`
- Return **empty string** `""` if no such substring exists

## Examples

### Input
`s = "timetopractice", p = "toc"`<br/>

### Output
`"toprac"`<br/>

**Explanation:** `"toprac"` is the smallest substring in which `"toc"` can be found.

### Input
`s = "zoomlazapzo", p = "oza"`<br/>

### Output
`"apzo"`<br/>

**Explanation:** `"apzo"` is the smallest substring in which `"oza"` can be found.

### Input
`s = "zoom", p = "zooe"`<br/>

### Output
`""`<br/>

**Explanation:** No substring is present containing all characters of `p`.

## Constraints
- **1 ≤ s.length(), p.length() ≤ 10^6**
- `s`, `p` consists of **lowercase english letters**

## Notes
- The substring must contain **all characters** from `p`, including duplicates
- If multiple substrings of the same minimum length exist, return the one with the **smallest starting index**
- This is a classic **sliding window** problem that can be solved efficiently using the **two-pointer technique**

