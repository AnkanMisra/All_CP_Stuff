
# Problem: G. Special Permutation

## Problem Description
A permutation of length `n` is an array `p = [p1, p2, ..., pn]`, which contains every integer from 1 to `n` (inclusive) and, moreover, each number appears exactly once. For example, `p = [3, 1, 4, 2, 5]` is a permutation of length 5.

For a given number `n` (`n >= 2`), find a permutation `p` in which **absolute difference of any two neighboring (adjacent) elements is between 2 and 4, inclusive**. Formally, find such permutation `p` that **2 <= |pi - pi+1| <= 4** for each `i` (1 <= i < n).

Print any such permutation for the given integer `n` or determine that it does not exist.

## Input Format
The first line contains an integer `t` (1 <= t <= 100) — **the number of test cases** in the input. Then `t` test cases follow.

Each test case is described by a single line containing an integer `n` (2 <= n <= 1000).

## Output Format
Print `t` lines. Print a permutation that meets the given requirements. If there are several such permutations, then print any of them. **If no such permutation exists, print -1**.

## Examples

### Input

`6`<br/>
`10`<br/>
`2`<br/>
`4`<br/>
`6`<br/>
`7`<br/>
`13`<br/>

### Output

`9 6 10 8 4 7 3 1 5 2`<br/>
`-1`<br/>
`3 1 4 2`<br/>
`5 3 6 2 4 1`<br/>
`5 1 3 6 2 4 7`<br/>
`13 9 7 11 8 4 1 3 5 2 6 10 12`<br/>

## Constraints
- **1 <= t <= 100** (number of test cases)
- **2 <= n <= 1000** (length of permutation)
- **2 <= |pi - pi+1| <= 4** for each adjacent pair in the permutation

## Notes
- The permutation must contain all integers from 1 to `n` exactly once
- Adjacent elements must have an absolute difference between 2 and 4 (inclusive)
- If multiple valid permutations exist, any one can be printed
- **Time limit: 2 seconds**
- **Memory limit: 256 megabytes**

