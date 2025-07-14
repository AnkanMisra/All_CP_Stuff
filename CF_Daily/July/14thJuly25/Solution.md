
# Solution Explanation

## Intuition
To ensure all subarrays of length `k` have the same sum, the array must be **k-periodic**—that is, every element matches the one `k` positions ahead. This means the array is built by repeating a fixed pattern of length `k`. The pattern must include all distinct elements from the original array `a`, since `a` must appear as a subsequence in the final array.

If the number of distinct elements in `a` is greater than `k`, it is **impossible** to construct such a pattern, as there is not enough space in a period of length `k` to fit all distinct values.

## Approach
- Collect all **distinct elements** from the input array `a`.
- If the number of distinct elements is greater than `k`, output `-1` (impossible).
- Otherwise, construct a pattern of length `k`:
  - Start with all distinct elements from `a` (in any order).
  - If the pattern is shorter than `k`, pad it with any valid number (e.g., `1`) until its length is exactly `k`.
- Repeat this pattern `n` times to form the final array. This guarantees that every subarray of length `k` has the same sum, and the original array `a` appears as a subsequence.

## Complexity
- **Time Complexity:** `O(n)` per test case (for collecting distinct elements and printing the result)
- **Space Complexity:** `O(k)` (for storing the pattern)

## Summary
The solution relies on the insight that a beautiful array must be k-periodic, and the period must contain all distinct elements of the original array. If there are too many distinct elements, it is impossible. Otherwise, repeating the constructed pattern ensures all subarrays of length `k` have the same sum, and the original array can be embedded as a subsequence.

