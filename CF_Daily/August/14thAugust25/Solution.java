/*
 * author  : Ankan Misra
 * created : 2025-08-14 at 18:59:52 PM IST
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
        String s = sc.next();
        if (isRxCy(s)) {
            int cIndex = s.indexOf('C');
            int row = Integer.parseInt(s.substring(1, cIndex));
            int col = Integer.parseInt(s.substring(cIndex + 1));
            String colStr = colToLetters(col);
            out.println(colStr + row);
        } else {
            int i = 0;
            while (i < s.length() && Character.isLetter(s.charAt(i))) i++;
            String letters = s.substring(0, i);
            int row = Integer.parseInt(s.substring(i));
            int col = lettersToCol(letters);
            out.println("R" + row + "C" + col);
        }
    }

    static boolean isRxCy(String str) {
        if (str.length() < 4 || str.charAt(0) != 'R') return false;
        int cIdx = str.indexOf('C');
        if (cIdx == -1) return false;
        for (int i = 1; i < cIdx; i++) if (!Character.isDigit(str.charAt(i))) return false;
        if (cIdx == 1) return false;
        if (cIdx == str.length() - 1) return false;
        for (int i = cIdx + 1; i < str.length(); i++) if (!Character.isDigit(str.charAt(i))) return false;
        return true;
    }

    static String colToLetters(int col) {
        StringBuilder sb = new StringBuilder();
        while (col > 0) {
            col--;
            sb.append((char) ('A' + (col % 26)));
            col /= 26;
        }
        return sb.reverse().toString();
    }

    static int lettersToCol(String letters) {
        int col = 0;
        for (int i = 0; i < letters.length(); i++) {
            col = col * 26 + (letters.charAt(i) - 'A' + 1);
        }
        return col;
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
