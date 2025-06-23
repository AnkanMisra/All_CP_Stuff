# Solution Explanation

## Intuition
The problem is to determine if Bob can choose a starting point such that, no matter where the prize is dropped (at point x or y), he will always reach it before Alice, who starts at point a. The key insight is that Bob can guarantee victory only if both possible prize locations are on the same side of Alice's starting point.

## Approach
- For each test case, read Alice's starting point `a` and the two possible prize locations `x` and `y`.
- If both `x` and `y` are less than `a`, Bob can choose any point greater than both `x` and `y` but less than `a` to guarantee he is always closer to the prize.
- If both `x` and `y` are greater than `a`, Bob can choose any point less than both `x` and `y` but greater than `a` to guarantee he is always closer to the prize.
- If `x` and `y` are on opposite sides of `a`, there is no point Bob can choose to guarantee victory for both cases.
- Output "YES" if Bob can guarantee victory, otherwise "NO".

## Complexity
- **Time Complexity:** O(1) per test case.
- **Space Complexity:** O(1).

## Summary
**By checking if both possible prize locations are on the same side of Alice's starting point, we can efficiently determine if Bob can guarantee victory.**  
If they are, Bob can always pick a point closer to both; otherwise, it's impossible.

```java
/*
 * author  : Ankan Misra
 * created : 2025-06-23 at 20:04:15 PM IST
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
        int a = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        if (x < a && y < a) {
            out.println("YES");
        } else if (x > a && y > a) {
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
        return a / gcd((int) a, (int) b) * b;
    }

    static void sort(int[] arr) {
        Arrays.sort(arr);
    }

    static int[] nextIntArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        return arr;
    }

    static long[] nextLongArray(int n) {
        long[] arr = new long[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextLong();
        return arr;
    }

    // ---FastReader---
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

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

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
