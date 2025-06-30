# Problem: Given Length and Sum of Digits...

## Problem Description
You have a **positive integer m** and a **non-negative integer s**. Your task is to find the **smallest and the largest** of the numbers that have **length m and sum of digits s**. The required numbers should be **non-negative integers** written in the decimal base **without leading zeroes**.

## Input Format
The single line of the input contains a pair of integers `m, s` where:
- `m` is the **length** of the required numbers
- `s` is the **sum of the digits** of the required numbers

## Output Format
In the output print the pair of the required non-negative integer numbers — **first the minimum possible number, then the maximum possible number**. If **no numbers satisfying conditions** required exist, print the pair of numbers `"-1 -1"`.

## Examples

### Example 1
**Input:** `2 15`

**Output:** `69 96`

**Explanation:** Both numbers have length 2 and digit sum 15. `69` (6+9=15) is the minimum, `96` (9+6=15) is the maximum.

### Example 2
**Input:** `3 0`

**Output:** `-1 -1`

**Explanation:** No 3-digit number can have sum of digits 0 (would require leading zeros).

## Constraints
- `1 ≤ m ≤ 100`
- `0 ≤ s ≤ 900`

## Notes
- Numbers must be **non-negative integers** without leading zeros
- If `s = 0`, only valid case is when `m = 1` (the number "0")
- If `s > 9 × m`, no valid numbers exist (maximum possible sum with m digits is 9m)

