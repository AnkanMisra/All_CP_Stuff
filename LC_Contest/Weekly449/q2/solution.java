class Solution {
  public boolean canPartitionGrid(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    long totalsum = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        totalsum += grid[i][j];
      }
    }
    if ((totalsum & 1) == 1) {
      return false;
    }
    long half = totalsum / 2;
    long sum = 0;
    for (int i = 0; i < m - 1; i++) {
      for (int j = 0; j < n; j++) {
        sum += grid[i][j];
      }
      if (sum == half) {
        return true;
      }
    }
    sum = 0;
    for (int j = 0; j < n - 1; j++) {
      for (int i = 0; i < m; i++) {
        sum += grid[i][j];
      }
      if (sum == half) {
        return true;
      }
    }
    return false;
  }
}
