class Solution {
    public int nonLisMaxSum(int[] arr) {
        int n = arr.length;

        int[] lisLen = new int[n];
        int[] lisSum = new int[n];

        for (int i = 0; i < n; i++) {
            lisLen[i] = 1;
            lisSum[i] = arr[i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    if (lisLen[j] + 1 > lisLen[i]) {
                        lisLen[i] = lisLen[j] + 1;
                        lisSum[i] = lisSum[j] + arr[i];
                    } else if (lisLen[j] + 1 == lisLen[i]) {
                        lisSum[i] = Math.min(lisSum[i], lisSum[j] + arr[i]);
                    }
                }
            }
        }

        int maxLen = 0;
        for (int len : lisLen) {
            maxLen = Math.max(maxLen, len);
        }

        int minLISsum = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (lisLen[i] == maxLen) {
                minLISsum = Math.min(minLISsum, lisSum[i]);
            }
        }

        int totalSum = 0;
        for (int val : arr) totalSum += val;

        return totalSum - minLISsum;
    }
}