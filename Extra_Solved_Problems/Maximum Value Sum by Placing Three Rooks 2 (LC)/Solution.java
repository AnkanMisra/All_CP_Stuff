class Solution {
    public long maximumValueSum(int[][] a) {
        int h = a.length, w = a[0].length;
        long ans = Long.MIN_VALUE;
        for (int x = 0; x < h; ++x) {
            for (int y = x + 1; y < h; ++y) {
                for (int z = y + 1; z < h; ++z) {
                    for (int p = 0; p < w; ++p) {
                        for (int q = 0; q < w; ++q) {
                            if (q == p) {
                                continue;
                            } else {
                                for (int r = 0; r < w; ++r) {
                                    if (r == p || r == q) {
                                        continue;
                                    } else {
                                        long s = (long)a[x][p] + a[y][q] + a[z][r];
                                        if (s > ans) {
                                            ans = s;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }
}