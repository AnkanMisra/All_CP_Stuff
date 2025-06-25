class Solution {
    boolean sameFreq(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();

        for (char ch : s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        int freq1 = -1;
        int freq2 = -1;

        int c1 = 0, c2 = 0;

        for (char ch : freq.keySet()) {
            int value = freq.get(ch);

            if (freq1 == -1) {
                freq1 = value;
                c1 = 1;
            } else if (freq1 == value) {
                c1 += 1;
            } else if (freq2 == -1) {
                freq2 = value;
                c2 = 1;
            } else if (freq2 == value) {
                c2 += 1;
            } else {
                return false;
            }
        }

        if (freq2 == -1)
            return true;

        if ((freq1 == 1 && c1 == 1) || (freq2 == 1 && c2 == 1))
            return true;

        if (c1 == 1 && freq1 - 1 == freq2)
            return true;
        if (c2 == 1 && freq2 - 1 == freq1)
            return true;

        return false;
    }
}
