class Solution {
    public int maxDifference(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (char c : s.toCharArray())
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        Integer even = null;
        Integer odd = null;
        for (int v : hm.values()) {
            if (v % 2 == 0) {
                if (even == null || v < even)
                    even = v;
            } else {
                if (odd == null || v > odd)
                    odd = v;
            }
        }

        if (even == null || odd == null)
            return -1;
        return odd - even;
    }
}
