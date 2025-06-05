# Solution Explanation

## Intuition
The problem asks for the number of distinct paths from a source node to a destination node in a Directed Acyclic Graph (DAG). Since the graph is acyclic, we can use recursion with memoization (dynamic programming) to efficiently count the number of paths from each node to the destination.

## Approach
- Represent the graph using an adjacency list.
- Use a recursive function to count the number of paths from the current node to the destination.
- Use a memoization array (`dp`) to store the number of paths from each node to avoid recomputation.
- Use a visited array to prevent revisiting nodes in the current path, although in a DAG this is mainly a safeguard.
- For each node, sum the number of paths from all its neighbors to the destination.
- The base case is when the current node is the destination, in which case there is exactly one path (the trivial path).

## Algorithm
1. Build the adjacency list for the graph from the edge list.
2. Initialize a memoization array `dp` with -1 to indicate uncomputed values.
3. Define a recursive function:
   - If the current node is the destination, return 1.
   - If the result for the current node is already computed, return it.
   - Otherwise, for each neighbor, recursively count the paths to the destination and sum them up.
   - Store the result in `dp` and return it.
4. Start the recursion from the source node.

## Complexity
- Time Complexity: O(V + E), where V is the number of vertices and E is the number of edges. Each node and edge is processed at most once due to memoization.
- Space Complexity: O(V + E) for the adjacency list, memoization array, and recursion stack.

## Summary
This approach leverages the acyclic property of the graph to use dynamic programming for efficient path counting. By memoizing the number of paths from each node, we avoid redundant calculations and ensure that the solution is efficient even for large graphs.
