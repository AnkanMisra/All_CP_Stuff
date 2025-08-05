class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length, count = 0;
        boolean vis[] = new boolean[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!vis[j] && baskets[j] >= fruits[i]) {
                    vis[j] = true;
                    count++;
                    break;
                }
            }
        }
        return n - count;
    }
}