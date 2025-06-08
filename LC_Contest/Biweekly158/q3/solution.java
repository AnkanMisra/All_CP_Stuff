class Solution {
    public long maxGCDScore(int[] a, int b) {
        int c = a.length;
        long d = 0;
        int e[] = new int[c];
        for (int f = 0; f < c; f++) {
            int g = a[f], h = 0;
            while (g % 2 == 0) {
                h++;
                g /= 2;
            }
            e[f] = h;
        }
        for (int f = 0; f < c; f++) {
            long g = 0;
            int h = Integer.MAX_VALUE, i = 0;
            for (int j = f; j < c; j++) {
                g = gcd(g, a[j]);
                int k = e[j];
                if (k < h) {
                    h = k;
                    i = 1;
                } else if (k == h) {
                    i++;
                }
                long l = j - f + 1;
                long m;
                if (i <= b) {
                    m = 2L;
                } else {
                    m = 1L;
                }
                long n = l * g * m;
                if (n > d) {
                    d = n;
                }
            }
        }
        return d;
    }

    public long gcd(long a, long b) {
        while (b != 0) {
            long c = a % b;
            a = b;
            b = c;
        }
        return a;
    }
}
