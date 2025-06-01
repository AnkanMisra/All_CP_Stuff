class Solution {
    class Pair {
        int v;
        int d;

        Pair(int d, int v) {
            this.v = v;
            this.d = d;
        }
    }

    public int sumOfLongRootToLeafPath(Node root) {
        return f(root, 0).v;
    }

    Pair f(Node root, int level) {
        if (root == null) {
            return new Pair(level, 0);
        }
        Pair left = f(root.left, level + 1);
        Pair right = f(root.right, level + 1);
        if (left.d > right.d) {
            left.v += root.data;
            return left;
        } else if (left.d < right.d) {
            right.v += root.data;
            return right;
        } else {
            return new Pair(left.d, Math.max(left.v, right.v) + root.data);
        }

    }
}
