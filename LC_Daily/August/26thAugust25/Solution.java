class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxDiagonalSquared = 0;
        int maxArea = 0;

        for (int[] dimension : dimensions) {
            int length = dimension[0];
            int width = dimension[1];

            int diagonalSquared = length * length + width * width;
            int area = length * width;

            if (diagonalSquared > maxDiagonalSquared) {
                maxDiagonalSquared = diagonalSquared;
                maxArea = area;
            }
            else if (diagonalSquared == maxDiagonalSquared && area > maxArea) {
                maxArea = area;
            }
        }

        return maxArea;
    }
}
