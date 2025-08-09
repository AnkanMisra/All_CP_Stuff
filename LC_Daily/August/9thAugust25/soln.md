# Solution Explanation

## Intuition
A **power of two** has exactly one bit set in its binary representation. For example, `1 = 2^0` has binary `1`, `2 = 2^1` has binary `10`, `4 = 2^2` has binary `100`, etc. We can use **bit manipulation** to check this property efficiently.

## Approach
The key insight is that for any power of two `n`, the expression `n & (n-1)` will always equal `0`. This works because:
- A power of two has exactly **one bit set** (e.g., `8` = `1000` in binary)
- Subtracting 1 from a power of two **flips all bits** after and including the set bit (e.g., `7` = `0111` in binary)
- The AND operation between these two numbers results in `0`

However, we must also ensure that `n` is **positive**, since negative numbers and zero are not powers of two.

## Algorithm
1. **Check if n is positive**: If `n <= 0`, return `false`
2. **Apply bit manipulation**: Check if `n & (n-1) == 0`
3. **Return result**: If both conditions are met, return `true`; otherwise, return `false`

## Complexity
- **Time complexity:** `O(1)` - Single bit operation
- **Space complexity:** `O(1)` - No extra space needed

## Summary
This approach leverages the **binary representation property** of powers of two to solve the problem in constant time without loops or recursion. The bit manipulation technique `n & (n-1)` is a classic method for checking if a number has exactly one bit set, making it perfect for identifying powers of two.
