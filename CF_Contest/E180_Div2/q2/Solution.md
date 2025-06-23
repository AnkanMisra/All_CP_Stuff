# Solution Explanation

## Intuition
The problem is to make an array "beautiful" (i.e., there exists at least one pair of adjacent elements with a difference of at most 1) using the minimum number of allowed operations. Each operation merges two adjacent elements into a new value between their min and max, reducing the array size by 1. The key insight is to check if the array is already beautiful, and if not, try all possible merges to see if a beautiful array can be achieved in one operation.

## Approach
1. **Check if Already Beautiful:**  
   - Scan the array for any adjacent pair with |a[i] - a[i+1]| ≤ 1. If found, print 0 and return.
2. **Handle Size 2:**  
   - If the array has only two elements and is not beautiful, it's impossible to make it beautiful (output -1).
3. **Try All Possible Merges:**  
   - For every possible subarray, try merging it into a single value and check if the resulting array can be made beautiful by checking the new adjacent pairs.
   - For each possible merge, check if the element before or after the merged segment can form a beautiful pair with the new value.
   - Track the minimum number of operations needed.
4. **Output:**  
   - If a solution is found, print the minimum number of operations; otherwise, print -1.

## Complexity
- **Time Complexity:** O(n^2) per test case (since all subarrays are checked).
- **Space Complexity:** O(1) extra space (ignoring input storage).

## Summary
**By checking all possible merges and their effect on adjacent pairs, we can efficiently determine the minimum number of operations needed to make the array beautiful, or report impossibility.**  
This approach leverages the small constraints and the definition of a beautiful array.

```java
/*
 * author  : Ankan Misra
 * created : 2025-06-23 at 20:12:39 PM IST
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
        int[] b = nextIntArray(a);
        for (int c = 0; c < a - 1; c++) {
            if (Math.abs(b[c] - b[c + 1]) <= 1) {
                out.println(0);
                return;
            }
        }
        if (a == 2) {
            out.println(-1);
            return;
        }
        int d = Integer.MAX_VALUE;
        for (int e = 0; e < a; e++) {
            int f = b[e];
            int g = b[e];
            for (int h = e; h < a; h++) {
                f = Math.min(f, b[h]);
                g = Math.max(g, b[h]);
                if (e == 0 && h == a - 1) {
                    continue;
                }
                int i = h - e + 1;
                int j = i - 1;
                if (e > 0) {
                    int k = b[e - 1];
                    if (k >= f - 1 && k <= g + 1) {
                        d = Math.min(d, j);
                        if (d == 1) {
                            break;
                        }
                    }
                }
                if (h < a - 1) {
                    int l = b[h + 1];
                    if (l >= f - 1 && l <= g + 1) {
                        d = Math.min(d, j);
                        if (d == 1) {
                            break;
                        }
                    }
                }
            }
            if (d == 1) {
                break;
            }
        }
        if (d == Integer.MAX_VALUE) {
            d = -1;
        }
        out.println(d);
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
