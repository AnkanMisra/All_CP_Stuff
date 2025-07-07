# Solution Explanation

## Intuition
The main idea is to count the number of pairs `(i, j)` with `i < j` such that `a[i] + a[j] > b[i] + b[j]`. This can be reframed as counting pairs where the sum of differences `diff[i] + diff[j] > 0`, where `diff[i] = a[i] - b[i]`.

## Approach
- Compute the difference array `diff[]` where each element is `a[i] - b[i]`.
- Sort the `diff[]` array to enable efficient pair counting.
- For each index `i` from `0` to `n-2`:
  - If `diff[i] > 0`, all pairs `(i, j)` with `j > i` will satisfy the condition, so add `(n - 1 - i)` to the count.
  - Otherwise, use binary search to find the smallest index `left > i` such that `diff[left] > -diff[i]`. All such `j` will satisfy `diff[i] + diff[j] > 0`, so add `(n - left)` to the count.
- Output the total count.

## Complexity
- **Time Complexity:** `O(n log n)` (due to sorting and binary search for each element)
- **Space Complexity:** `O(n)` (for the difference array)

## Summary
By transforming the problem into a pairwise sum of differences and sorting, we can efficiently count all valid pairs using binary search. This approach leverages sorting and searching to avoid brute-force enumeration, ensuring optimal performance for large inputs.

