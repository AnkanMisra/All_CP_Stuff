/*
 * author  : Ankan Misra
 * created : 2025-08-09 at 13:24:59 PM IST
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
    }

    static void solve() {
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            String line = sc.next();
            grid[i] = line.toCharArray();
        }

        int empty = 0;
        int startR = -1, startC = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '.') {
                    empty++;
                    startR = i;
                    startC = j;
                }
            }
        }

        int keep = empty - k;

        boolean[][] vis = new boolean[n][m];
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        Deque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[]{startR, startC});
        vis[startR][startC] = true;
        int visited = 1;

        while (!stack.isEmpty() && visited < keep) {
            int[] cur = stack.peek();
            int r = cur[0], c = cur[1];

            boolean pushed = false;
            for (int dir = 0; dir < 4 && visited < keep; dir++) {
                int nr = r + dr[dir];
                int nc = c + dc[dir];
                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                if (vis[nr][nc] || grid[nr][nc] != '.') continue;
                vis[nr][nc] = true;
                stack.push(new int[]{nr, nc});
                visited++;
                pushed = true;
                if (visited == keep) break;
            }
            if (!pushed) stack.pop();
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '.' && !vis[i][j]) grid[i][j] = 'X';
            }
        }


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.setLength(0);
            for (int j = 0; j < m; j++) sb.append(grid[i][j]);
            out.println(sb.toString());
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
