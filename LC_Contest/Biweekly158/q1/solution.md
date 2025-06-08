# Solution Explanation

## Intuition
To maximize the sum of `y[i] + y[j] + y[k]` for three distinct indices with distinct `x` values, we should pick the largest possible `y` values corresponding to three different `x` values. For each unique value in `x`, keep only the maximum `y` associated with it. Then, select the top three largest `y` values from these.

## Approach
- Use a hash map to store, for each unique `x` value, the maximum `y` value found at any index with that `x`.
- If there are fewer than three unique `x` values, return `-1` (not possible).
- Otherwise, collect all the maximum `y` values, sort them in descending order, and sum the top three.

## Complexity
- Time Complexity: O(n) to build the map, O(m log m) to sort the values (where m is the number of unique `x` values, m ≤ n).
- Space Complexity: O(m) for the map and list of values.

## Summary
By keeping only the best `y` for each unique `x` and summing the top three, we ensure the maximum possible sum for a valid triplet with distinct `x` values.
