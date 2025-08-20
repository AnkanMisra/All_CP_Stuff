class Solution {
    public boolean searchMatrix(int[][] mat, int x) {
        int n = mat.length;
        if (n == 0) return false;
        int m = mat[0].length;
        int low = 0, high = n * m - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midVal = mat[mid / m][mid % m];
            if (midVal == x) {
                return true;
            }
            int lowVal = mat[low / m][low % m];
            if (lowVal <= midVal) {
                if (x >= lowVal && x < midVal) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                int highVal = mat[high / m][high % m];
                if (x > midVal && x <= highVal) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }
}
