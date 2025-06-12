class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int dif = Math.abs(nums[i] - nums[(i + 1) % nums.length]);
            max = Math.max(max, dif);
        }
        return max;
    }
}
