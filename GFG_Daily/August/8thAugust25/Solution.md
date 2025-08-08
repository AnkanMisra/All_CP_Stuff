
# Solution Explanation

## Intuition
This problem asks for the **longest proper prefix** that is also a **suffix**. The provided solution uses a **brute force approach** that systematically checks all possible prefix-suffix pairs by comparing characters from the beginning and different starting positions.

## Approach
The algorithm uses a **two-pointer technique** with a brute force strategy. It maintains pointers `p` (for prefix) and `su` (for suffix), along with a `count` to track the current match length and `pos` to track the starting position of the suffix being checked.

## Algorithm
1. Initialize `p = 0` (prefix pointer), `su = 1` (suffix pointer), `count = 0` (match length), and `pos = 1` (suffix start position)
2. While both pointers are within bounds:
   - If characters at `p` and `su` match, increment both pointers and increase `count`
   - If characters don't match, reset `p = 0`, `count = 0`, move to next suffix position by incrementing `pos`, and set `su = pos`
3. Continue until all possible suffix positions are checked
4. Return the final `count` as the length of the longest proper prefix-suffix

## Complexity
- **Time Complexity:** `O(n^2)` in the worst case, where `n` is the length of the string
- **Space Complexity:** `O(1)` as only a constant amount of extra space is used

## Summary
This **brute force approach** systematically checks every possible suffix position against the prefix from the beginning. While it correctly finds the longest proper prefix-suffix, it has **quadratic time complexity** in the worst case. The algorithm handles **overlapping patterns** correctly and ensures the result is a **proper prefix-suffix** (not the entire string).

