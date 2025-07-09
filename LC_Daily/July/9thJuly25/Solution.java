class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;
        if (k == n) {
            int totalDuration = 0;
            for (int i = 0; i < n; i++) {
                totalDuration += (endTime[i] - startTime[i]);
            }
            return eventTime - totalDuration;
        }
        int[] duration = new int[n];
        long[] prefix = new long[n + 1];
        prefix[0] = 0;
        for (int i = 0; i < n; i++) {
            duration[i] = endTime[i] - startTime[i];
            prefix[i + 1] = prefix[i] + duration[i];
        }
        long totalDuration = prefix[n];
        long[] A = new long[n];
        long[] B = new long[n];
        for (int i = 0; i < n; i++) {
            A[i] = startTime[i] - prefix[i];
            B[i] = endTime[i] - prefix[i + 1];
        }
        int lo = 0, hi = eventTime, ans = 0;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (feasible(mid, eventTime, k, n, startTime, endTime, prefix, totalDuration, A, B)) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return ans;
    }
    
    private boolean feasible(int g, int eventTime, int k, int n, int[] startTime, int[] endTime,
                             long[] prefix, long totalDuration, long[] A, long[] B) {
        for (int i = 0; i < n && i <= k; i++) {
            if (startTime[i] - prefix[i] >= g) {
                return true;
            }
        }
        for (int j = n - 1; j >= 0 && (n - j - 1) <= k; j--) {
            if (eventTime - (endTime[j] + (totalDuration - prefix[j + 1])) >= g) {
                return true;
            }
        }
        Deque<Integer> dq = new LinkedList<>();
        int j = 1;
        for (int i = 0; i < n - 1; i++) {
            while (j < n && j <= i + k + 1) {
                while (!dq.isEmpty() && A[dq.peekLast()] <= A[j]) {
                    dq.pollLast();
                }
                dq.offerLast(j);
                j++;
            }
            while (!dq.isEmpty() && dq.peekFirst() <= i) {
                dq.pollFirst();
            }
            if (!dq.isEmpty()) {
                long candidate = A[dq.peekFirst()] - B[i];
                if (candidate >= g) {
                    return true;
                }
            }
        }
        return false;
    }
}