class Solution {
    public int longestPalindrome(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        boolean atleast = false;
        int length = 0;
        for (String s : map.keySet()) {
            String rev = new StringBuilder(s).reverse().toString();
            if (!s.equals(rev)) {
                if (map.containsKey(rev)) {
                    int minPairs = Math.min(map.get(s), map.get(rev));
                    length += minPairs * 4;
                    map.put(s, map.get(s) - minPairs);
                    map.put(rev, map.get(rev) - minPairs);
                }
            } else {
                int freq = map.get(s);
                int pairsOfSimilar = freq / 2;
                length += pairsOfSimilar * 4;
                if (freq % 2 == 1) {
                    atleast = true;
                }
            }
        }
        if (atleast)
            length += 2;
        return length;

    }
}
