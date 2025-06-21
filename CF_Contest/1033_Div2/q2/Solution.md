# Solution Explanation

## Intuition
The problem is to determine how many balls, when shot at a 45-degree angle on a square pool table, will eventually fall into a pocket. Each ball starts at a given position and moves in a direction given by (dx, dy), where each of dx and dy is either 1 or -1. The pockets are at the four corners of the table. The key insight is that, due to the elastic and infinite-speed nature of the balls, a ball will be potted if and only if, after a certain number of bounces, it reaches a corner.

## Approach
- For each ball, calculate how many units it would travel in the x and y directions before reaching a wall.
- The ball will reach a pocket if, after a certain number of bounces, it lands at a corner (0,0), (0,s), (s,0), or (s,s).
- The number of units to the wall in the x direction is either `xi` (if dx = -1) or `s - xi` (if dx = 1).
- Similarly, for the y direction, it is either `yi` (if dy = -1) or `s - yi` (if dy = 1).
- The ball will be potted if and only if the number of units to the wall in the x and y directions is the same (i.e., the ball hits a corner directly).

## Algorithm
1. For each test case:
   1. Read the number of balls and the side length of the table.
   2. For each ball, read its direction and starting position.
   3. Compute the distance to the wall in both x and y directions.
   4. If these distances are equal, increment the count of potted balls.
2. Output the count for each test case.

## Complexity
- **Time Complexity:** O(n) per test case, where n is the number of balls.
- **Space Complexity:** O(1) extra space per test case.

## Summary
**By checking if the distance to the wall in the x and y directions is the same for each ball, we can efficiently determine how many balls will be potted.**  
This approach leverages the symmetry and properties of the problem for a direct and optimal solution.

```java
// created by AnkanMisra at 2025-06-21 and 20:19:26 IST 
// written in nvim, but blame the bugs on me

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
        long b = sc.nextLong();
        int c = 0;
        for (int d = 0; d < a; d++) {
            int e = sc.nextInt();
            int f = sc.nextInt();
            long g = sc.nextLong();
            long h = sc.nextLong();
            long i;
            if (e == 1) {
                i = b - g;
            } else {
                i = g;
            }
            
            long j;
            if (f == 1) {
                j = b - h;
            } else {
                j = h;
            }
            
            if (i == j) c++;
        }
        out.println(c);
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