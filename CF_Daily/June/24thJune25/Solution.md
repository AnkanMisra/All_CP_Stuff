# Solution Explanation

## Intuition
The problem is to find the minimum cost for Ann to make `n` subway rides, given the option to buy single-ride tickets or multi-ride tickets. The key insight is to consider all possible combinations: buying only single-ride tickets, buying as many multi-ride tickets as possible and the rest as single-ride tickets, or buying enough multi-ride tickets to cover all rides (even if it means buying more rides than needed).

## Approach
1. **Calculate the Cost for All Single-Ride Tickets:**  
   - Cost = n × a
2. **Calculate the Cost for Maximum Multi-Ride Tickets + Remaining Single-Ride Tickets:**  
   - Buy as many m-ride tickets as possible, and use single-ride tickets for the remaining rides.
   - Cost = (n / m) × b + (n % m) × a
3. **Calculate the Cost for Only Multi-Ride Tickets (Covering All Rides):**  
   - Buy enough m-ride tickets to cover all rides, even if it means buying more rides than needed.
   - Cost = ceil(n / m) × b
4. **Take the Minimum of All Three Options:**  
   - The answer is the minimum of the three calculated costs.

## Complexity
- **Time Complexity:** O(1) (just a few arithmetic operations).
- **Space Complexity:** O(1).

## Summary
**By considering all possible combinations of single-ride and multi-ride tickets, we can efficiently compute the minimum cost for Ann's subway rides.**  
This approach ensures that Ann always pays the least possible amount.

```java
/*
 * author  : Ankan Misra
 * created : 2025-06-24 at 19:28:41 PM IST
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
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        int e = a * c;
        int f = (a / b) * d + (a % b) * c;
        int g = ((a + b - 1) / b) * d;

        int h = Math.min(e, Math.min(f, g));
        out.println(h);
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
