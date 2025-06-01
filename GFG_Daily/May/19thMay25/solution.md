# Solution Explanation

### Intuition

To find the in-order predecessor and successor of a given key in a Binary Search Tree (BST), we can use the BST properties:
- The predecessor is the largest value smaller than the key.
- The successor is the smallest value greater than the key.

We can traverse the tree, updating the predecessor and successor as we go, and if we find the key, we look for the maximum in its left subtree (for predecessor) and the minimum in its right subtree (for successor).

### Approach

- Start from the root and traverse the tree:
  - If the current node's value is less than the key, update the predecessor and move to the right child.
  - If the current node's value is greater than the key, update the successor and move to the left child.
  - If the current node's value equals the key:
    - For predecessor, go to the left child and then as far right as possible.
    - For successor, go to the right child and then as far left as possible.
    - Break after finding both.
- Return the predecessor and successor nodes (or `null` if not found).

### Code

```java
class Solution {
    public ArrayList<Node> findPreSuc(Node root, int key) {
        ArrayList<Node> ans = new ArrayList<>(Arrays.asList(null, null));
        
        while(root != null){
            if(root.data < key){
                ans.set(0, root);
                root = root.right;
            }
            else if(root.data > key){
                ans.set(1, root);
                root = root.left;
            }
            else{
                if(root.left != null){
                    Node temp = root.left;
                    while(temp.right != null){
                        temp = temp.right;
                    }
                    ans.set(0, temp);
                }
                if(root.right != null){
                    Node temp = root.right;
                    while(temp.left != null){
                        temp = temp.left;
                    }
                    ans.set(1, temp);
                }
                break;
            }
        }
        
        return ans;
    }
}
```

### Complexity

- **Time Complexity:** O(h), where h is the height of the BST (O(log n) for balanced, O(n) for skewed).
- **Space Complexity:** O(1), as only a few pointers are used.

### Summary

- The solution efficiently finds the in-order predecessor and successor in a BST using its properties.
- It handles all cases, including when the key is not present in the tree.
- Returns `null` for predecessor or successor if they do not exist.
