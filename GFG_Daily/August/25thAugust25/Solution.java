class Solution {
    public int maximizeMedian(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;
        int medianIndex = (arr.length-1)/2;
        int current = arr[medianIndex];

        if(arr.length%2 == 0 && arr[medianIndex+1]-arr[medianIndex] >=k ) {
            return (arr[medianIndex+1]+arr[medianIndex]+k)/2;
        }

        for (int i = medianIndex; i < n - 1 && k > 0; i++) {
            int gap = arr[i + 1] - arr[i];
            int count = (i - medianIndex + 1);
            int needed = gap * count;

            if (k >= needed) {
                current = arr[i + 1];
                k -= needed;
            } else {
                current += k / count;
                k = 0;
            }
        }

        if (k > 0) {
            current += k / (n - medianIndex);
        }

        return current;
    }
}
