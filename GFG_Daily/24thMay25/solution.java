class Solution {
    public static int sumSubstrings(String s) {
        int[] arr = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = '0' - s.charAt(i);
        }
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length() - i; j++) {
                int num = 0;
                for (int k = j; k < j + i + 1; k++) {
                    num = (num * 10) + arr[k];
                }
                count += num;
            }
        }
        return Math.abs(count);
    }
}
