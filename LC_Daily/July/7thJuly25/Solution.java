class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int res = 0, i = 0, n = events.length;
        int day = 0;
        while (i < n || !pq.isEmpty()) {
            if (pq.isEmpty()) day = events[i][0];
            while (i < n && events[i][0] == day) pq.offer(events[i++][1]);
            while (!pq.isEmpty() && pq.peek() < day) pq.poll();
            if (!pq.isEmpty()) {
                pq.poll();
                res++;
                day++;
            } else if (i < n) {
                day = events[i][0];
            }
        }
        return res;
    }
}
