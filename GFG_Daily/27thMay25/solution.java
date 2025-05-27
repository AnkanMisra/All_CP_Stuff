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
