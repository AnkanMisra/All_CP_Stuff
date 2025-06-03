class Solution {
    public int countSubstr(String s, int k) {
        return helper(s, k) - helper(s, k - 1);
    }

    private int helper(String s, int k) {
        int left = 0, right = 0, count = 0, distinctCount = 0;
        int[] freq = new int[256];

        while (right < s.length()) {
            if (freq[s.charAt(right)] == 0) {
                distinctCount++;
            }
            freq[s.charAt(right)]++;

            while (distinctCount > k) {
                freq[s.charAt(left)]--;
                if (freq[s.charAt(left)] == 0) {
                    distinctCount--;
                }
                left++;
            }

            count += right - left + 1;
            right++;
        }
        return count;
    }
}
