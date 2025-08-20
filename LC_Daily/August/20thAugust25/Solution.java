class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] prev = new int[n + 1];
        int total = 0;

        for (int i = 1; i <= m; i++) {
            int diagUpLeft = 0;
            for (int j = 1; j <= n; j++) {
                int temp = prev[j];
                if (matrix[i - 1][j - 1] == 1) {
                    prev[j] = 1 + Math.min(Math.min(prev[j], prev[j - 1]), diagUpLeft);
                    total += prev[j];
                } else {
                    prev[j] = 0;
                }
                diagUpLeft = temp;
            }
        }

        return total;
    }
}
