# Problem: Maximum Score From Removing Substrings

## Problem Description
You are given a string `s` and two integers `x` and `y`. You can perform two types of operations any number of times:
- Remove substring `"ab"` and gain **x points**.
- Remove substring `"ba"` and gain **y points**.

For example, removing `"ab"` from `"cabxbae"` becomes `"cxbae"`, and removing `"ba"` from `"cabxbae"` becomes `"cabxe"`.

Your task is to **return the maximum points you can gain** after applying the above operations on `s`.

## Input Format
- A string `s` consisting of lowercase English letters.
- Two integers: `x` (points for removing `"ab"`) and `y` (points for removing `"ba"`).

## Output Format
- An integer representing the **maximum points** you can gain after performing the operations.

## Examples

### Input
s = `"cdbcbbaaabab"`, x = `4`, y = `5`
<br/>

### Output
`19`
<br/>

### Input
s = `"aabbaaxybbaabb"`, x = `5`, y = `4`
<br/>

### Output
`20`
<br/>

## Constraints
- `1 <= s.length <= 10^5`
- `1 <= x, y <= 10^4`
- `s` consists of lowercase English letters.

## Notes
- You may perform the operations in any order and any number of times to maximize your score.
- Removing one substring may create new opportunities for further removals.


