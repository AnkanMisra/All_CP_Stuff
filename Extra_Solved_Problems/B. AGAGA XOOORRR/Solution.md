
# Solution Explanation

## Intuition
The key insight is that when we perform XOR operations on adjacent elements, we're essentially **partitioning the array into segments** where each segment's XOR becomes a single value. For all final elements to be equal, we need to find a way to partition the array such that each partition has the **same XOR value**.

## Approach
The solution uses a **greedy partitioning strategy** based on XOR properties:

1. **Calculate total XOR**: Compute the XOR of all elements in the array.
2. **Special case**: If total XOR is `0`, we can always make all elements equal by grouping appropriately.
3. **Segment counting**: Iterate through the array, maintaining a running XOR (`prefixXor`). Whenever `prefixXor` equals the total XOR, we've found a valid segment.
4. **Validation**: If we can form **at least 2 segments** with equal XOR values, the answer is "YES".

## Algorithm
1. Read the array and compute `totalXor` of all elements
2. If `totalXor == 0`, return "YES" immediately
3. Initialize `prefixXor = 0` and `segments = 0`
4. For each element in the array:
   - Update `prefixXor ^= element`
   - If `prefixXor == totalXor`, increment `segments` and reset `prefixXor = 0`
5. Return "YES" if `segments >= 2`, otherwise "NO"

## Complexity
- **Time Complexity**: `O(n)` - Single pass through the array
- **Space Complexity**: `O(1)` - Only using constant extra space

## Summary
This approach works because of the **XOR property**: if we can partition the array into segments where each segment has XOR equal to `totalXor`, then after performing all operations, we'll have multiple elements with the same value. The algorithm efficiently finds such partitions by tracking prefix XORs. **Corner cases** include arrays where total XOR is zero (always possible) and arrays that cannot be partitioned into at least two valid segments.
```java
/*
 * author  : Ankan Misra
 * created : 2025-08-14 at 17:01:34 PM IST
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
        int[] a = nextIntArray(n);

        int totalXor = 0;
        for (int value : a) totalXor ^= value;

        if (totalXor == 0) {
            out.println("YES");
            return;
        }

        int prefixXor = 0;
        int segments = 0;
        for (int value : a) {
            prefixXor ^= value;
            if (prefixXor == totalXor) {
                segments++;
                prefixXor = 0;
            }
        }

        if (segments >= 2) out.println("YES");
        else out.println("NO");
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
