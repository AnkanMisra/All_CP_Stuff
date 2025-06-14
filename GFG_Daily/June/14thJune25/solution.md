# Solution Explanation

## Intuition
A binary tree is symmetric if its left and right subtrees are mirror images of each other. This means that for every node in the left subtree, there should be a corresponding node in the right subtree with the same value, and their respective left and right children should also be mirrors.

## Approach
- If the root is null, the tree is symmetric.
- Use a helper function to recursively check if two subtrees are mirrors:
  - If both nodes are null, they are mirrors.
  - If only one is null or their values differ, they are not mirrors.
  - Recursively check:
    - The left child of the first subtree with the right child of the second subtree.
    - The right child of the first subtree with the left child of the second subtree.
- The tree is symmetric if the left and right subtrees of the root are mirrors.

## Complexity
- Time Complexity: O(n), where n is the number of nodes in the tree, since each node is visited once.
- Space Complexity: O(h), where h is the height of the tree, due to the recursion stack.

## Summary
By recursively checking if the left and right subtrees are mirrors at every level, we can efficiently determine if the binary tree is symmetric.
