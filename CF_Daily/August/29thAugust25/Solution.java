/*
 * author  : Ankan Misra
 * created : 2025-08-29 at 19:22:41 PM IST
 * editor  : nvim
 * blame the bugs on me, not the editor
 */

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = fr.nextInt();
        while (t-- > 0) {
            long l = fr.nextLong();
            long r = fr.nextLong();
            out.println(calc(r) - calc(l));
        }
        out.flush();
    }
    private static long calc(long n) {
        long res = n;
        for (long div = 10; div <= n; div *= 10) {
            res += n / div;
        }
        return res;
    }

    // Fast input reader
    private static class FastReader {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }
        int nextInt() throws IOException { return Integer.parseInt(next()); }
        long nextLong() throws IOException { return Long.parseLong(next()); }
    }
}
