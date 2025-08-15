

# Solution Explanation

## Intuition
The operation always lowers the sum of the array by **2**, so the total sum must be **even**.
Also, the largest element can only be decreased by pairing each of its units with a unit from the rest of the array; therefore it can never contribute more than the other elements combined.
Consequently, the largest element must be **no greater than half of the total sum**.

## Approach
1. Read **n** and the array values.
2. Calculate `sum` (total of all elements) and `max` (largest element).
3. Check the two conditions:
   - `sum % 2 == 0`
   - `max <= sum / 2`
4. Output **YES** if both hold, otherwise **NO**.

## Complexity
- **Time Complexity:** `O(n)` – one scan to get `sum` and `max`.
- **Space Complexity:** `O(1)` – only constant extra variables.

## Summary
The two arithmetic conditions are **necessary and sufficient** for zeroing the array.
Verifying them gives a linear-time, constant-space solution.
```java
/*
 * author  : Ankan Misra
 * created : 2025-08-15 at 17:28:46 PM IST
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
        long sum = 0;
        long max = 0;
        for (int i = 0; i < n; i++) {
            long val = sc.nextLong();
            sum += val;
            if (val > max) max = val;
        }
        if ((sum & 1) == 0 && max <= sum / 2) {
            out.println("YES");
        } else {
            out.println("NO");
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

```

