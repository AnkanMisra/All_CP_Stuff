
# Solution Explanation

## Intuition
The key insight is that for the **GCD of all LCMs** of pairs, we need to find prime factors that appear in **almost all** LCM values. A prime factor `p^k` contributes to the final GCD only if it appears in at least `n-1` out of `n` elements, because then it will be present in all possible LCM pairs.

## Approach
The solution uses **prime factorization** and **frequency tracking** to determine which prime powers contribute to the final answer:

1. **Prime Factorization**: Use the **Sieve of Eratosthenes** to precompute the smallest prime factor for each number, enabling efficient factorization.

2. **Track Prime Frequencies**: For each prime `p`, count how many array elements contain it (`cnt[p]`) and track the **two smallest exponents** (`mn1[p]` and `mn2[p]`).

3. **Determine Contributing Primes**: A prime `p` contributes to the GCD if it appears in at least `n-1` elements:
   - If `cnt[p] == n` (appears in all elements): Use the **second smallest exponent** `mn2[p]`
   - If `cnt[p] == n-1` (missing from one element): Use the **smallest exponent** `mn1[p]`

4. **Build Final Answer**: Multiply the answer by `p^exp` for each contributing prime.

## Algorithm
1. Precompute smallest prime factors using sieve
2. For each array element, factorize and update prime statistics
3. For each prime with sufficient frequency, add its contribution to the result
4. Output the final GCD value

## Complexity
- **Time Complexity**: `O(MAX log log MAX + n log MAX)` where MAX = 200,000
  - Sieve preprocessing: `O(MAX log log MAX)`
  - Factorization for all elements: `O(n log MAX)`
- **Space Complexity**: `O(MAX)` for the sieve and frequency arrays

## Summary
The approach works by recognizing that the **GCD of LCMs** depends on prime factors present in nearly all elements. By tracking prime frequencies and their minimum exponents, we can efficiently compute which prime powers contribute to the final answer without explicitly calculating all pairwise LCMs.
```java
/*
 * author  : Ankan Misra
 * created : 2025-08-18 at 14:17:30 PM IST
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
        solve();
        out.flush();
        out.close();
    }

    static void solve() {
        int n = sc.nextInt();
        int MAX = 200_000;
        int[] spf = new int[MAX + 1];
        for (int i = 2; i <= MAX; i++) {
            if (spf[i] == 0) {
                for (int j = i; j <= MAX; j += i) {
                    if (spf[j] == 0) spf[j] = i;
                }
            }
        }

        int[] a = nextIntArray(n);

        int[] cnt = new int[MAX + 1];
        int[] mn1 = new int[MAX + 1];
        int[] mn2 = new int[MAX + 1];
        Arrays.fill(mn1, Integer.MAX_VALUE);
        Arrays.fill(mn2, Integer.MAX_VALUE);

        for (int val : a) {
            int x = val;
            Map<Integer, Integer> mp = new HashMap<>();
            while (x > 1) {
                int p = spf[x];
                int c = 0;
                while (x % p == 0) {
                    x /= p;
                    c++;
                }
                mp.put(p, mp.getOrDefault(p, 0) + c);
            }
            for (Map.Entry<Integer, Integer> e : mp.entrySet()) {
                int p = e.getKey();
                int exp = e.getValue();
                cnt[p]++;
                if (exp < mn1[p]) {
                    mn2[p] = mn1[p];
                    mn1[p] = exp;
                } else if (exp < mn2[p]) {
                    mn2[p] = exp;
                }
            }
        }

        long ans = 1L;
        for (int p = 2; p <= MAX; p++) {
            if (cnt[p] >= n - 1) {
                int exp = (cnt[p] == n) ? mn2[p] : mn1[p];
                long pow = 1;
                for (int i = 0; i < exp; i++) pow *= p;
                ans *= pow;
            }
        }
        out.println(ans);
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

```
