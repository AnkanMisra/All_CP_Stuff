# Solution Explanation

### Intuition

For each index `i`, we need to compute:

r[i] = max_{0 ≤ j ≤ i} (2^{p[j]} + 2^{q[i-j]})

Since the values of `p` and `q` are permutations of `[0, n-1]`, and the exponents can be large, we precompute all powers of 2 modulo `998244353` for efficiency.

### Approach

- Precompute all powers of 2 up to `n-1` modulo `998244353`.
- For each test case:
  - For each index `i` from 0 to n-1:
    - For all `j` from 0 to `i`, compute `2^{p[j]} + 2^{q[i-j]}` and keep the maximum.
    - Output the result for each `i` in a single line.

### Code

import java.util.*;
     
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        while (a != 0) {
            a--;
            int b = sc.nextInt();
            int[] c = new int[b];
            int[] d = new int[b];
            for (int e = 0; e < b; e++) {
                c[e] = sc.nextInt();
            }
            for (int e = 0; e < b; e++) {
                d[e] = sc.nextInt();
            }
            final int f = 998244353;
            long[] g = new long[b];
            g[0] = 1;
            for (int e = 1; e < b; e++) {
                g[e] = (g[e - 1] * 2) % f;
            }
            for (int e = 0; e < b; e++) {
                long max = 0;
                for (int j = 0; j <= e; j++) {
                    long val = (g[c[j]] + g[d[e - j]]) % f;
                    if (val > max) max = val;
                }
                System.out.print(max);
                if (e < b - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}

### Complexity

- **Time Complexity:** O(n^2) per test case (due to the double loop for each index).
- **Space Complexity:** O(n), for the powers of 2 array.

### Summary

- The solution precomputes powers of 2 modulo `998244353` for efficiency.
- For each index, it computes the required maximum by checking all valid pairs.
- Outputs the result for each test case in the required format.
