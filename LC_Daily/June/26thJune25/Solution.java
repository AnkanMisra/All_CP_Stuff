
class Solution {
    public int longestSubsequence(String s, int k) {
        int count = 0;
        long currentValue = 0;
        int shift = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch == '0') {
                count++;
                shift++;
            } else {

                if (shift <= 30 && currentValue + (1L << shift) <= k) {
                    currentValue += (1L << shift);
                    count++;
                    shift++;
                }
            }
        }
        return count;
    }
}
