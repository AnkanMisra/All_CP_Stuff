import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader a = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter b = new PrintWriter(System.out);
        int c = Integer.parseInt(a.readLine().trim());
        while (c-- > 0) {
            String[] d = a.readLine().split(" ");
            int e = Integer.parseInt(d[0]);
            long f = Long.parseLong(d[1]);
            String[] g = a.readLine().split(" ");
            long[] h = new long[e];
            long i = 0;
            for (int j = 0; j < e; j++) {
                h[j] = Long.parseLong(g[j]);
                i += Long.bitCount(h[j]);
            }
            PriorityQueue<long[]> k = new PriorityQueue<>(Comparator.comparingLong(l -> l[0]));
            for (int m = 0; m < e; m++) {
                if (h[m] % 2 == 0) {
                    k.offer(new long[] { 1, m });
                } else {
                    int n = Long.numberOfTrailingZeros(~h[m]);
                    long o = 1L << n;
                    k.offer(new long[] { o, m });
                }
            }
            while (!k.isEmpty() && f > 0) {
                long[] p = k.poll();
                long q = p[0];
                int r = (int) p[1];
                if (q > f) {
                    break;
                }
                f -= q;
                i += 1;
                if (h[r] % 2 == 0) {
                    h[r] += 1;
                } else {
                    h[r] += q;
                }
                int s = Long.numberOfTrailingZeros(~h[r]);
                long t = 1L << s;
                k.offer(new long[] { t, r });
            }
            b.println(i);
        }
        b.flush();
    }
}
