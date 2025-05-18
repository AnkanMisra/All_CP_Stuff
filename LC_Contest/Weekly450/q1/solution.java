class Solution {
    public int smallestIndex(int[] a) {
        for (int b = 0; b < a.length; b++) {
            if (sum(a[b]) == b) {
                return b;
            }
        }
        return -1;
    }

    public static int sum(int c) {
        int d = 0;
        while (c > 0) {
            d += c % 10;
            c /= 10;
        }
        return d;
    }
}
