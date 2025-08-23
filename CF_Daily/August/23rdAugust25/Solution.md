
# Solution Explanation

## Intuition
Since we have **almost all divisors** (all except 1 and x), the **minimum possible x** would be the **product of the smallest and largest divisors** in the given list. This is because if `d1` and `d2` are divisors of `x`, then `x` must be divisible by their LCM, and the minimum case occurs when `x = d_min × d_max`.

## Approach
1. **Sort the given divisors** to easily find minimum and maximum
2. **Calculate candidate x** as `x = min_divisor × max_divisor`
3. **Generate all divisors** of this candidate `x`
4. **Remove 1 and x** from the generated divisor list
5. **Compare** the remaining divisors with the given list
6. If they **match exactly**, return `x`; otherwise return **-1**

## Algorithm
1. Read the list of divisors and **sort them**
2. Let `min_div = smallest divisor` and `max_div = largest divisor`
3. Calculate `candidate_x = min_div × max_div`
4. **Generate all divisors** of `candidate_x`:
   - For `i` from `1` to `sqrt(candidate_x)`:
     - If `candidate_x % i == 0`, add `i` and `candidate_x/i` to divisor set
5. **Remove 1 and candidate_x** from the divisor set
6. **Convert to sorted list** and compare with given divisors
7. If **identical**, return `candidate_x`; else return **-1**

## Complexity
- **Time Complexity:** `O(sqrt(x) + n log n)` where `x` is the candidate number
- **Space Complexity:** `O(d)` where `d` is the number of divisors of `x`

## Summary
The approach works because **if x has divisors d1, d2, ..., dn (excluding 1 and x)**, then the minimum possible `x` is constrained by its smallest and largest proper divisors. We verify our candidate by **generating all its divisors** and checking if they match the given list exactly. Key corner cases include **prime numbers** (only divisor is the number itself) and **invalid divisor combinations**.
```java
/*
 * author  : Ankan Misra
 * created : 2025-08-23 at 17:09:08 PM IST
 * editor  : nvim
 * blame the bugs on me, not the editor
 */

import java.io.*;
import java.util.*;

public class Solution {
    static FastReader sc = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);
    static final int MOD = 1_000_000_007;
    static final long INF = Long.MAX_VALUE / 2;

    public static void main(String[] args) {
        int testcases = sc.nextInt();
        while (testcases-- > 0) {
            solve();
        }
        out.flush();
        out.close();
    }

    static void solve() {
        int n = sc.nextInt();
        long[] divisors = new long[n];

        for (int i = 0; i < n; i++) {
            divisors[i] = sc.nextLong();
        }

        Arrays.sort(divisors);

        long candidateX = divisors[0] * divisors[n-1];

        Set<Long> allDivisors = new HashSet<>();
        for (long i = 1; i * i <= candidateX; i++) {
            if (candidateX % i == 0) {
                allDivisors.add(i);
                if (i != candidateX / i) {
                    allDivisors.add(candidateX / i);
                }
            }
        }
        allDivisors.remove(1L);
        allDivisors.remove(candidateX);
        long[] generatedDivisors = allDivisors.stream().mapToLong(Long::longValue).toArray();
        Arrays.sort(generatedDivisors);

        if (generatedDivisors.length == n && Arrays.equals(divisors, generatedDivisors)) {
            out.println(candidateX);
        } else {
            out.println(-1);
        }
    }

    // ---Utility ---
    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static long lcm(long a, long b) {
        return a / gcd((int)a, (int)b) * b;
    }

    static void sort(int[] arr) {
        Arrays.sort(arr);
    }

    static int[] nextIntArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        return arr;
    }

    static long[] nextLongArray(int n) {
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextLong();
        return arr;
    }

    //---FastReader---
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() { return Double.parseDouble(next()); }
        String nextLine() {
            try {
                return br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
`V``
