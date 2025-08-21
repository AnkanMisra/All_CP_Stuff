class Solution {
    public int numSubmat(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] heights = new int[n];
        int result = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                heights[j] = (mat[i][j] == 0) ? 0 : heights[j] + 1;
            }
            Deque<int[]> stack = new ArrayDeque<>();
            int sum = 0;
            for (int j = 0; j < n; j++) {
                int cnt = 1;
                while (!stack.isEmpty() && stack.peek()[0] >= heights[j]) {
                    int[] top = stack.pop();
                    sum -= top[0] * top[1];
                    cnt += top[1];
                }
                stack.push(new int[]{heights[j], cnt});
                sum += heights[j] * cnt;
                result += sum;
            }
        }
        return result;
    }
}
