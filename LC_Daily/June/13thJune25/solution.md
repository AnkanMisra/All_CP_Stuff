# Solution Explanation

## Intuition
The problem asks for the minimum possible value of the maximum difference among `p` pairs, where no index is used more than once. This is a classic "minimize the maximum" problem, which can be efficiently solved using binary search and greedy pairing.

## Approach
- **Sort the array**: Sorting allows us to pair adjacent elements to minimize the difference.
- **Binary Search**: We binary search on the answer (the maximum allowed difference in a pair).
    - For each candidate value `v`, check if it's possible to form at least `p` pairs such that the difference in each pair is at most `v`.
- **Greedy Pairing**: For a given `v`, scan the sorted array and greedily pair adjacent elements if their difference is ≤ `v`, skipping both indices if paired.
- The smallest `v` for which we can form `p` pairs is the answer.

## Complexity
- Time Complexity: O(n log W), where n is the length of the array and W is the range of possible differences (up to 10^9).
- Space Complexity: O(1) extra space (excluding sorting).

## Summary
By sorting the array and using binary search with a greedy pairing check, we efficiently find the minimum possible value of the maximum difference among all `p` pairs, ensuring no index is used more than once.
