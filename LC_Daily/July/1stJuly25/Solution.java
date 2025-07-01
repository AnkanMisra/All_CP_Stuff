class Solution {
    public int possibleStringCount(String word) {
        int orig = 1;

        int i = 0;
        while (i < word.length()) {
            int j = i;
            while (j < word.length() && word.charAt(j) == word.charAt(i)) {
                j++;
            }
            int n = j - i;
            if (n > 1) {
                orig += (n - 1);
            }
            i = j;
        }
        return orig;
    }
}