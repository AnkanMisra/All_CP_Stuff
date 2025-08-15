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
