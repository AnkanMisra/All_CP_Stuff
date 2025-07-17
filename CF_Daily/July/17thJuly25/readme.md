
# Problem: Two Substrings

## Problem Description
You are given a string `s`. Your task is to determine if the given string `s` contains **two non-overlapping substrings** `AB` and `BA` (the substrings can appear in any order).

## Input Format
- The only line of input contains a string `s` of length between **1 and 10^5** consisting of **uppercase Latin letters**.

## Output Format
- Print `YES` if the string contains two non-overlapping substrings `AB` and `BA` (in any order).
- Print `NO` otherwise.

## Examples

### Input

ABA
<br/>

### Output

NO
<br/>

### Input

BACFAB
<br/>

### Output

YES
<br/>

### Input

AXBYBXA
<br/>

### Output

NO
<br/>

## Constraints
- `1 ≤ length of s ≤ 10^5`
- `s` consists of uppercase Latin letters only.

## Notes
- In the first sample, although there are substrings `AB` and `BA`, their occurrences overlap, so the answer is `NO`.
- In the second sample, there are non-overlapping occurrences of `AB` and `BA`.
- In the third sample, there is no substring `AB` nor substring `BA`.

