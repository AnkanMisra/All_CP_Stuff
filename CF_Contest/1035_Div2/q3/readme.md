# Problem: A Good Problem

## Problem Description
You are given **four positive integers** `n`, `l`, `r`, and `k`. Your task is to find the **lexicographically smallest** array `a` of length `n`, consisting of integers, such that:

- For every `1 ≤ i ≤ n`, **`l ≤ a_i ≤ r`**.
- The **bitwise AND** of all elements is equal to the **bitwise XOR** of all elements, i.e., `a_1 & a_2 & ... & a_n = a_1 ⊕ a_2 ⊕ ... ⊕ a_n` (where `&` denotes bitwise AND and `⊕` denotes bitwise XOR).

If **no such array exists**, output `-1`. Otherwise, since the entire array might be too large to output, output only `a_k` (the `k`-th element of the array).

An array `a` is **lexicographically smaller** than an array `b` if and only if one of the following holds:
- `a` is a prefix of `b`, but `a ≠ b`;
- In the first position where `a` and `b` differ, the array `a` has a smaller element than the corresponding element in `b`.

## Input Format
- The first line contains the number of test cases `t` (`1 ≤ t ≤ 10^4`).
- Each test case contains four positive integers: `n`, `l`, `r`, `k` (`1 ≤ k ≤ n ≤ 10^{18}`, `1 ≤ l ≤ r ≤ 10^{18}`).

## Output Format
- For each test case, output `a_k` (the `k`-th element of the array) or `-1` if no such array exists.

## Constraints
- `1 ≤ t ≤ 10^4`
- `1 ≤ k ≤ n ≤ 10^{18}`
- `1 ≤ l ≤ r ≤ 10^{18}`

## Examples

**Input:** `1 4 4 1`<br/>
**Output:** `4`<br/>

**Input:** `3 1 3 3`<br/>
**Output:** `1`<br/>

**Input:** `4 6 9 2`<br/>
**Output:** `6`<br/>

**Input:** `4 6 9 3`<br/>
**Output:** `8`<br/>

**Input:** `4 6 7 4`<br/>
**Output:** `-1`<br/>

## Notes
- If there is **no array** that meets the requirements, output `-1`.
- Only output the `k`-th element of the array, not the entire array.

