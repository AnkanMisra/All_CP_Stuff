class Solution {
    int countPairs(int[][] mat1, int[][] mat2, int x) {
        int n = mat1.length, cnt = 0;
        int a = 0, b = n - 1, i1 = 0, i2 = n - 1;
        while (i2 >= 0 && i1 < n) {
            int sum = mat1[i1][a] + mat2[i2][b];
            if (sum == x) {
                cnt++;
                a++;
                b--;
            } else if (sum < x) {
                a++;
            } else
                b--;
            if (a == n) {
                a = 0;
                i1++;
            }
            if (b == -1) {
                i2--;
                b = n - 1;
            }

        }
        return cnt;
    }
}
