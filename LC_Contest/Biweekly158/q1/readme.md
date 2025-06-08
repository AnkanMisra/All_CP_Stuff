# 3572. Maximize Y‑Sum by Picking a Triplet of Distinct X‑Values

## Problem Statement

You are given two integer arrays `x` and `y`, each of length `n`. You must choose three **distinct** indices `i`, `j`, and `k` such that:

- `x[i] != x[j]`
- `x[j] != x[k]`
- `x[k] != x[i]`

Your goal is to **maximize** the value of `y[i] + y[j] + y[k]` under these conditions. Return the maximum possible sum that can be obtained by choosing such a triplet of indices.

If no such triplet exists, return `-1`.

## Input Format

- Two integer arrays `x` and `y`, each of length `n`.

## Output Format

- An integer representing the maximum possible sum of `y[i] + y[j] + y[k]` for three distinct indices with distinct `x` values, or `-1` if no such triplet exists.

## Constraints

- `n == x.length == y.length`
- `3 <= n <= 10^5`
- `1 <= x[i], y[i] <= 10^6`

## Examples

### Example 1

Input:  
x = [1, 2, 1, 3, 2]  
y = [5, 3, 4, 6, 2]  

Output:  
14  

Explanation:  
- Choose `i = 0` (`x[0] = 1`, `y[0] = 5`), `j = 1` (`x[1] = 2`, `y[1] = 3`), `k = 3` (`x[3] = 3`, `y[3] = 6`).
- All three values chosen from `x` are distinct.
- The sum is `5 + 3 + 6 = 14`, which is the maximum possible.

### Example 2

Input:  
x = [1, 2, 1, 2]  
y = [4, 5, 6, 7]  

Output:  
-1  

Explanation:  
- There are only two distinct values in `x`, so it is impossible to pick three indices with distinct `x` values.
