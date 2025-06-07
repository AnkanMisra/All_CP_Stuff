class Solution {
    public int longestCommonSum(int[] a1, int[] a2) {

        int n = a1.length, s1 = 0, s2 = 0, ans = 0;
        HashMap<Integer, Integer> m = new HashMap<>();

        for (int i = 0; i < n; i++) {
            s1 += a1[i];
            s2 += a2[i];

            if (s1 == s2)
                ans = Math.max(ans, i + 1);
            else {
                int diff = s1 - s2;
                if (m.containsKey(diff)) {
                    ans = Math.max(ans, i - m.get(diff));
                } else
                    m.put(diff, i);
            }
        }
        return ans;
    }
}
