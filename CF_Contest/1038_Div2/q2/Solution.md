
# Solution Explanation

## Intuition
To maximize the total Manhattan distance when pairing up points, we want to pair points that are as far apart as possible. By sorting the points and pairing the smallest with the largest (in terms of coordinates), we can achieve a maximal sum.

## Approach
- For each test case:
  - Read all `n` points and store their coordinates along with their original indices.
  - **Sort the points by their `x` coordinate** (and by `y` as a tiebreaker).
  - Split the sorted list into two halves:
    - The first half contains the `m = n/2` points with the smallest `x` values.
    - The second half contains the `m` points with the largest `x` values.
  - **Sort the first half by increasing `y`** and the second half by decreasing `y`.
  - Pair the `i`-th point from the first half with the `i`-th point from the second half for all `i` from `0` to `m-1`.
  - Output the original indices of each pair.

## Complexity
- **Time Complexity:** `O(n log n)` per test case (due to sorting)
- **Space Complexity:** `O(n)` per test case (for storing points and indices)

## Summary
- The approach works because pairing the smallest and largest (in both `x` and `y`) maximizes the Manhattan distance for each pair, and thus the total sum.
- Sorting and splitting ensures that each pair is as far apart as possible in the coordinate space.
- This greedy strategy is optimal for maximizing the sum of Manhattan distances when all pairs must be disjoint.
- **Corner cases:** The method works for all even `n` and arbitrary coordinates, as long as the sum of all `n` across test cases fits within the constraints.

