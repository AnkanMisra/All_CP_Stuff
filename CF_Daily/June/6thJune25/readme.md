# E. Wolf

## Problem Statement

You are given a permutation `p` of length `n` (i.e., an array containing every integer from 1 to n exactly once). For each of `q` queries, you are given integers `l`, `r`, and `k`. You want to perform a binary search (as defined in the problem) for `k` in the subarray `p[l..r]`. Before the search, you may choose a non-negative integer `d` and `d` indices (not containing any index where `p[i] = k`) in `[l, r]` and reorder the elements at those indices however you like.

For each query, output the minimum `d` such that the binary search for `k` in `p[l..r]` can be successful, or `-1` if it is impossible.

## Input Format

- The first line contains a single integer `t` (1 ≤ t ≤ 10^4) — the number of test cases.
- For each test case:
  - The first line contains two integers `n` and `q` (1 ≤ n, q ≤ 2⋅10^5).
  - The second line contains `n` integers `p1, p2, ..., pn` — the permutation.
  - The next `q` lines each contain three integers `l`, `r`, and `k` (1 ≤ l ≤ r ≤ n, 1 ≤ k ≤ n).

It is guaranteed that the sum of `n` and the sum of `q` over all cases do not exceed 2⋅10^5.

## Output Format

For each query, output the minimum integer `d` that must be chosen so that the binary search for `k` in `p[l..r]` is successful, or `-1` if it is impossible.

## Examples

### Input
8  
5 3  
1 2 3 4 5  
1 5 4  
1 3 4  
3 4 4  
7 4  
3 1 5 2 7 6 4  
3 4 2  
2 3 5  
1 5 6  
1 7 3  
2 1  
2 1  
1 2 1  
1 1  
1  
1 1 1  
7 1  
3 4 2 5 7 1 6  
1 7 1  
16 1  
16 10 12 6 13 9 14 3 8 11 15 2 7 1 5 4  
1 16 4  
16 1  
14 1 3 15 4 5 6 16 7 8 9 10 11 12 13 2  
1 16 14  
13 1  
12 13 10 9 8 4 11 5 7 6 2 1 3  
1 13 2  

### Output
0 -1 0  
2 0 -1 4  
-1  
0  
-1  
-1  
-1  
-1  

## Explanation

- In the first test case, for the first query, `k=4` is present in the range `[1,5]`, and no reordering is needed (`d=0`).
- In the second query, `k=4` is not present in `[1,3]`, so it is impossible (`-1`).
- In the second test case, for the first query, you can reorder two indices to make the binary search succeed, so the answer is `2`.
