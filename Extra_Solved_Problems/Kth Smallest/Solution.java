class Solution {
    public static int kthSmallest(int[] arr, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int x : arr) {
            pq.add(x);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        return pq.peek();
    }
}
