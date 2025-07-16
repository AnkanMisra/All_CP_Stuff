
# Solution Explanation

## Intuition
Kefa wants to reach a restaurant (leaf node) in a tree without encountering more than a certain number of consecutive vertices with cats. The problem reduces to traversing all root-to-leaf paths and counting those where the maximum number of consecutive cat vertices does not exceed `m`.

## Approach
- **Model the park as a tree:** Build an adjacency list from the input edges.
- **Track consecutive cats:** As we traverse from the root (Kefa's house), keep a running count of consecutive vertices with cats. If a vertex has a cat, increment the count; otherwise, reset it to zero.
- **DFS Traversal:** Use an iterative DFS (with a stack) to avoid recursion depth issues. For each node, pass along the current count of consecutive cats.
- **Leaf detection:** A node is a restaurant (leaf) if it has no unvisited children. If we reach a leaf and the path's maximum consecutive cats is within the allowed limit, count it as a valid restaurant.
- **Skip invalid paths:** If at any point the consecutive cat count exceeds `m`, stop traversing that path.

## Complexity
- Time Complexity: `O(n)` (each node and edge is visited once)
- Space Complexity: `O(n)` (for the adjacency list, visited array, and stack)

## Summary
This approach efficiently explores all possible root-to-leaf paths in the tree, only counting those that satisfy the consecutive cat constraint. By tracking the consecutive cat count during traversal and stopping early on invalid paths, we ensure optimal performance. The use of iterative DFS avoids stack overflow for large trees, and the solution handles all edge cases, such as when the root or leaves have cats, or when the tree is a straight line.

