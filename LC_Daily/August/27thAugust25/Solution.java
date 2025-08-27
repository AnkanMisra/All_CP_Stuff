class Solution {
    private int maxLength = 0;
    private int[][] directions = {{1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    public int lenOfVDiagonal(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        maxLength = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    for (int dir = 0; dir < 4; dir++) {
                        dfs(grid, i, j, dir, 1, 1, false);
                    }
                }
            }
        }

        return maxLength;
    }

    private void dfs(int[][] grid, int row, int col, int direction, int length, int expectedValue, boolean hasTurned) {
        int n = grid.length;
        int m = grid[0].length;

        maxLength = Math.max(maxLength, length);

        int nextRow = row + directions[direction][0];
        int nextCol = col + directions[direction][1];

        if (isValid(nextRow, nextCol, n, m)) {
            int nextExpected = getNextExpectedValue(expectedValue);
            if (grid[nextRow][nextCol] == nextExpected) {
                dfs(grid, nextRow, nextCol, direction, length + 1, nextExpected, hasTurned);
            }
        }

        if (!hasTurned) {
            for (int newDir = 0; newDir < 4; newDir++) {
                if (isClockwiseTurn(direction, newDir)) {
                    int turnRow = row + directions[newDir][0];
                    int turnCol = col + directions[newDir][1];

                    if (isValid(turnRow, turnCol, n, m)) {
                        int nextExpected = getNextExpectedValue(expectedValue);
                        if (grid[turnRow][turnCol] == nextExpected) {
                            dfs(grid, turnRow, turnCol, newDir, length + 1, nextExpected, true);
                        }
                    }
                }
            }
        }
    }

    private boolean isValid(int row, int col, int n, int m) {
        return row >= 0 && row < n && col >= 0 && col < m;
    }

    private int getNextExpectedValue(int currentValue) {
        if (currentValue == 1) return 2;
        if (currentValue == 2) return 0;
        return 2;
    }

    private boolean isClockwiseTurn(int currentDir, int newDir) {
        return (currentDir == 0 && newDir == 1) ||
               (currentDir == 1 && newDir == 3) ||
               (currentDir == 2 && newDir == 0) ||
               (currentDir == 3 && newDir == 2);
    }
}
