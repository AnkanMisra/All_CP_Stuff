class Solution {
    public int maxDiff(int num) {
        int minNum = num, maxNum = num;
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                String res = change(num, x, y);
                if (res.charAt(0) != '0') {
                    int i = Integer.parseInt(res);
                    minNum = Math.min(minNum, i);
                    maxNum = Math.max(maxNum, i);
                }
            }
        }
        return maxNum - minNum;
    }

    public String change(int num, int x, int y) {
        StringBuilder str = new StringBuilder(String.valueOf(num));
        int len = str.length();
        for (int i = 0; i < len; i++) {
            char digit = str.charAt(i);
            if (digit - '0' == x) {
                str.setCharAt(i, (char) ('0' + y));
            }
        }
        return str.toString();
    }
}
