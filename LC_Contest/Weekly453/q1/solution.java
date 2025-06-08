class Solution {
    public boolean canMakeEqual(int[] a, int b) {
        int c = a.length;
        int d[] = new int[c];
        for (int i = 0; i < c; i++) {
            if (a[i] == -1) {
                d[i] = 1;
            } else {
                d[i] = 0;
            }
        }
        for (int t = 0; t < 2; t++) {
            int e[] = d.clone();
            int f = 0;
            for (int i = 0; i < c - 1; i++) {
                if (e[i] != t) {
                    e[i] ^= 1;
                    e[i + 1] ^= 1;
                    f++;
                }
            }
            if (e[c - 1] == t && f <= b) {
                return true;
            }
        }
        return false;
    }
}
