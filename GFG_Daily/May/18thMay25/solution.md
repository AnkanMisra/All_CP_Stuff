# Solution Explanation

### Intuition

Spiral (zigzag) level order traversal alternates the direction of traversal at each level of the binary tree:
- Even levels (starting from root at level 0): right to left
- Odd levels: left to right

We can use a queue for level order traversal and a flag to alternate the direction at each level.

### Approach

- Use a queue to perform standard level order traversal.
- For each level, collect the node values in a temporary list.
- If the current level should be traversed right to left, reverse the temporary list before adding to the result.
- Alternate the direction flag after each level.

### Code

```java
class Solution {
    public ArrayList<Integer> findSpiral(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;
        
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        boolean leftToRight = false; 
        
        while (!q.isEmpty()) {
            int size = q.size();
            ArrayList<Integer> levelList = new ArrayList<>();
            
            for (int i = 0; i < size; i++) {
                Node node = q.poll();
                levelList.add(node.data);
                
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            
            if (leftToRight) {
                res.addAll(levelList);
            } else {
                for (int i = levelList.size() - 1; i >= 0; i--) {
                    res.add(levelList.get(i));
                }
            }
            
            leftToRight = !leftToRight;
        }
        
        return res;
    }
}
```

### Complexity

- **Time Complexity:** O(n), where n is the number of nodes in the tree.
- **Space Complexity:** O(n), for the queue and result list.

### Summary

- The solution uses a queue for level order traversal and alternates the direction of adding node values at each level.
- This efficiently produces the spiral order traversal as required.
