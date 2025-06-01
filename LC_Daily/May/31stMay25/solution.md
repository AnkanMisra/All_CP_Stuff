# Solution Explanation

### Intuition

The problem is a shortest path search on a "flattened" snakes and ladders board. Each move simulates a dice roll (1-6), and if you land on a snake or ladder, you must move to its destination. The board is traversed in a Boustrophedon (zigzag) order, so we need to flatten it accordingly.

### Approach

- **Flatten the board:**  
  Convert the 2D board into a 1D array, taking care of the zigzag order.
- **Breadth-First Search (BFS):**  
  Use BFS to find the minimum number of moves from square 1 to square n².
  - Start from index 0 (square 1).
  - For each position, try all dice rolls (1 to 6).
  - If the destination has a snake or ladder, move to its destination.
  - Mark visited positions to avoid cycles.
  - Return the number of steps when you reach the last square.
- If the last square is unreachable, return -1.

### Code

```java
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
                if (val == n * n - 1) return steps;
                for (int next = val + 1; next <= Math.min(val + 6, n * n - 1); next++) {
                    int move = arr[next] > -1 ? arr[next] : next;
                    if (!visited[move]) {
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
```

### Complexity

- **Time Complexity:** O(n²), where n is the size of the board (since each square is visited at most once).
- **Space Complexity:** O(n²), for the visited array and queue.

### Summary

- The solution flattens the board in zigzag order and uses BFS to find the shortest path to the last square.
- It handles snakes and ladders by moving to their destinations when encountered.
- Returns the minimum number of moves, or -1 if unreachable.
