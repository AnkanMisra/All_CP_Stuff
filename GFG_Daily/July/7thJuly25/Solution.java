class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>(n);
        for (int i = 0; i < n; i++) result.add(-1);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int idx = 2 * n - 1; idx >= 0; idx--) {
            int i = idx % n;
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            if (idx < n) {
                if (!stack.isEmpty()) {
                    result.set(i, stack.peek());
                }
            }
            stack.push(arr[i]);
        }
        return result;
    }
}