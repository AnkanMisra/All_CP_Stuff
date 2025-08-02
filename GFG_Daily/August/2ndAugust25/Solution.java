class Solution {
    public int longestSubarray(int[] arr, int k) {
        int n = arr.length;
        int[] prefix = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int val = (arr[i - 1] > k) ? 1 : -1;
            prefix[i] = prefix[i - 1] + val;
        }

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i <= n; i++) {
            if (stack.isEmpty() || prefix[i] < prefix[stack.peek()]) {
                stack.push(i);
            }
        }

        int ans = 0;
        for (int i = n; i >= 0; i--) {
            while (!stack.isEmpty() && prefix[i] > prefix[stack.peek()]) {
                ans = Math.max(ans, i - stack.peek());
                stack.pop();
            }
        }
        return ans;
    }
}
