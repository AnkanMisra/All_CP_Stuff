
# Problem: Longest Periodic Proper Prefix

## Problem Description
Given a string `s`, find the **length of longest periodic proper prefix** of `s`. If no such prefix exists, return `-1`.

A **periodic proper prefix** is a **non-empty prefix** of `s` (but not the whole string), such that **repeating this prefix enough times** produces a string that **starts with `s`**.

## Input Format
A string `s` consisting of lowercase English alphabets.

## Output Format
An integer representing the **length of the longest periodic proper prefix**, or `-1` if no such prefix exists.

## Examples

### Input

`s = "aaaaaa"`<br/>

### Output

`5`<br/>

**Explanation:** Repeating the proper prefix `"aaaaa"` forms `"aaaaaaaaaa..."`, which contains `"aaaaaa"` as a prefix. No longer proper prefix satisfies this.

### Input

`s = "abcab"`<br/>

### Output

`3`<br/>

**Explanation:** Repeating the proper prefix `"abc"` forms `"abcabc..."`, which contains `"abcab"` as a prefix. No longer proper prefix satisfies this.

### Input

`s = "ababd"`<br/>

### Output

`-1`<br/>

**Explanation:** No proper prefix satisfying the given condition exists.

## Constraints
- `1 ≤ s.size() ≤ 10^5`
- `s` consists of **lowercase English alphabets** only

