class Solution {
    public int bfs(int[] arr, int n) {
        boolean[] visited = new boolean[n * n];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = true;
        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int val = q.poll();
                if (val == n * n - 1)
                    return steps;

                for (int next = val + 1; next <= Math.min(val + 6, n * n - 1); next++) {
                    int move = arr[next] > -1 ? arr[next] : next;
                    if (visited[move] == false) {
                        visited[move] = true;
                        q.add(move);
                    }
                }
            }
            steps++;
        }

        return -1;
    }

    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] arr = new int[n * n];
        int index = 0;
        int i = n - 1, j = 0, dir = 1;

        while (i >= 0) {
            arr[index++] = board[i][j] == -1 ? -1 : board[i][j] - 1;
            if (dir == 1 && j == n - 1) {
                dir = -1;
                i--;
            } else if (dir == -1 && j == 0) {
                dir = 1;
                i--;
            } else {
                j += dir;
            }
        }

        return bfs(arr, n);
    }
}
