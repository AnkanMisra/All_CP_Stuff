/* class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
} */
class Solution {

    int max = Integer.MIN_VALUE;

    int maxPathSum(Node root) {
        int val = helper(root);
        if (root.left == null || root.right == null)
            return Math.max(max, val);

        return max;
    }

    public int helper(Node root) {
        if(root==null) return 0;

        if(root.left==null && root.right==null) return root.data;

        int left = helper(root.left);
        int right = helper(root.right);

        if (root.left==null) return right + root.data;
        if (root.right==null) return left + root.data;

        max = Math.max(max, root.data + left + right);

        return root.data + Math.max(left, right);
    }
}
