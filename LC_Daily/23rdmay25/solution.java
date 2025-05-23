class Solution {
    public long maximumValueSum(int[] A, int k, int[][] edges) {
        long res = 0;
        int d = 1 << 30, c = 0;
        for (int a : A) {
            int b = a ^ k;
            res += Math.max(a, b);
            c ^= a < b ? 1 : 0;
            d = Math.min(d, Math.abs(a - b));
        }
        return res - d * c;
    }
}
