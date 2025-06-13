class Solution {
    public int minimizeMax(int[] nums, int p) {
        if (p == 0 || nums.length == 1)
            return 0;
        Arrays.sort(nums);
        int n = nums.length;
        int pairs = p;
        int i = 0;
        int j = 0;
        for (int k = 1; k < nums.length; k += 2) {
            if (pairs == 0)
                break;
            j = Math.max(nums[k] - nums[k - 1], j);
            pairs--;
        }
        int mindiff = j;
        while (i < j) {
            int m = (i + j) / 2;
            if (helper(nums, m, p)) {
                mindiff = Math.min(mindiff, m);
                j = m;
            } else {
                i = m + 1;
            }
        }
        return mindiff;
    }

    private boolean helper(int[] nums, int v, int p) {
        int i = 1;
        while (i < nums.length) {
            if (nums[i] - nums[i - 1] <= v) {
                p--;
                i += 2;
            } else if (i < nums.length - 1 && nums[i + 1] - nums[i] <= v) {
                p--;
                i += 3;
            } else {
                i++;
            }
            if (p == 0)
                return true;
        }
        return false;
    }
}
