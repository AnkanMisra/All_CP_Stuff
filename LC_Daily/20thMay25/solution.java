class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int[] counts = new int[nums.length + 1];
        for (int[] query : queries) {
            counts[query[0]]++;
            counts[query[1] + 1]--;
        }

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += counts[i];
            if (nums[i] > sum) {
                return false;
            }
        }

        return true;
    }
}
