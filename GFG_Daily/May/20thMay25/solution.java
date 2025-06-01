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