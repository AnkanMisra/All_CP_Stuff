# Solution Explanation

### Intuition

To simulate the burning of a binary tree starting from a target node, we need to spread the fire to the left child, right child, and parent of each burning node at each second. This is essentially a **Breadth-First Search (BFS)** where each level represents one second of burning.

### Approach

- Use a map to store the parent of each node for easy upward traversal.
- Use a queue to perform BFS starting from the target node.
- Use a set to keep track of burned nodes to avoid revisiting.
- For each second, process all currently burning nodes and add their unburned neighbors (left, right, parent) to the queue.
- The answer is the number of BFS levels (seconds) needed to burn all nodes, minus one (since the last increment happens after the last node burns).

### Code

```java
class Solution {
    public static int minTime(Node root, int target) {
        Map<Node,Node> hm=new HashMap<>();
        Queue<Node> q=new LinkedList<>();
        Set<Node> burned=new HashSet<>();
        parents(root,null,hm,target,q);
        int time=0;
        while(!q.isEmpty()){
            int n=q.size();
            for(int i=0;i<n;i++){
                Node curr=q.poll();
                burned.add(curr);
                if(curr.left!=null && !burned.contains(curr.left)) q.add(curr.left);
                if(curr.right!=null && !burned.contains(curr.right)) q.add(curr.right);
                if(hm.get(curr)!=null && !burned.contains(hm.get(curr))) q.add(hm.get(curr));
            }
            time++;
        }
        return time-1;
    }
    private static void parents(Node root,Node par,Map<Node,Node> hm,int target,Queue<Node> q){
        if(root==null) return;
        hm.put(root,par);
        if(root.data==target) q.add(root);
        parents(root.left,root,hm,target,q);
        parents(root.right,root,hm,target,q);
    }
}
```

### Complexity

- **Time Complexity:** O(n), where n is the number of nodes in the tree (each node is visited once).
- **Space Complexity:** O(n), for the parent map, queue, and set.

### Summary

- The solution uses BFS to simulate the burning process, spreading fire to all neighbors (left, right, parent) at each second.
- The parent map allows upward traversal in the tree.
- The answer is the number of seconds required to burn the entire tree, starting from the target node.
