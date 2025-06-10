class Solution {
    public long countStrings(String s) {
        int n = s.length();

        if (n <= 1) {
            return 1;
        }

        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        boolean hasDuplicates = false;
        for (int count : freq) {
            if (count > 1) {
                hasDuplicates = true;
                break;
            }
        }

        long sumOfIdenticalCharPairs = 0;
        for (int count : freq) {
            sumOfIdenticalCharPairs += (long) count * (count - 1) / 2;
        }
        long totalPossiblePairs = (long) n * (n - 1) / 2;
        long distinctSwappedStringsCount = totalPossiblePairs - sumOfIdenticalCharPairs;
        if (hasDuplicates) {
            return distinctSwappedStringsCount + 1;
        } else {
            return distinctSwappedStringsCount;
        }
    }

}
