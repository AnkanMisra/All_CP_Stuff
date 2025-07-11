
# Problem: C. Drazil and Factorial

## Problem Description
Drazil and Varda are playing a math game. For a given positive integer `x`, define its value as the product of the factorials of its digits. For example, if `x = 123`, then its value is `1! * 2! * 3! = 1 * 2 * 6 = 12`.

Given a decimal number `a` consisting of `n` digits (possibly with leading zeroes, and at least one digit greater than 1), find the **maximum positive integer `x`** (with no digits 0 or 1) such that the product of the factorials of the digits of `x` is equal to the product of the factorials of the digits of `a`.

**Note:** The resulting number `x` must not contain the digits 0 or 1 in its decimal representation.

## Input Format
- The first line contains an integer `n` — the number of digits in `a`.
- The second line contains `n` digits of `a`. The number may have leading zeroes and at least one digit greater than 1.

## Output Format
- Output the **maximum possible integer** `x` (with no digits 0 or 1) such that the product of the factorials of its digits equals the product of the factorials of the digits of `a`.

## Examples

### Input
4
1234
<br/>
### Output
33222
<br/>

### Input
3
555
<br/>
### Output
555
<br/>

## Constraints
- `1 ≤ n ≤ 15`
- The number `a` contains at least one digit greater than 1.

## Notes
- The number `a` may have leading zeroes.
- The answer should not contain any zeroes or ones in its decimal representation.

