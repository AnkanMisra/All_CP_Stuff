
# Solution Explanation

## Intuition
The key insight is to **split the string into two parts** and find the **maximum odd-length palindrome** in each part. We need to try all possible split points and find the combination that gives the **maximum sum**.

Since we need to find palindromes efficiently, we use **Manacher's algorithm** to precompute all odd-length palindromes in `O(n)` time.

## Approach
The solution uses a **two-phase dynamic programming approach** combined with **Manacher's algorithm**:

1. **Palindrome Detection**: Use **Manacher's algorithm** to find all odd-length palindromes and their radii in `O(n)` time.

2. **Left-to-Right Pass**: For each position `i`, compute `maxPref[i]` - the **maximum length** of any odd palindrome that **ends at or before position** `i`.

3. **Right-to-Left Pass**: For each position `i`, compute `maxSuff[i]` - the **maximum length** of any odd palindrome that **starts at or after position** `i`.

4. **Optimal Split**: Try all possible split points `i` where the first palindrome ends before position `i` and the second palindrome starts after position `i`. The answer is `max(maxPref[i] + maxSuff[i+1])` for all valid `i`.

## Algorithm
1. Apply **Manacher's algorithm** to get palindrome radii for all centers.
2. Use **priority queues** to efficiently compute:
   - `maxEnd[i]`: Maximum length of palindrome ending exactly at position `i`
   - `maxStart[i]`: Maximum length of palindrome starting exactly at position `i`
3. Compute **prefix maximums** (`maxPref`) and **suffix maximums** (`maxSuff`).
4. Find the **optimal split point** that maximizes the sum.

## Complexity
- **Time Complexity:** `O(n log n)` due to priority queue operations, where `n` is the length of the string
- **Space Complexity:** `O(n)` for storing palindrome information and auxiliary arrays

## Summary
This approach works by **efficiently precomputing palindrome information** using Manacher's algorithm and then using **dynamic programming** to find the optimal way to split the string. The key insight is that we can **decouple the problem** into finding the best palindrome in the left part and the best palindrome in the right part for each possible split point. The priority queues help us efficiently maintain the maximum palindrome lengths as we process positions from left to right and right to left.

