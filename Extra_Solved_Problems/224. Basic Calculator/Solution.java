class Solution {
    public int calculate(String s) {
        int n = s.length();
        int res = 0;
        int sign = 1;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; ) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                long num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                res += sign * (int) num;
                continue;
            } else if (c == '+') {
                sign = 1;
            } else if (c == '-') {
                sign = -1;
            } else if (c == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            } else if (c == ')') {
                int prevSign = stack.pop();
                int prevRes = stack.pop();
                res = prevRes + prevSign * res;
            }
            i++;
        }
        return res;
    }
}
