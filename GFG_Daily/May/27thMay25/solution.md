# Solution Explanation

### Intuition

Given the preorder traversal of a BST, we want to find all the leaf nodes **without building the entire tree**.  
We can simulate the construction of the BST using the properties of preorder traversal and BST value ranges, and collect the leaf nodes during this process.

### Approach

- Use a recursive helper function to simulate the BST construction from the preorder array.
- Maintain a global index (`idx`) to track the current position in the preorder array.
- For each recursive call, use `min` and `max` to represent the valid range for the current subtree.
- If the current value is out of range or we've processed all elements, return `null`.
- Otherwise, create a node and recursively build its left and right subtrees.
- If both left and right subtrees are `null`, the node is a leaf, so add its value to the result list.
- Return the result list after processing the entire preorder array.

### Code

```java
class Solution {
    int idx;

    public ArrayList<Integer> leafNodes(int[] preorder) {
        ArrayList<Integer> result = new ArrayList<>();
        idx = 0;
        helper(preorder, result, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return result;
    }

    private Node helper(int[] preorder, ArrayList<Integer> result, int min, int max) {
        if (idx >= preorder.length || preorder[idx] < min || preorder[idx] > max)
            return null;

        int val = preorder[idx++];
        Node root = new Node(val);

        root.left = helper(preorder, result, min, val - 1);
        root.right = helper(preorder, result, val + 1, max);

        if (root.left == null && root.right == null) {
            result.add(root.data);
        }

        return root;
    }

    class Node {
        int data;
        Node left, right;

        Node(int val) {
            data = val;
        }
    }
}
```

### Complexity

- **Time Complexity:** O(n), where n is the length of the preorder array (each node is processed once).
- **Space Complexity:** O(n), for the recursion stack and result list.

### Summary

- The solution simulates BST construction using preorder traversal and value ranges.
- Leaf nodes are detected during the recursive process without building the full tree structure.
- The approach is efficient and optimal for the given constraints.
