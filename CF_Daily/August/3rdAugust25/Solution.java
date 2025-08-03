/*
 * author  : Ankan Misra
 * created : 2025-08-03 at 15:26:11 PM IST
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
    static final int MAXN = 100_000;
    static int[] spf = new int[MAXN + 1];
    static {/*
 * author  : Ankan Misra
 * created : 2025-08-03 at 15:26:11 PM IST
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
    static final int MAXN = 100_000;
    static int[] spf = new int[MAXN + 1];
    static {
        for (int i = 2; i <= MAXN; i++) {
            if (spf[i] == 0) {
                for (int j = i; j <= MAXN; j += i) {
                    if (spf[j] == 0) spf[j] = i;
                }
            }
        }
    }

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
        int[] p = new int[n + 1];
        boolean[] vis = new boolean[n + 1];


        p[1] = 1;
        vis[1] = true;


        for (int prime = n; prime >= 2; prime--) {
            if (spf[prime] != prime) continue;
            List<Integer> list = new ArrayList<>();
            for (int mult = prime; mult <= n; mult += prime) {
                if (!vis[mult]) {
                    list.add(mult);
                    vis[mult] = true;
                }
            }
            int sz = list.size();
            if (sz == 0) continue;
            if (sz == 1) {
                int idx = list.get(0);
                p[idx] = idx;
            } else {
                for (int i = 0; i < sz; i++) {
                    p[list.get((i + 1) % sz)] = list.get(i);
                }
            }
        }


        for (int i = 1; i <= n; i++) {
            out.print(p[i]);
            if (i < n) out.print(" ");
        }
        out.println();
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

        for (int i = 2; i <= MAXN; i++) {
            if (spf[i] == 0) {
                for (int j = i; j <= MAXN; j += i) {
                    if (spf[j] == 0) spf[j] = i;
                }
            }
        }
    }

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
        int[] p = new int[n + 1];
        boolean[] vis = new boolean[n + 1];


        p[1] = 1;
        vis[1] = true;


        for (int prime = n; prime >= 2; prime--) {
            if (spf[prime] != prime) continue;
            List<Integer> list = new ArrayList<>();
            for (int mult = prime; mult <= n; mult += prime) {
                if (!vis[mult]) {
                    list.add(mult);
                    vis[mult] = true;
                }
            }
            int sz = list.size();
            if (sz == 0) continue;
            if (sz == 1) {
                int idx = list.get(0);
                p[idx] = idx;
            } else {
                for (int i = 0; i < sz; i++) {
                    p[list.get((i + 1) % sz)] = list.get(i);
                }
            }
        }


        for (int i = 1; i <= n; i++) {
            out.print(p[i]);
            if (i < n) out.print(" ");
        }
        out.println();
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
