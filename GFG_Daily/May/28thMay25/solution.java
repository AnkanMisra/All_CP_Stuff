class Solution {
    public boolean ValidCorner(int mat[][]) {
        int m = mat.length;
        int n = mat[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    int r = i;
                    int c = j;
                    for (int k = j + 1; k < n; k++) {
                        if (mat[r][k] == 1) {
                            for (int p = r + 1; p < m; p++) {
                                if (mat[p][c] == 1 && mat[p][k] == 1) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
