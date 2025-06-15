# 1432. Max Difference You Can Get From Changing an Integer

## Problem Statement

You are given an integer `num`. You will apply the following steps to `num` two separate times:

1. Pick a digit `x` (0 ≤ x ≤ 9).
2. Pick another digit `y` (0 ≤ y ≤ 9). Note `y` can be equal to `x`.
3. Replace all the occurrences of `x` in the decimal representation of `num` by `y`.

Let `a` and `b` be the two results from applying the operation to `num` independently.

Return the **max difference** between `a` and `b`.

**Note:** Neither `a` nor `b` may have any leading zeros, and must not be 0.

## Input Format

- An integer `num` (1 ≤ num ≤ 10^8)

## Output Format

- An integer representing the maximum difference between two numbers obtained by the described operation.

## Examples

### Example 1

Input:  
num = 555

Output:  
888

Explanation:  
- The first time, pick x = 5 and y = 9 and store the new integer in a = 999.
- The second time, pick x = 5 and y = 1 and store the new integer in b = 111.
- The max difference is 888.

### Example 2

Input:  
num = 9

Output:  
8

Explanation:  
- The first time, pick x = 9 and y = 9 and store the new integer in a = 9.
- The second time, pick x = 9 and y = 1 and store the new integer in b = 1.
- The max difference is 8.

## Constraints

- 1 ≤ num ≤ 10^8
