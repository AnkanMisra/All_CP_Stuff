class Solution {
    public int maximumLength(int[] nums, int k) {
        int n = nums.length, ans = 1;
        int[][] f = new int[n][k];
        for(int[] x : f) {
            Arrays.fill(x, 1);
        }
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                int mod = (nums[i] + nums[j]) % k;
                f[i][mod] = f[j][mod] + 1;
                ans = Math.max(ans, f[i][mod]);
            }
        }
        return ans;
    }
}