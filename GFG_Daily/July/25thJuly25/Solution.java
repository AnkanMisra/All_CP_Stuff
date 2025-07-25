class Solution {
    public int maxCircularSum(int arr[]) {
        int total = 0;
        int maxSum = Integer.MIN_VALUE;
        int curMax = 0;
        int minSum = Integer.MAX_VALUE;
        int curMin = 0;

        for (int num : arr) {
            curMax = Math.max(num, curMax + num);
            maxSum = Math.max(maxSum, curMax);

            curMin = Math.min(num, curMin + num);
            minSum = Math.min(minSum, curMin);

            total += num;
        }

        if (maxSum < 0) {
            return maxSum;
        }

        return Math.max(maxSum, total - minSum);
    }

}
