class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int maxOr = 0;
        for (int num : nums) {
            maxOr |= num;
        }

        return backtrack(nums, 0, 0, maxOr);
    }

    private int backtrack(int[] nums, int index, int currentOr, int maxOr) {
        if (index == nums.length) {
            return currentOr == maxOr ? 1 : 0;
        }

        int count = 0;

        count += backtrack(nums, index + 1, currentOr, maxOr);

        count += backtrack(nums, index + 1, currentOr | nums[index], maxOr);

        return count;
    }
}
