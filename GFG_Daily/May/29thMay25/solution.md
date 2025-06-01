# Solution Explanation

### Intuition

We need to find the sum of nodes on the longest path from the root to any leaf. If multiple paths have the same maximum length, we choose the one with the maximum sum. This can be solved using a recursive approach (DFS) where we keep track of both the length and sum of the current path.

### Approach

- Use a recursive helper function that returns a `Pair` containing the length and sum of the longest path in the current subtree.
- Base case: If the node is `null`, return a `Pair` with length 0 and sum 0.
- Recursively call the helper for the left and right children.
- Compare the lengths of the longest paths from the left and right subtrees:
  - If the left path is longer, return a `Pair` with the left path's length and sum (plus current node's data).
  - If the right path is longer, return a `Pair` with the right path's length and sum (plus current node's data).
  - If both paths have the same length, return a `Pair` with that length and the maximum of the two sums (plus current node's data).
- The final answer is the sum from the `Pair` returned by the initial call with the root.

### Code

```java
class Solution {
    class Pair {
        int v; // sum of values
        int d; // depth or length of path

        Pair(int d, int v) {
            this.v = v;
            this.d = d;
        }
    }

    public int sumOfLongRootToLeafPath(Node root) {
        return f(root, 0).v;
    }

    Pair f(Node root, int level) {
        if (root == null) {
            // Return current level as depth, sum is 0
            return new Pair(level, 0); 
        }
        // For leaf nodes, the path ends here.
        // The sum includes the current node's data.
        if (root.left == null && root.right == null) {
            return new Pair(level + 1, root.data);
        }

        Pair left = f(root.left, level + 1);
        Pair right = f(root.right, level + 1);

        if (left.d > right.d) {
            left.v += root.data;
            return left;
        } else if (left.d < right.d) {
            right.v += root.data;
            return right;
        } else {
            // If depths are equal, choose the path with the maximum sum
            return new Pair(left.d, Math.max(left.v, right.v) + root.data);
        }
    }
}
```

### Complexity

- **Time Complexity:** O(n), where n is the number of nodes in the tree (each node is visited once).
- **Space Complexity:** O(h), where h is the height of the tree (for the recursion stack).

### Summary

- The solution uses DFS to find the longest path and its sum.
- It handles the tie-breaking condition (maximum sum for paths of the same length).
- The approach is efficient and optimal for the given constraints.
