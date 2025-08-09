class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}

// Alternative approaches:

// Approach 1: Using bit manipulation with rightmost bit
// class Solution {
//     public boolean isPowerOfTwo(int n) {
//         return n > 0 && (n & -n) == n;
//     }
// }

// Approach 2: Using Integer.bitCount() method
// class Solution {
//     public boolean isPowerOfTwo(int n) {
//         return n > 0 && Integer.bitCount(n) == 1;
//     }
// }

// Approach 3: Using logarithms (less efficient)
// class Solution {
//     public boolean isPowerOfTwo(int n) {
//         if (n <= 0) return false;
//         double log = Math.log(n) / Math.log(2);
//         return log == Math.floor(log);
//     }
// }
