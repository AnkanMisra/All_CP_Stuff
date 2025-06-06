class Solution {
    public String robotWithString(String s) {
        int n = s.length();
        int[] dp = new int[n];
        dp[n - 1] = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            dp[i] = s.charAt(i) <= s.charAt(dp[i + 1]) ? i : dp[i + 1];
        }
        Deque<Character> stack = new ArrayDeque<>();
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < n) {
            if (!stack.isEmpty())
                sb.append(stack.pop());
            if (stack.isEmpty() || s.charAt(dp[i]) < stack.peek()) {
                int smallestIndex = dp[i];
                for (; i <= smallestIndex; i++) {
                    stack.push(s.charAt(i));
                }
            }
        }
        while (!stack.isEmpty())
            sb.append(stack.pop());
        return sb.toString();
    }
}
