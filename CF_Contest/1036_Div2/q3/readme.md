# C. Subset Multiplication

## Problem Description
Alice has an array `a` of length `n` consisting of positive integers, with the **beautiful property** that `a_i` divides `a_{i+1}` for each `1 ≤ i ≤ n-1`.

Bob creates an array `b` of size `n` such that `b_i = a_i` for all `1 ≤ i ≤ n`. Then, he chooses a positive integer `x` and multiplies some (possibly none, possibly all) elements in `b` by `x`. Formally, he chooses a (possibly-empty) subset `S ⊆ {1, 2, ..., n}` and for each `i ∈ S`, sets `b_i := b_i * x`.

You are given the array `b`, but you do not know the original array `a` or the chosen number `x`. Your task is to **output any integer `x`** that Bob could have chosen, so that multiplying some subset of elements of the correct array `a` by `x` would result in array `b`.

It is guaranteed that at least one such `x` exists. If there are multiple possible values, you can output any of them.

## Input Format
- The first line contains the number of test cases `t` (**1 ≤ t ≤ 2⋅10^5**).
- For each test case:
  - The first line contains an integer `n` (**2 ≤ n ≤ 6⋅10^5**) — the length of the array `b`.
  - The second line contains `n` integers `b_1, b_2, ..., b_n` (**1 ≤ b_i ≤ 10^9**).
- It is guaranteed that the sum of `n` over all test cases does not exceed **6⋅10^5**.
- It is guaranteed that the array `b` can be obtained from some beautiful array `a` and some positive integer `x` as described.

## Output Format
- For each test case, output any possible value of `x` (**1 ≤ x ≤ 10^9**) on a new line. It is guaranteed that at least one value of `x` exists.

## Examples

**Input:**

`4`<br/>
`2`<br/>
`2 4`<br/>
`3`<br/>
`1 1000000000 500000000`<br/>
`4`<br/>
`4 8 4 8`<br/>
`7`<br/>
`42 42 14 84 28 73080 255780`<br/>

**Output:**

`343`<br/>
`2`<br/>
`4`<br/>
`6`<br/>

## Constraints
- `1 ≤ t ≤ 2⋅10^5`
- `2 ≤ n ≤ 6⋅10^5`
- `1 ≤ b_i ≤ 10^9`
- The sum of `n` over all test cases does not exceed `6⋅10^5`.

## Notes
- In the first test case, it is possible Bob selected `x = 343` and `S = {}` (meaning he did not change the array `a` at all).
- In the third test case, it is possible Bob selected `x = 4` and `S = {1, 2}`, meaning he multiplied both `b_1` and `b_2` by `4`. The original array was `[1, 2, 4, 8]`, which satisfies the required property.

