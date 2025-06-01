# Solution Explanation

### Intuition

For each node `i` in the first tree, we want to connect it to some node in the second tree such that the number of nodes at an even distance from `i` is maximized.  
The problem can be broken down into:
- For each node in tree 1, count how many nodes are at an even distance and how many are at an odd distance from it.
- For each node in tree 2, count how many nodes are at an even distance and how many are at an odd distance from it.
- When connecting node `u` from tree 1 to node `v` from tree 2, the total number of nodes at an even distance from `u` is:
  - (nodes at even distance from `u` in tree 1) + (nodes at odd distance from `v` in tree 2)
  - (nodes at odd distance from `u` in tree 1) + (nodes at even distance from `v` in tree 2)
- We want to maximize this sum.

### Approach

- **Build Adjacency Lists:** Represent both trees using adjacency lists.
- **DFS for Even/Odd Counts:**
  - For each tree, perform a DFS to compute `evenOddCounts[node][0]` (even distance) and `evenOddCounts[node][1]` (odd distance) for each node.
- **Combine Results:**
  - Find the maximum of `evenOddCounts[v][1]` (odd distance) among all nodes `v` in tree 2.
  - For each node `i` in tree 1, the answer is `evenOddCounts[i][0]` (even distance in tree 1) + `maxOddCountFromTree2`.

### Code

```java
class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        int n = edges1.length + 1, m = edges2.length + 1;
        var map1 = map(edges1);
        var map2 = map(edges2);
        int map2MaxOddCount = max(evenOddCounts(map2, m), 1);
        var map1EvenOddCounts = evenOddCounts(map1, n);
        var result = new int[n];
        for (int node = 0; node < n; node++) {
            result[node] = map1EvenOddCounts[node][0] + map2MaxOddCount;
        }
        return result;
    }

    static int max(int[][] evenOddCounts, int evenOddIndex) {
        int max = 0;
        for (int[] evenOddCount : evenOddCounts) {
            max = Math.max(max, evenOddCount[evenOddIndex]);
        }
        return max;
    }

    static int[][] evenOddCounts(Map<Integer, List<Integer>> map, int noOfNodes) {
        boolean[] visited = new boolean[noOfNodes];
        int[][] evenOddCounts = new int[noOfNodes][2];
        fillEvenOddCount(map, visited, 0, 0, evenOddCounts);
        fillOriginalEvenOddCount(map, visited, 0, new int[2], evenOddCounts);
        return evenOddCounts;
    }

    static void fillOriginalEvenOddCount(Map<Integer, List<Integer>> map, boolean[] visited,
                                         int node, int[] parent, int[][] evenOddCounts) {
        if (visited[node]) return;
        visited[node] = true;
        int even = evenOddCounts[node][0] + parent[1];
        int odd = evenOddCounts[node][1] + parent[0];
        evenOddCounts[node] = new int[]{even, odd};
        for (var child : map.getOrDefault(node, Collections.emptyList())) {
            int[] nextParent = {even - evenOddCounts[child][1], odd - evenOddCounts[child][0]};
            fillOriginalEvenOddCount(map, visited, child, nextParent, evenOddCounts);
        }
        visited[node] = false;
    }

    static void fillEvenOddCount(Map<Integer, List<Integer>> map, boolean[] visited, int node, int id, int[][] evenOddCounts) {
        if (visited[node]) return;
        visited[node] = true;
        int even = 1, odd = 0;
        for (var child : map.getOrDefault(node, Collections.emptyList())) {
            fillEvenOddCount(map, visited, child, id + 1, evenOddCounts);
            even += evenOddCounts[child][1];
            odd += evenOddCounts[child][0];
        }
        visited[node] = false;
        evenOddCounts[node] = new int[]{even, odd};
    }

    static Map<Integer, List<Integer>> map(int[][] edges) {
        var map = new HashMap<Integer, List<Integer>>();
        for (var edge : edges) {
            int u = edge[0], v = edge[1];
            map.putIfAbsent(u, new ArrayList<>());
            map.putIfAbsent(v, new ArrayList<>());
            map.get(u).add(v);
            map.get(v).add(u);
        }
        return map;
    }
}
```

### Complexity

- **Time Complexity:** O(N + M), where N and M are the number of nodes in the trees (due to DFS).
- **Space Complexity:** O(N + M), for the adjacency lists and DP arrays.

### Summary

- The solution uses DFS to compute the number of nodes at even and odd distances for each node in both trees.
- It then combines these counts to find the maximum number of target nodes for each node in the first tree.
- The approach is efficient and optimal for the given constraints.
