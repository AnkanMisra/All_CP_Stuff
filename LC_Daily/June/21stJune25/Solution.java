class Solution {
    public int minimumDeletions(String word, int k) {
        int[] memo = new int[26];
        for (char c : word.toCharArray()) {
            memo[c - 'a']++;
        }
        int min = Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<>();
        for (int m : memo) {
            if (m != 0)
                list.add(m);
        }
        Collections.sort(list);
        int l = 0, r = list.size() - 1;
        return getMin(list, l, r, k, 0);

    }

    private int getMin(List<Integer> list, int l, int r, int k, int min) {
        if (l >= r)
            return min;
        if ((list.get(r) - list.get(l)) > k) {
            int leftMin = getMin(list, l + 1, r, k, min + list.get(l));
            int rightMin = getMin(list, l, r - 1, k, min + (list.get(r) - list.get(l) - k));
            return Math.min(leftMin, rightMin);
        }
        return min;
    }
}
