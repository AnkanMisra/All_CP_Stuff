class Solution {
    public int minOperations(int[] a) {
        int n = a.length;
        int[] b = new int[n + 2];
        int c = 1;
        b[0] = 0;
        int d = 0;
        for (int e = 0; e <= n; e++) {
            int f = e < n ? a[e] : 0;
            while (c > 1 && b[c - 1] > f) {
                int g = b[--c];
                if (b[c - 1] < g){
                  d++;  
                } 
            }
            if (b[c - 1] < f) {
                b[c++] = f;
            }
        }
        return d;
    }
}

