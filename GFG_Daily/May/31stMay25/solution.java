class Solution {
    public int kthSmallest(int[][] mat, int k) {
        int n = mat.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]); // {mat[i][j], i, j}
        for (int i = 0; i < n; i++)
            pq.offer(new int[] { mat[i][0], i, 0 });

        while (--k > 0) {
            int[] curr = pq.poll();
            if (curr[2] + 1 < n)
                pq.offer(new int[] { mat[curr[1]][curr[2] + 1], curr[1], curr[2] + 1 });
        }
        return pq.peek()[0];
    }
}
