/*
 * author  : Ankan Misra
 * created : 2025-08-07
 * editor  : nvim
 */

import java.io.*;
import java.util.*;

public class Solution {

    private static final class FastReader {
        private final BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );
        private StringTokenizer st;

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        int nextInt() throws IOException { return Integer.parseInt(next()); }
        long nextLong() throws IOException { return Long.parseLong(next()); }
    }


    public static void main(String[] args) throws Exception {
        FastReader fr = new FastReader();
        StringBuilder sb = new StringBuilder();

        int t = fr.nextInt();
        while (t-- > 0) {
            int n = fr.nextInt();
            int k = fr.nextInt();

            long[] a = new long[n];
            long[] b = new long[n];
            for (int i = 0; i < n; i++) a[i] = fr.nextLong();
            for (int i = 0; i < n; i++) b[i] = fr.nextLong();

            long base = 0;
            long[][] seg = new long[n][2];

            for (int i = 0; i < n; i++) {
                long l = Math.min(a[i], b[i]);
                long r = Math.max(a[i], b[i]);
                seg[i][0] = l;
                seg[i][1] = r;
                base += r - l;
            }

            Arrays.sort(
                seg,
                (u, v) -> Long.compare(u[0], v[0])
            );

            long maxR = seg[0][1];
            boolean hasOverlap = false;
            long minGap = Long.MAX_VALUE;

            for (int i = 1; i < n; i++) {
                long l = seg[i][0];
                long r = seg[i][1];

                if (l <= maxR) {
                    hasOverlap = true;
                    maxR = Math.max(maxR, r);
                } else {
                    minGap = Math.min(minGap, l - maxR);
                    maxR = r;
                }
            }

            long answer = hasOverlap ? base : base + 2 * minGap;
            sb.append(answer).append('\n');
        }

        System.out.print(sb.toString());
    }
}
