# Solution Explanation

## Intuition
The problem asks us to construct a bitstring of length `n` with exactly `k` ones such that the number of "101" subsequences is equal to the number of "010" subsequences.
Let's denote the count of '101' subsequences as `count_101` and '010' subsequences as `count_010`.

We observe that if we construct a string of the form `1` followed by some zeros, then some ones, and finally a `0`, both counts might be equal. Specifically, consider a pattern:
`1` + (`n - k - 1` zeros) + (`k - 1` ones) + `0`

Let `N_0` be the total number of zeros (`n - k`) and `N_1` be the total number of ones (`k`).
In the proposed pattern:
- The first character is '1'.
- Then, there are `N_0 - 1` zeros (if `N_0 > 0`).
- Then, there are `N_1 - 1` ones (if `N_1 > 0`).
- The last character is '0' (if `N_0 > 0`).

**Counting "101" subsequences in `1(0...0)(1...1)0`:**
A "101" subsequence can only be formed by:
1.  Picking the first '1' in the string.
2.  Picking a '0' from the middle block of zeros.
3.  Picking a '1' from the block of ones before the final '0'.
The number of such subsequences is `1 * (N_0 - 1) * (N_1 - 1)`.

**Counting "010" subsequences in `1(0...0)(1...1)0`:**
A "010" subsequence can only be formed by:
1.  Picking a '0' from the middle block of zeros.
2.  Picking a '1' from the block of ones before the final '0'.
3.  Picking the last '0' in the string.
The number of such subsequences is `(N_0 - 1) * (N_1 - 1) * 1`.

Thus, `count_101` will be equal to `count_010` for this construction. This works for `0 < k < n`.

## Approach
The solution considers three cases based on the value of `k`:

1.  **Case 1: `k = 0` (All zeros)**
    If `k` is 0, the string consists only of '0's. In this case, there are no '1's, so no "101" or "010" subsequences can be formed. Both counts are 0, satisfying the condition. Output `n` zeros.

2.  **Case 2: `k = n` (All ones)**
    If `k` is equal to `n`, the string consists only of '1's. Similarly, there are no '0's, so no "101" or "010" subsequences can be formed. Both counts are 0, satisfying the condition. Output `n` ones.

3.  **Case 3: `0 < k < n` (Mixed zeros and ones)**
    This is the general case where the proposed pattern `1` + `(n-k-1)` zeros + `(k-1)` ones + `0` is used.
    - Print the first '1'.
    - Print `(n - k - 1)` zeros.
    - Print `(k - 1)` ones.
    - Print the last '0'.

This construction always yields `k` ones and `n-k` zeros, and ensures `count_101 = count_010 = (n-k-1)(k-1)`.

## Complexity
-   **Time Complexity**: O(n) per test case, as we iterate through the string's length at most a constant number of times to print characters.
-   **Space Complexity**: O(1) per test case, as we only use a few integer variables.

## Summary
The solution provides a simple and effective constructive approach. By handling the edge cases of all zeros or all ones separately, and applying a specific `10...01...10` pattern for mixed strings, it guarantees an equal number of "101" and "010" subsequences while fulfilling the length and '1' count requirements.

```java
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Read the number of test cases
        while (t-- > 0) { // Loop through each test case
            int n = sc.nextInt(); // Read length of bitstring
            int k = sc.nextInt(); // Read number of '1' characters

            if (k == 0) {
                // If k is 0, the string must be all zeros.
                // Number of '101' and '010' subsequences will both be 0.
                for (int i = 0; i < n; i++)
                    System.out.print('0');
            } else if (k == n) {
                // If k is n, the string must be all ones.
                // Number of '101' and '010' subsequences will both be 0.
                for (int i = 0; i < n; i++)
                    System.out.print('1');
            } else {
                // General case: 0 < k < n
                // Construct the pattern: '1' + (n-k-1 zeros) + (k-1 ones) + '0'
                // This ensures that:
                // - Total length is 1 + (n-k-1) + (k-1) + 1 = n.
                // - Total '1's is 1 + (k-1) = k.
                // - Total '0's is (n-k-1) + 1 = n-k.
                // The number of '101' subsequences will be (n-k-1)*(k-1).
                // The number of '010' subsequences will also be (n-k-1)*(k-1).

                System.out.print('1'); // The first '1'

                int numZerosInMiddle = n - k - 1; // Number of '0's after the first '1'
                for (int i = 0; i < numZerosInMiddle; i++)
                    System.out.print('0');

                int numOnesInSuffix = k - 1; // Remaining '1's
                for (int i = 0; i < numOnesInSuffix; i++)
                    System.out.print('1');

                System.out.print('0'); // The final '0'
            }
            System.out.println(); // New line after each bitstring
        }
        sc.close(); // Close the scanner
    }
}
```
