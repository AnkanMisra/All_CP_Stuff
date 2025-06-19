# Solution Explanation

## Intuition
We are given a partially filled array with some known and some unknown values, and we need to fill the unknowns so that the maximum subarray sum is exactly **k**. The main insight is that the only way to control the maximum subarray sum is by carefully choosing the values for the unknown positions, since the known values are fixed.

If the current maximum subarray sum (using only the known values) is already greater than **k**, it is impossible to achieve exactly **k**. If it is exactly **k**, we can set all unknowns to a very large negative value to ensure they do not contribute to any subarray sum. Otherwise, we need to use at least one unknown position to "boost" the sum to exactly **k**.

## Approach
1. **Compute the Maximum Subarray Sum of Known Values:**  
   Use Kadane's algorithm, skipping unknowns, to find the best sum possible with only the known values.
2. **Check for Immediate Impossibility:**  
   - If the best sum is greater than **k**, print "No".
   - If the best sum is exactly **k**, set all unknowns to a very large negative value (so they don't affect the sum) and print the result.
3. **If the Best Sum is Less Than k:**  
   - If there are no unknowns, print "No".
   - Otherwise, find an unknown position to "boost" the sum to exactly **k**.
   - For each unknown, calculate the maximum sum of known values to its left and right (using prefix and suffix arrays).
   - Set all unknowns to a very large negative value except one, which is set so that the sum of the best left segment, the chosen value, and the best right segment is exactly **k**.
4. **Output the Result:**  
   Print "Yes" and the constructed array.

## Complexity
- **Time Complexity:** O(n) per test case (Kadane's algorithm and prefix/suffix computations).
- **Space Complexity:** O(n) per test case for arrays.

## Summary
**The solution uses Kadane's algorithm to check the current maximum subarray sum and then fills unknowns to precisely control the sum, using large negative values to "turn off" unused unknowns.**  
If it is possible to achieve exactly **k**, the solution constructs such an array; otherwise, it reports "No".

```java
// created by AnkanMisra at 2025-06-19 and 15:33:26 IST
// written in nvim, blame the bugs on me
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
        long k = sc.nextLong();
        String s = sc.next();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextLong();

        final long BIG_NEG = -1_000_000_000_000_000_000L;

        long best = Long.MIN_VALUE;
        long cur = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                cur = (cur > 0 ? cur : 0) + arr[i];
                if (cur > best) best = cur;
            } else {
                cur = 0;
            }
        }
        if (best == Long.MIN_VALUE) best = 0;

        if (best > k) {
            out.println("No");
            return;
        }

        int unknownCnt = 0;
        for (int i = 0; i < n; i++) if (s.charAt(i) == '0') unknownCnt++;

        long[] res = new long[n];
        for (int i = 0; i < n; i++) res[i] = arr[i];

        if (best == k) {
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '0') res[i] = BIG_NEG;
            }
            out.println("Yes");
            printArray(res);
            return;
        }
        
        if (unknownCnt == 0) {
            out.println("No");
            return;
        }

        long[] suffix = new long[n];
        cur = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                cur = Math.max(arr[i], cur + arr[i]);
                suffix[i] = cur;
            } else {
                cur = 0;
                suffix[i] = 0;
            }
        }

        long[] prefix = new long[n];
        cur = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                cur = Math.max(arr[i], cur + arr[i]);
                prefix[i] = cur;
            } else {
                cur = 0;
                prefix[i] = 0;
            }
        }

        int idx = -1;
        long leftContrib = 0, rightContrib = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                long l = (i > 0) ? Math.max(0, suffix[i - 1]) : 0;
                long r = (i + 1 < n) ? Math.max(0, prefix[i + 1]) : 0;
                idx = i;
                leftContrib = l;
                rightContrib = r;
                break;
            }
        }

        long val = k - leftContrib - rightContrib;

        for (int i = 0; i < n; i++) if (s.charAt(i) == '0') res[i] = BIG_NEG;
        res[idx] = val;

        out.println("Yes");
        printArray(res);
    }

    static void printArray(long[] arr) {
        for (int i = 0; i < arr.length; i++) {
            out.print(arr[i]);
            if (i + 1 < arr.length) out.print(' ');
        }
        out.println();
    }

    // --- Utility functions ---
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
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    static long[] nextLongArray(int n) {
        long[] arr = new long[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextLong();
        return arr;
    }

    // ---FastReader implementation for faster input---
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
