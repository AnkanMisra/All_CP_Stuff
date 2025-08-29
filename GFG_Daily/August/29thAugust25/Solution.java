class Solution {
    public static String smallestWindow(String s, String p) {
        if (s.length() < p.length()) {
            return "";
        }

        int[] patternFreq = new int[26];
        for (char c : p.toCharArray()) {
            patternFreq[c - 'a']++;
        }

        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;
        int requiredChars = p.length();
        int[] windowFreq = new int[26];

        while (right < s.length()) {
            char rightChar = s.charAt(right);
            if (patternFreq[rightChar - 'a'] > 0) {
                windowFreq[rightChar - 'a']++;
                if (windowFreq[rightChar - 'a'] <= patternFreq[rightChar - 'a']) {
                    requiredChars--;
                }
            }

            while (requiredChars == 0) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }

                char leftChar = s.charAt(left);
                if (patternFreq[leftChar - 'a'] > 0) {
                    windowFreq[leftChar - 'a']--;
                    if (windowFreq[leftChar - 'a'] < patternFreq[leftChar - 'a']) {
                        requiredChars++;
                    }
                }
                left++;
            }

            right++;
        }
        
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}
