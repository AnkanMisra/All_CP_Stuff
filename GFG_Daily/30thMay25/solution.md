# Solution Explanation

### Intuition

We need to find the greatest number in a Binary Search Tree (BST) that is less than or equal to a given value `k`.  
An in-order traversal of a BST visits nodes in ascending order. We can use this property to efficiently find the desired value.

### Approach

- Perform an in-order traversal of the BST.
- During the traversal, if a node's value is less than or equal to `k`, update the answer to be the maximum of the current answer and the node's value.
- Since the traversal is in-order, the last such update will give the greatest value less than or equal to `k`.
- If a node's value is greater than `k`, we don't need to explore its right subtree (as all values there will also be greater than `k`).

### Code

```java
class Solution {
    int ans = -1; // Initialize with -1 or a suitable default

    void inOrder(Node root, int k) {
        if (root == null) return;
        
        // Traverse left subtree
        inOrder(root.left, k);
        
        // Process current node
        if (root.data <= k) {
            ans = Math.max(ans, root.data);
            // If current node is <= k, its right subtree might also contain valid candidates
            inOrder(root.right, k); 
        }
        // If root.data > k, we don't need to check the right subtree
        // because all elements there will also be > k.
        // The left subtree was already processed.
    }

    public int findMaxFork(Node root, int k) {
        ans = -1; // Reset ans for each call if Solution object is reused
        inOrder(root, k);
        return ans;
    }
}
```

### Complexity

- **Time Complexity:** O(n) in the worst case (skewed tree), O(log n) on average for a balanced tree.
- **Space Complexity:** O(h), where h is the height of the tree (for the recursion stack).

### Summary

- The solution uses in-order traversal to find the greatest value less than or equal to `k`.
- It efficiently prunes the search space by not exploring right subtrees of nodes greater than `k`.
- Returns -1 if no such value is found.
