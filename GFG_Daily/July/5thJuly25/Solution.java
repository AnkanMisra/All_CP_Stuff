class Solution {
    public int maxSum(int arr[]) {
        int n = arr.length;
        int maxSum = 0;
        for (int i = 0; i < n - 1; i++) {
            maxSum = Math.max(maxSum, arr[i] + arr[i + 1]);
        }
        return maxSum;
    }
}
