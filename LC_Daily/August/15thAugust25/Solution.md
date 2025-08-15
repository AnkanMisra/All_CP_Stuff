
# Solution Explanation

## Intuition
A number is a **power of four** if it can be expressed as `4^x` for some non-negative integer `x`. The key insight is that powers of four have specific mathematical and bit-level properties that we can exploit for efficient detection.

## Approach
There are multiple approaches to solve this problem:

### Approach 1: Iterative Division
- **Check if the number is positive** (powers of four are always positive)
- **Repeatedly divide by 4** while the number is divisible by 4
- **Check if the final result is 1** - if yes, the original number was a power of four

### Approach 2: Bit Manipulation (Optimal)
- A power of four must satisfy **three conditions**:
  1. **Must be positive**
  2. **Must be a power of 2** (only one bit set in binary representation)
  3. **The set bit must be at an even position** (positions 0, 2, 4, 6, ...)
- Use `n & (n-1) == 0` to check if it's a power of 2
- Use `n & 0x55555555 != 0` to verify the bit is at an even position
- The mask `0x55555555` has bits set at all even positions

### Approach 3: Mathematical Property
- **Powers of four have a special mathematical property**: if `n` is a power of 4, then `(n-1) % 3 == 0`
- Combine this with the power of 2 check for a concise solution

## Algorithm
1. **Handle edge cases**: Return false for non-positive numbers
2. **For iterative approach**: Keep dividing by 4 until no longer divisible, check if result is 1
3. **For bit manipulation**: Verify it's a positive power of 2 with bit at even position
4. **For mathematical approach**: Check if it's a power of 2 and `(n-1) % 3 == 0`

## Complexity
- **Time Complexity**: `O(log n)` for iterative approach, `O(1)` for bit manipulation and mathematical approaches
- **Space Complexity**: `O(1)` for all approaches

## Summary
The **bit manipulation approach is optimal** as it runs in constant time without loops or recursion. The key insight is recognizing that powers of four are powers of two with their single set bit at even positions. The mathematical property `(n-1) % 3 == 0` provides an elegant alternative. **Corner cases** include handling negative numbers, zero, and ensuring the number is actually a power of 2 before checking additional conditions.
```java
class Solution {
    // Approach 1: Using loops/recursion
    public boolean isPowerOfFour(int n) {
        if (n <= 0) return false;

        while (n % 4 == 0) {
            n /= 4;
        }

        return n == 1;
    }

    // Approach 1 Alternative: Using recursion
    public boolean isPowerOfFourRecursive(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;
        if (n % 4 != 0) return false;

        return isPowerOfFourRecursive(n / 4);
    }

    // Approach 2: Without loops/recursion using bit manipulation
    public boolean isPowerOfFourOptimal(int n) {
        // A power of 4 must be:
        // 1. Positive
        // 2. A power of 2 (only one bit set)
        // 3. The set bit must be at an even position (0, 2, 4, 6, ...)

        // Check if n is positive and a power of 2
        if (n <= 0 || (n & (n - 1)) != 0) {
            return false;
        }

        // Check if the set bit is at an even position
        // 0x55555555 = 01010101010101010101010101010101 in binary
        // This mask has 1s at even positions (0, 2, 4, 6, ...)
        return (n & 0x55555555) != 0;
    }

    // Alternative approach 2: Using mathematical property
    public boolean isPowerOfFourMath(int n) {
        // A number is power of 4 if:
        // 1. It's a power of 2
        // 2. (n - 1) % 3 == 0
        return n > 0 && (n & (n - 1)) == 0 && (n - 1) % 3 == 0;
    }
}

```
