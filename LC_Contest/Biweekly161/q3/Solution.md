
# Solution Explanation

## Intuition
The problem asks for the **maximum possible minimum edge-cost** along any valid path from node `0` to node `n - 1` in a **DAG**, where a path is valid if:
- All intermediate nodes are online
- The total cost does not exceed `k`

This is a classic "maximize the minimum" problem, which can be efficiently solved using **binary search** on the possible minimum edge-cost, combined with a **feasibility check** using graph traversal.

## Approach
- **Topological Sort:**
  - Since the graph is a **DAG**, perform a topological sort to process nodes in dependency order.
- **Binary Search:**
  - Binary search on the possible minimum edge-cost (`thr`) from `0` to the maximum edge cost in the graph.
  - For each candidate `thr`, check if there exists a valid path from `0` to `n - 1` where all edge costs are at least `thr`, all intermediate nodes are online, and the total cost does not exceed `k`.
- **Feasibility Check (canReach):**
  - For a given threshold `thr`, use dynamic programming (DP) in topological order to compute the minimum cost to reach each node, only considering edges with cost at least `thr` and skipping offline nodes (except for `0` and `n - 1`).
  - If the minimum cost to reach `n - 1` is at most `k`, then `thr` is feasible.
- **Result:**
  - The answer is the largest `thr` for which a valid path exists. If no such path exists, return `-1`.

## Complexity
- **Time Complexity:**
  - Topological sort: `O(n + m)`
  - Binary search: `O(log C)` where `C` is the maximum edge cost
  - For each binary search step, DP over the DAG: `O(n + m)`
  - **Total:** `O((n + m) * log C)`
- **Space Complexity:**
  - Adjacency list, DP arrays, and topological order: `O(n + m)`

## Summary
- The solution uses **binary search** to maximize the minimum edge-cost along a valid path, leveraging the **DAG property** for efficient topological DP.
- The feasibility check ensures all constraints are met: only online nodes, total cost within `k`, and edge costs above the threshold.
- This approach is efficient for large graphs due to the topological order and avoids redundant computations.
- **Key insight:** Binary search on the minimum edge-cost, combined with DP in topological order, efficiently finds the optimal path score under the given constraints.

