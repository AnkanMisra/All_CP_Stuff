class Solution {
    public int maxFreqSum(String s) {
        int[] a = new int[26];
        int b = 0, c = 0;
        for (char d : s.toCharArray()) {
            int e = d - 'a';
            a[e]++;
            if (d == 'a'||d == 'e'||d == 'i'||d== 'o'|| d == 'u') {
                b = Math.max(b, a[e]);
            } else {
                c = Math.max(c, a[e]);
            }
        }
        return b + c;
    }
}
