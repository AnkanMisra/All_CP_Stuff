# Solution Explanation

## Intuition
The problem asks us to count the number of arrays of length `n` where each element is between `1` and `m`, and there are exactly `k` pairs of adjacent elements that are equal (i.e., `arr[i-1] == arr[i]`).

Let's break down the conditions:
1.  **Exactly `k` matching adjacent elements**: This means out of the `n-1` possible adjacent pairs `(arr[i-1], arr[i])`, exactly `k` of them must have `arr[i-1] == arr[i]`.
2.  **The remaining `(n-1) - k` pairs must have `arr[i-1] != arr[i]`**. These are the "breaks" or "transitions" between different values.

If there are `k` matching adjacent elements and `(n-1) - k` non-matching adjacent elements, this means the array can be seen as `n-k` distinct "blocks" or segments of identical consecutive values. For example, if `n=5, k=2`, an array like `[1,1,2,2,3]` has 2 matches (at index 1 and index 3) and `(5-1)-2 = 2` non-matches (at index 2 and index 4). This results in `5-2 = 3` blocks: `[1,1]`, `[2,2]`, `[3]`.

The problem then splits into two independent parts:
1.  **Choosing the positions of the `k` matches**: From `n-1` possible adjacent pairs, we need to choose `k` pairs to be equal. The number of ways to do this is given by the binomial coefficient "n-1 choose k", or \(C(n-1, k)\).
2.  **Assigning values to the elements/blocks**: Once the positions of matches and non-matches are fixed, we need to assign values to the `n` elements.

Let `P = n - k` be the number of "segments" or blocks of identical values.
- The first element `arr[0]` (or the first segment's value) can be any of `m` values.
- Each of the subsequent `(P - 1)` segments must have a value different from the preceding segment. Since there are `m` possible values in total, each of these `(P - 1)` segments has `(m-1)` choices.

So, the number of ways to assign values to these `P` segments such that adjacent segments have different values is `m * (m-1)^(P-1)`.
Substituting `P = n-k`, this becomes `m * (m-1)^(n-k-1)`.

The total number of good arrays is the product of these two parts:
`Total Good Arrays = C(n-1, k) * m * (m-1)^(n-k-1)`

All calculations must be performed modulo \(10^9 + 7\).

## Approach
1.  **Precompute Factorials and Inverse Factorials**: Since we need to calculate binomial coefficients \(C(N, K)\) and \(N\) can be up to \(10^5\), precomputing factorials and their modular inverses is necessary for efficient calculation of combinations.
2.  **Modular Exponentiation**: Implement a function for modular exponentiation to calculate `(base^exponent) % MOD` efficiently.
3.  **Calculate Combination (NCR)**: Use the precomputed factorials and inverse factorials to calculate \(C(\text{total}, \text{choose})\) modulo MOD.
4.  **Main Calculation**:
    *   Calculate `combinations = C(n-1, k)`.
    *   Calculate `powerTerm = (m-1)^(n-k-1) % MOD` using modular exponentiation. Note that if `n-k-1` is 0 (i.e., `n-k=1`, meaning `k=n-1`), `(m-1)^0 = 1`.
    *   Calculate `valueAssignments = (m * powerTerm) % MOD`.
    *   The final result is `(combinations * valueAssignments) % MOD`.

## Complexity
-   **Time Complexity**:
    *   `initializeFactorials`: O(N_max) where N_max is the maximum possible value of `n` (10^5) for precomputation. This happens once per test case *batch* (or effectively, once overall if called with `len` being `N_MAX`).
    *   `countGoodArrays` function:
        *   `computeNCR`: O(1) after precomputation.
        *   `power`: O(log(exponent)) which is O(log n).
        *   The overall time complexity per test case is dominated by the precomputation if it's done for each test case, making it O(N_max). If precomputation is done only once for the maximum N, then each test case is O(log N). Given the sum of N constraint, it means the total complexity is O(sum_of_n). So, O(N_max + sum_of_n) or just O(sum_of_n) if precomputation is effectively amortized.
-   **Space Complexity**: O(N_max) for storing factorial and inverse factorial arrays.

## Summary
The solution correctly models the problem using combinations and modular exponentiation. It first determines the number of ways to choose the positions for matching adjacent elements. Then, for each such choice, it calculates the number of ways to assign values to the segments formed, ensuring that adjacent segments have different values. All calculations are performed modulo \(10^9 + 7\) to handle large results.

```java
class Solution {

    static long MOD = (long)(1e9) + 7;
    static long[] factorial;
    static long[] inverseFactorial;

    // Standard modular exponentiation function
    static long power(long base, long exponent) {
        long result = 1L;
        base %= MOD; // Ensure base is within modulo range
        while (exponent > 0) {
            if ((exponent & 1) == 1) { // If exponent is odd
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD; // Square the base
            exponent >>= 1; // Divide exponent by 2
        }
        return result;
    }

    // Computes nCr modulo MOD
    static long computeNCR(int total, int choose){
        // C(n, r) = n! / (r! * (n-r)!)
        if(choose < 0 || choose > total) return 0;

        long num = factorial[total];
        long denom1 = inverseFactorial[choose];
        long denom2 = inverseFactorial[total - choose];
        return ((num * denom1) % MOD * denom2) % MOD;
    }

    // Precomputes factorials and inverse factorials up to 'size'
    // This should ideally be called once for the maximum N in constraints.
    static void initializeFactorials(int size){
        factorial = new long[size + 1];
        inverseFactorial = new long[size + 1];

        factorial[0] = 1;
        for(int i = 1; i <= size; i++){
            factorial[i] = (factorial[i - 1] * i) % MOD;
        }

        // Modular inverse of factorial[size] using Fermat's Little Theorem
        inverseFactorial[size] = power(factorial[size], MOD - 2);
        for(int i = size - 1; i >= 0; i--){
            // inverseFactorial[i] = inverseFactorial[i+1] * (i+1) % MOD
            inverseFactorial[i] = (inverseFactorial[i + 1] * (i + 1)) % MOD;
        }
    }

    public int countGoodArrays(int n, int m, int k) {
        // Initialize factorials only if they haven't been initialized or are too small
        if (factorial == null || factorial.length <= n) {
            initializeFactorials(100000); // Max N from constraints
        }

        // Part 1: Choose k positions out of n-1 for matches
        long combinations = computeNCR(n - 1, k);

        // Part 2: Assign values to the n-k segments
        // Number of segments (blocks) is n - k.
        // First segment has 'm' choices.
        // Each of the remaining (n-k-1) segments must be different from the previous.
        // So, (m-1) choices for each.
        
        long valueAssignments;
        if (n - k == 0) { // Special case: n = k. Array like [X,X,...,X]. One segment.
                          // This case is actually impossible by constraint k <= n-1.
                          // So, n-k >= 1.
            valueAssignments = 0; // Should not reach here based on constraints.
        } else if (n - k == 1) { // Array like [X,X,...,X]. One segment.
                                 // This implies k = n-1.
            valueAssignments = m; // Only the first segment's value needs to be chosen.
        } else {
            // (n-k) segments. First has 'm' choices. Next (n-k-1) have 'm-1' choices.
            valueAssignments = (m * power(m - 1, (n - k) - 1)) % MOD;
        }
        
        // Final result is the product of combinations and value assignments
        long result = (combinations * valueAssignments) % MOD;
        
        return (int)result;
    }
}
```
