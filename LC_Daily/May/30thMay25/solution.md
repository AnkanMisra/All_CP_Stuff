# Solution Explanation

### Intuition

We need to find a node that is reachable from both `node1` and `node2`, such that the maximum of the distances from `node1` and `node2` to this node is minimized. If multiple such nodes exist, we choose the one with the smallest index.

This can be solved by performing two separate traversals (BFS or DFS) starting from `node1` and `node2` to compute the distances to all reachable nodes. Then, iterate through all nodes and find the one that minimizes the maximum distance.

### Approach

- Perform a traversal (e.g., BFS) starting from `node1` to compute the distances to all reachable nodes. Store these in `visited1`.
- Perform another traversal starting from `node2` to compute distances to all reachable nodes. Store these in `visited2`.
- Iterate through all nodes from 0 to n-1:
  - If a node is reachable from both `node1` and `node2` (i.e., its distance is not 0 in both `visited1` and `visited2`):
    - Calculate the maximum of the two distances.
    - If this maximum is less than the current minimum maximum, update the answer.
    - If the maximum is equal to the current minimum maximum, update the answer if the current node's index is smaller.
- Return the final answer, or -1 if no such node exists.

### Code

```java
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
            visited1[i] = (visited1[i] != 0 && visited2[i] != 0) ? (visited1[i] > visited2[i]) ? visited1[i] : visited2[i] : 0;
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
```

### Complexity

- **Time Complexity:** O(n), where n is the number of nodes (due to two traversals).
- **Space Complexity:** O(n), for the distance arrays and queue.

### Summary

- The solution performs two separate traversals to compute distances from `node1` and `node2`.
- It then iterates through all nodes to find the one that minimizes the maximum distance.
- Handles cycles and unreachable nodes correctly.
