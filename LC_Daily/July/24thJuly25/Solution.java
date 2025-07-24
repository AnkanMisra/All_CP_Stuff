import java.util.*;

class Solution {
    List<Integer>[] adj;
    int[] xorSubtree;
    int[] inTime, outTime;
    int timer = 0;
    int totalXor = 0;

    void dfs(int node, int parent, int[] nums) {
        inTime[node] = timer++;
        xorSubtree[node] = nums[node];
        for (int child : adj[node]) {
            if (child != parent) {
                dfs(child, node, nums);
                xorSubtree[node] ^= xorSubtree[child];
            }
        }
        outTime[node] = timer++;
    }

    boolean isAncestor(int a, int b) {
        return inTime[a] <= inTime[b] && outTime[a] >= outTime[b];
    }

    public int minimumScore(int[] nums, int[][] edges) {
        int n = nums.length;
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }

        xorSubtree = new int[n];
        inTime = new int[n];
        outTime = new int[n];
        for (int val : nums) totalXor ^= val;
        dfs(0, -1, nums);

        int minScore = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int xor1, xor2, xor3;
                if (isAncestor(i, j)) {
                    xor1 = xorSubtree[j];
                    xor2 = xorSubtree[i] ^ xorSubtree[j];
                    xor3 = totalXor ^ xorSubtree[i];
                } else if (isAncestor(j, i)) {
                    xor1 = xorSubtree[i];
                    xor2 = xorSubtree[j] ^ xorSubtree[i];
                    xor3 = totalXor ^ xorSubtree[j];
                } else {
                    xor1 = xorSubtree[i];
                    xor2 = xorSubtree[j];
                    xor3 = totalXor ^ xorSubtree[i] ^ xorSubtree[j];
                }
                int max = Math.max(xor1, Math.max(xor2, xor3));
                int min = Math.min(xor1, Math.min(xor2, xor3));
                minScore = Math.min(minScore, max - min);
            }
        }
        return minScore;
    }
}
