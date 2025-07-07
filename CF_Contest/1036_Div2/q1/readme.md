# A. Deranged Deletions

## Problem Description
You are given an array `a` of length `n`. In one operation, you can **delete any element** from `a`. The order of the remaining elements is **preserved** after each deletion.

An array `b` of length `m` is called a **derangement** if, after sorting a copy of `b` (let's call it `c`), **no element in `b` is at the same position as in `c`**; that is, for all `1 ≤ i ≤ m`, `b_i ≠ c_i`.

Your task is to determine whether it is possible to perform some (possibly none) deletions so that the remaining array forms a **derangement**. The resulting array must be **non-empty**.

## Input Format
- The first line contains the number of test cases `t` (**1 ≤ t ≤ 100**).
- For each test case:
  - The first line contains an integer `n` (**1 ≤ n ≤ 100**) — the length of array `a`.
  - The second line contains `n` integers `a_1, a_2, ..., a_n` (**1 ≤ a_i ≤ n**) — the elements of the array.

## Output Format
- For each test case, output on a new line:
  - If it is possible to obtain a derangement, output `YES`.
    - Then output two more lines:
      - The first line should contain an integer `k` (**1 ≤ k ≤ n**) — the number of elements remaining.
      - The second line should contain `k` integers — the elements of the resulting derangement array.
  - Otherwise, output `NO`.
- You can output in any case (e.g., `YES`, `yes`, `Yes`).

## Constraints
- **1 ≤ t ≤ 100**
- **1 ≤ n ≤ 100**
- **1 ≤ a_i ≤ n**

## Examples

### Input
3<br/>
3<br/>
2 2 3<br/>
5<br/>
4 5 5 2 4<br/>
1<br/>
1<br/>

### Output
NO<br/>
YES<br/>
4<br/>
4 5 2 4<br/>
NO<br/>

## Notes
- In the second test case, you can delete one `5` from the array so that it becomes `4 5 2 4`. This array is a derangement. The original array `4 5 5 2 4` is also a valid derangement.
- The remaining array after deletions must be **non-empty** and must be a derangement as defined above.

