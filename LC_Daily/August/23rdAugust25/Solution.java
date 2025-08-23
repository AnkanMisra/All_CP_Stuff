class Solution {
    public int minimumSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int minArea = Integer.MAX_VALUE;

        for (int i = 1; i < m - 1; i++) {
            for (int j = i + 1; j < m; j++) {
                int area1 = getRectArea(grid, 0, i - 1, 0, n - 1);
                int area2 = getRectArea(grid, i, j - 1, 0, n - 1);
                int area3 = getRectArea(grid, j, m - 1, 0, n - 1);
                if (area1 > 0 && area2 > 0 && area3 > 0) {
                    minArea = Math.min(minArea, area1 + area2 + area3);
                }
            }
        }

        for (int i = 1; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int area1 = getRectArea(grid, 0, m - 1, 0, i - 1);
                int area2 = getRectArea(grid, 0, m - 1, i, j - 1);
                int area3 = getRectArea(grid, 0, m - 1, j, n - 1);
                if (area1 > 0 && area2 > 0 && area3 > 0) {
                    minArea = Math.min(minArea, area1 + area2 + area3);
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int area1 = getRectArea(grid, 0, i - 1, 0, n - 1);
                int area2 = getRectArea(grid, i, m - 1, 0, j - 1);
                int area3 = getRectArea(grid, i, m - 1, j, n - 1);
                if (area1 > 0 && area2 > 0 && area3 > 0) {
                    minArea = Math.min(minArea, area1 + area2 + area3);
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int area1 = getRectArea(grid, 0, i - 1, 0, j - 1);
                int area2 = getRectArea(grid, 0, i - 1, j, n - 1);
                int area3 = getRectArea(grid, i, m - 1, 0, n - 1);
                if (area1 > 0 && area2 > 0 && area3 > 0) {
                    minArea = Math.min(minArea, area1 + area2 + area3);
                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                int area1 = getRectArea(grid, 0, m - 1, 0, i - 1);
                int area2 = getRectArea(grid, 0, j - 1, i, n - 1);
                int area3 = getRectArea(grid, j, m - 1, i, n - 1);
                if (area1 > 0 && area2 > 0 && area3 > 0) {
                    minArea = Math.min(minArea, area1 + area2 + area3);
                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                int area1 = getRectArea(grid, 0, j - 1, 0, i - 1);
                int area2 = getRectArea(grid, j, m - 1, 0, i - 1);
                int area3 = getRectArea(grid, 0, m - 1, i, n - 1);
                if (area1 > 0 && area2 > 0 && area3 > 0) {
                    minArea = Math.min(minArea, area1 + area2 + area3);
                }
            }
        }

        return minArea;
    }

    private int getRectArea(int[][] grid, int r1, int r2, int c1, int c2) {
        int minRow = Integer.MAX_VALUE, maxRow = Integer.MIN_VALUE;
        int minCol = Integer.MAX_VALUE, maxCol = Integer.MIN_VALUE;
        boolean hasOne = false;

        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                if (grid[i][j] == 1) {
                    hasOne = true;
                    minRow = Math.min(minRow, i);
                    maxRow = Math.max(maxRow, i);
                    minCol = Math.min(minCol, j);
                    maxCol = Math.max(maxCol, j);
                }
            }
        }

        return hasOne ? (maxRow - minRow + 1) * (maxCol - minCol + 1) : 0;
    }
}
