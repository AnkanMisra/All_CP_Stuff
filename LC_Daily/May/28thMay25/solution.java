class Solution {

    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        final int N = edges1.length + 1;
        final int M = edges2.length + 1;

        if (k == 0) {
            int[] res = new int[N];
            Arrays.fill(res, 1);
            return res;
        }

        // build adjacency lists
        List<Integer>[] tree1 = buildAdj(edges1, N);
        List<Integer>[] tree2 = buildAdj(edges2, M);

        // dp1[v][d] stores number of descendants of v in tree1 at distance d from v
        // (forward paths)
        // dp2[v][d] stores number of descendants of v in tree2 at distance d from v
        // (forward paths)
        int[][] dp1 = new int[N][k + 1]; // distance ranging 0 to k
        int[][] dp2 = new int[M][k]; // distance ranging 0 to (k - 1)
        int[] parent1 = new int[N];
        int[] parent2 = new int[M];
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        dfs(0, -1, tree1, parent1, dp1, q1, k); // root tree1 arbitrarily at node 0
        dfs(0, -1, tree2, parent2, dp2, q2, k - 1); // root tree2 arbitrarily at node 0
        // only interested in paths of length up to k - 1 in tree2 to account for 1 edge
        // connecting the 2 trees

        // backtrack1[v][d] stores number of paths in tree1 of length d that start from
        // v and
        // passes through the parent of v (backward paths)
        int[][] backtrack1 = new int[N][k + 1]; // distance ranging 0 to k
        int[][] backtrack2 = new int[M][k]; // distance ranging 0 to (k - 1)
        int[] count1 = new int[N]; // store all paths of lengths <= k in tree1 that start from v in any direction
        int[] count2 = new int[M]; // store all paths of lengths <= k - 1 in tree2 that start from v in any
                                   // direction

        // populate the backtrack and count arrays
        calcBacktrack(q1, parent1, dp1, backtrack1, count1, k);
        calcBacktrack(q2, parent2, dp2, backtrack2, count2, k - 1);

        int maxConnectivity = 1;
        for (int count : count2)
            maxConnectivity = Math.max(maxConnectivity, count);

        // overwrite answer onto count1
        for (int v = 0; v < N; v++)
            count1[v] += maxConnectivity;

        return count1;
    }

    private List<Integer>[] buildAdj(int[][] edges, int vertexCount) {
        List<Integer>[] tree = new List[vertexCount];
        int u, v;
        for (int[] edge : edges) {
            u = edge[0];
            v = edge[1];
            if (tree[u] == null)
                tree[u] = new LinkedList<Integer>();
            if (tree[v] == null)
                tree[v] = new LinkedList<Integer>();
            tree[u].add(v);
            tree[v].add(u);
        }
        return tree;
    }

    private void dfs(int v, int p, List<Integer>[] adj, int[] parent, int[][] dp, Queue<Integer> q, int k) {
        dp[v][0] = 1; // distance of 0
        q.offer(v); // pre-order queue
        parent[v] = p; // mark p as the parent of v

        if (adj[v] != null)
            for (int u : adj[v]) {
                if (u == p)
                    continue;
                dfs(u, v, adj, parent, dp, q, k);
            }

        // at this point all children nodes have been processed
        if (p == -1) // if this is the root node
            return;

        // merge current node's contributions to its parent
        for (int d = 1; d <= k; d++)
            dp[p][d] += dp[v][d - 1];
    }

    private void calcBacktrack(Queue<Integer> q, int[] parent, int[][] dp, int[][] backtrack, int[] count, int k) {
        int v, p;

        // populating the backtrack matrix requires processing nodes in topological
        // order
        // so that data for a parent is fully computed by the time start processing
        // child
        // can use either a preorder queue like here, or postorder stack
        while (!q.isEmpty()) {
            v = q.poll();
            p = parent[v];

            // distance 0 from v
            count[v] = dp[v][0];

            // distance 1 from v
            if (k >= 1) {
                if (p != -1) // cannot backtrack if v is the root node
                    backtrack[v][1] = 1;
                // from v to descendants, and from v back through parent of v
                count[v] += dp[v][1] + backtrack[v][1];
            }

            // distances 1 < d <= k from v
            for (int d = 2; d <= k; d++) {
                if (p != -1) // cannot backtrack if v is the root node

                    // paths of distance d from v, that goes from v back to the parent of v (p)
                    // then either go through another child of p, or back to grandparent

                    // paths from p will have length d - 1 to account for edge (p-v)

                    // when using dp[p][d - 1] this number also includes forward paths that
                    // go through v which we don't want, so we have to subtract these sub-paths
                    backtrack[v][d] = dp[p][d - 1] - dp[v][d - 2] + backtrack[p][d - 1];

                // from v to descendants, and from v back through parent of v
                count[v] += dp[v][d] + backtrack[v][d];
            }
        }
    }
}
