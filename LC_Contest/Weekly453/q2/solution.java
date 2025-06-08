class Solution {
    public int countPermutations(int[] a) {
        int b = a.length;
        for (int c = 1; c < b; c++) {
            if (a[c] <= a[0]) {
                return 0;
            }
        }
        long d = 1, e = 1_000_000_007;
        for (int f = 1; f < b; f++) {
            d = d * f % e;
        }
        return (int) d;
    }
}
