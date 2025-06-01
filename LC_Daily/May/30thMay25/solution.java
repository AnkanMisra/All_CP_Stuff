class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int visited1[] = new int[edges.length], visited2[] = new int[edges.length];
        Queue<Integer> q = new LinkedList<>();
        int dis = 1, dis1 = 1;
        q.add(node1);
        while (q.size() != 0) {
            if (q.peek() != -1 && visited1[q.peek()] == 0) {
                visited1[q.peek()] = dis++;
                q.add(edges[q.peek()]);
            }
            q.remove();
        }
        q.add(node2);
        while (q.size() != 0) {
            if (q.peek() != -1 && visited2[q.peek()] == 0) {
                visited2[q.peek()] = dis1++;
                q.add(edges[q.peek()]);
            }
            q.remove();
        }
        int temp = Integer.MAX_VALUE, ans = -1;
        for (int i = 0; i < visited1.length; i++) {
            visited1[i] = (visited1[i] != 0 && visited2[i] != 0)
                    ? (visited1[i] > visited2[i]) ? visited1[i] : visited2[i]
                    : 0;
        }
        for (int i = 0; i < visited1.length; i++) {
            if (temp > visited1[i] && visited1[i] != 0) {
                temp = visited1[i];
                ans = i;
            }
        }
        return ans;
    }
}
