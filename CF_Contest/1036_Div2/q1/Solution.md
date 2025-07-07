# Solution Explanation

## Intuition
The main idea is to check if there exists any pair of consecutive elements in the array where the first is greater than the second. If such a pair exists, we can form a derangement by keeping just these two elements, as their sorted order will differ from their original order at both positions.

## Approach
- For each test case:
  - Read the array `a` of length `n`.
  - Iterate through the array and look for the first position `d` where `a[d] > a[d+1]`.
  - If such a position is found:
    - Output `YES`.
    - Output `2` (the number of elements in the derangement).
    - Output the two elements `a[d]` and `a[d+1]`.
  - If no such position exists, output `NO`.

## Complexity
- Time Complexity: `O(n)` per test case
- Space Complexity: `O(n)` per test case (for storing the array)

## Summary
- The approach works because any two consecutive elements where the first is greater than the second will always form a derangement when taken as a subarray of length 2.
- If the array is non-decreasing, no such pair exists, so it is impossible to form a derangement.
- The solution is efficient and directly checks the necessary condition for a derangement to exist in the given array.

