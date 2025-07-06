class Solution {
    public ArrayList<Integer> topKSumPairs(int[] a, int[] b, int k) {
        Arrays.sort(a);
        Arrays.sort(b);
        int n1 = a.length, n2 = b.length;

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((x, y) -> Integer.compare(y[0], x[0]));
        Set<String> visited = new HashSet<>();

        int i = n1 - 1, j = n2 - 1;
        maxHeap.offer(new int[]{a[i] + b[j], i, j});
        visited.add(i + "#" + j);

        ArrayList<Integer> res = new ArrayList<>();

        while (k-- > 0 && !maxHeap.isEmpty()) {
            int[] top = maxHeap.poll();
            res.add(top[0]);
            int x = top[1], y = top[2];

            if (x - 1 >= 0) {
                String key = (x - 1) + "#" + y;
                if (!visited.contains(key)) {
                    maxHeap.offer(new int[]{a[x - 1] + b[y], x - 1, y});
                    visited.add(key);
                }
            }

            if (y - 1 >= 0) {
                String key = x + "#" + (y - 1);
                if (!visited.contains(key)) {
                    maxHeap.offer(new int[]{a[x] + b[y - 1], x, y - 1});
                    visited.add(key);
                }
            }
        }

        return res;
    }
}