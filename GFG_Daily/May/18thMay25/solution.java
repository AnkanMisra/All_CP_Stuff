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