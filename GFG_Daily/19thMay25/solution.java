class Solution {
    public ArrayList<Node> findPreSuc(Node root, int key) {
        // code here
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