
# Problem: Ways to Express an Integer as Sum of Powers

## Problem Description
Given two positive integers `n` and `x`, return **the number of ways** `n` can be expressed as the sum of the `x`th power of **unique positive integers**. In other words, find the number of sets of unique integers `[n1, n2, ..., nk]` where `n = n1^x + n2^x + ... + nk^x`.

Since the result can be very large, **return it modulo 10^9 + 7**.

## Input Format

Two positive integers `n` and `x`.

## Output Format

Return the number of ways to express `n` as the sum of `x`th powers of unique positive integers, modulo `10^9 + 7`.

## Examples

### Example 1
**Input:** `n = 10, x = 2`<br/>

**Output:** `1`<br/>

**Explanation:** We can express `n` as: `n = 3^2 + 1^2 = 10`. It can be shown that it is the only way to express `10` as the sum of the 2nd power of unique integers.

### Example 2
**Input:** `n = 4, x = 1`<br/>

**Output:** `2`<br/>

**Explanation:** We can express `n` in the following ways:
- `n = 4^1 = 4`
- `n = 3^1 + 1^1 = 4`

## Constraints
- **1 <= n <= 300**
- **1 <= x <= 5**

## Notes
For example, if `n = 160` and `x = 3`, one way to express `n` is `n = 2^3 + 3^3 + 5^3`.

