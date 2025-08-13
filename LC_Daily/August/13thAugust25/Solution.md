
# Solution Explanation

## Intuition
To check if a number is a **power of three**, we can either repeatedly divide by 3 until we can't anymore, or use the mathematical property that the **largest power of 3** within the integer range can only be divided by other powers of 3.

## Approach

**Method 1: Iterative Division**
- First check if `n` is **positive** (powers of 3 are always positive)
- Keep dividing `n` by 3 as long as it's **divisible by 3**
- If we end up with `1`, then the original number was a **power of 3**

**Method 2: Mathematical Property**
- The **largest power of 3** that fits in a 32-bit signed integer is `3^19 = 1162261467`
- If `n` is a **power of 3**, then `1162261467` must be **divisible by n**
- This works because `1162261467` can only be divided evenly by powers of 3

## Complexity
- **Method 1:**
  - Time Complexity: `O(log n)`
  - Space Complexity: `O(1)`
- **Method 2:**
  - Time Complexity: `O(1)`
  - Space Complexity: `O(1)`

## Summary
Both approaches work effectively. The **iterative method** is more intuitive and shows the mathematical reasoning clearly. The **mathematical property method** is more efficient with constant time complexity but requires knowledge of the largest power of 3 in the integer range. **Key corner cases** include negative numbers and zero, which are handled by checking if `n > 0`.

