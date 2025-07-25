/*
 * author  : Ankan Misra
 * created : 2025-07-25 at 22:21:45 PM IST
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
        int k = sc.nextInt();
        int[] a = nextIntArray(n);


        if (canFormPalindrome(a, k)) {
            out.println("YES");
        } else {
            out.println("NO");
        }
    }

    static boolean canFormPalindrome(int[] a, int k) {
        int n = a.length;

        if (k == 1) return true;

        int[] bb = a.clone();
        Arrays.sort(bb);
        int cutoff = bb[k - 2];

        List<Integer> cc = new ArrayList<>();
        for (int val : a) {
            if (val <= cutoff) {
                cc.add(val);
            }
        }

        int spare = cc.size() - k + 1;
        int L = 0, R = cc.size() - 1;
        boolean bad = false;

        while (L < R) {
            if (!cc.get(L).equals(cc.get(R))) {
                if (spare == 0) {
                    bad = true;
                    break;
                }
                if (cc.get(L) == cutoff) {
                    L++;
                    spare--;
                } else if (cc.get(R) == cutoff) {
                    R--;
                    spare--;
                } else {
                    bad = true;
                    break;
                }
                continue;
            }
            L++;
            R--;
        }

        return !bad;
    }

    static boolean isPalindromeList(List<Integer> arr) {
        int n = arr.size();
        for (int i = 0; i < n / 2; i++) {
            if (!arr.get(i).equals(arr.get(n - 1 - i))) {
                return false;
            }
        }
        return true;
    }

    static boolean isPalindrome(int[] arr) {
         int n = arr.length;
         for (int i = 0; i < n / 2; i++) {
             if (arr[i] != arr[n - 1 - i]) {
                 return false;
             }
         }
         return true;
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
