/*
 * author  : Ankan Misra
 * created : 2025-07-28 at 16:14:23 PM IST
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
    static class Pair {
        String name;
        int score;
        Pair(String n, int s) {
            name = n;
            score = s;
        }
    }
    public static void main(String[] args) {
        solve();
        out.flush();
        out.close();
    }
    static void solve() {
        int n = sc.nextInt();
        List<Pair> events = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int score = sc.nextInt();
            events.add(new Pair(name, score));
        }
        Map<String, Integer> finals = new HashMap<>();
        for (Pair p : events) {
            finals.put(p.name, finals.getOrDefault(p.name, 0) + p.score);
        }
        int M = Integer.MIN_VALUE;
        for (int val : finals.values()) {
            M = Math.max(M, val);
        }
        List<String> candidates = new ArrayList<>();
        for (Map.Entry<String, Integer> e : finals.entrySet()) {
            if (e.getValue() == M) {
                candidates.add(e.getKey());
            }
        }
        if (candidates.size() == 1) {
            out.println(candidates.get(0));
            return;
        }
        Map<String, Integer> current = new HashMap<>();
        String winner = null;
        int earliest = Integer.MAX_VALUE;
        for (int round = 0; round < n; round++) {
            Pair p = events.get(round);
            current.put(p.name, current.getOrDefault(p.name, 0) + p.score);
            if (candidates.contains(p.name) && current.get(p.name) >= M && round < earliest) {
                earliest = round;
                winner = p.name;
            }
        }
        out.println(winner);
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
