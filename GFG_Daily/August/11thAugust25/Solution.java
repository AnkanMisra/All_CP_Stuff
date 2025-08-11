class Solution {
    public int maxSum(String s) {
        int n = s.length();
        if (n < 2) return 0;
        int[] d = manacherOdd(s);

        int[] maxEnd = new int[n];
        int[] maxStart = new int[n];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        int centerIdx = 0;
        for (int e = 0; e < n; e++) {
            while (centerIdx < n && centerIdx <= e) {
                int c = centerIdx;
                int B = 1 - 2 * c;
                int R = c + d[c] - 1;
                pq.offer(new int[]{B, R});
                centerIdx++;
            }
            while (!pq.isEmpty() && pq.peek()[1] < e) pq.poll();
            if (!pq.isEmpty()) {
                maxEnd[e] = 2 * e + pq.peek()[0];
            } else {
                maxEnd[e] = 1;
            }
        }

        int[] maxPref = new int[n];
        int cur = 0;
        for (int i = 0; i < n; i++) {
            if (maxEnd[i] > cur) cur = maxEnd[i];
            maxPref[i] = cur;
        }

        PriorityQueue<int[]> pq2 = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        int centerIdx2 = n - 1;
        for (int sIdx = n - 1; sIdx >= 0; sIdx--) {
            while (centerIdx2 >= 0 && centerIdx2 >= sIdx) {
                int c = centerIdx2;
                int C = 2 * c + 1;
                int L = c - d[c] + 1;
                pq2.offer(new int[]{C, L});
                centerIdx2--;
            }
            while (!pq2.isEmpty() && pq2.peek()[1] > sIdx) pq2.poll();
            if (!pq2.isEmpty()) {
                maxStart[sIdx] = -2 * sIdx + pq2.peek()[0];
            } else {
                maxStart[sIdx] = 1;
            }
        }

        int[] maxSuff = new int[n];
        cur = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (maxStart[i] > cur) cur = maxStart[i];
            maxSuff[i] = cur;
        }

        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            ans = Math.max(ans, maxPref[i] + maxSuff[i + 1]);
        }
        return ans;
    }

    private int[] manacherOdd(String s) {
        int n = s.length();
        int[] d = new int[n];
        int l = 0, r = -1;
        for (int i = 0; i < n; i++) {
            int k = 1;
            if (i <= r) k = Math.min(d[l + r - i], r - i + 1);
            while (i - k >= 0 && i + k < n && s.charAt(i - k) == s.charAt(i + k)) k++;
            d[i] = k;
            if (i + k - 1 > r) {
                l = i - k + 1;
                r = i + k - 1;
            }
        }
        return d;
    }
}
