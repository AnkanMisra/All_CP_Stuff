class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> answer = new ArrayList<>();
        // i to track [j - k, j + k], j to track nums[j] == key.
        int n = nums.length, i = 0, j = 0;
        while (i < n && j < n) {
            // nums[j] != key, check next j.
            if (nums[j] != key) {
                j++;
                // nums[j] == key, check if i in range [j - k, j + k].
            } else if (i < j - k) {
                // i not in range, check next i.
                i++;
            } else if (i <= j + k) {
                // i in range, add to answer.
                answer.add(i++);
                // i > j + k, check next j.
            } else {
                j++;
            }
        }
        return answer;
    }
}
