# D. Retaliation

## Problem Statement

Yousef wants to explode an array `a1, a2, ..., an`. An array gets **exploded** when all of its elements become equal to zero.

In one operation, Yousef can do **exactly one** of the following:
1. For every index `i` in `a`, decrease `ai` by `i`.
2. For every index `i` in `a`, decrease `ai` by `n - i + 1`.

Your task is to help Yousef determine if it is possible to explode the array using any number of operations (of either type, in any order).

## Input Format

- The first line contains an integer `t` (1 ≤ t ≤ 10^4) — the number of test cases.
- For each test case:
  - The first line contains an integer `n` (2 ≤ n ≤ 2⋅10^5) — the size of the array.
  - The second line contains `n` integers `a1, a2, ..., an` (1 ≤ ai ≤ 10^9) — the elements of the array.

It is guaranteed that the sum of `n` over all test cases does not exceed 2⋅10^5.

## Output Format

For each test case, print `"YES"` if Yousef can explode the array, otherwise output `"NO"`.

You can output the answer in any case (upper or lower).

## Examples

### Input
6  
4  
3 6 6 3  
5  
21 18 15 12 9  
10  
2 6 10 2 5 5 1 2 4 10  
7  
10 2 16 12 8 20 4  
2  
52 101  
2  
10 2  

### Output
NO  
YES  
NO  
NO  
YES  
NO  

## Explanation

- In the second test case:
    - Perform 1 operation of the first type: The array becomes [20, 16, 12, 8, 4].
    - Perform 4 operations of the second type: The array becomes [0, 0, 0, 0, 0].
    - Thus, it is possible to explode the array, so the answer is `YES`.

- In the first, third, fourth, and sixth test cases, it can be proven that it is impossible to make all elements equal to zero using any number of operations.
