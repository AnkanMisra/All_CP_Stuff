class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid[0].length;
        int x = n - 2, y = 0;
        boolean flag = true;

        while (y <= n - 2) {
            List<Integer> diagonal = new ArrayList<>();
            if (flag == true) {
                for (int tempX = x, tempY = y; tempX < n && tempY < n; tempX++, tempY++)
                    diagonal.add(grid[tempX][tempY]);
                diagonal.sort(Collections.reverseOrder());
                for (int tempX = x, tempY = y, i = 0; tempX < n && tempY < n; tempX++, tempY++, i++)
                    grid[tempX][tempY] = diagonal.get(i);
                x--;
            } else {
                for (int tempX = x, tempY = y; tempX < n && tempY < n; tempX++, tempY++)
                    diagonal.add(grid[tempX][tempY]);
                Collections.sort(diagonal);
                for (int tempX = x, tempY = y, i = 0; tempX < n && tempY < n; tempX++, tempY++, i++)
                    grid[tempX][tempY] = diagonal.get(i);
                y++;
            }
            if (x == -1) {
                flag = false;
                x = 0;
                y = 1;
            }
        }

        return grid;
    }
}
