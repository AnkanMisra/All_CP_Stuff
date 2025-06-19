class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        int curr = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - curr > k) {
                count++;
                curr = nums[i];
            }
        }
        return count + 1;
    }
}
