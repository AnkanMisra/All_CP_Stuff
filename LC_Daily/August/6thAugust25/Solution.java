class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        if (n == 0) return 0;
        int size = 4 * n;
        long[] seg = new long[size];
        build(seg, 1, 0, n - 1, baskets);

        int unplaced = 0;
        for (int f : fruits) {
            if (seg[1] < f) {
                unplaced++;
                continue;
            }
            int idx = query(seg, 1, 0, n - 1, f);
            update(seg, 1, 0, n - 1, idx, 0); // mark basket as used
        }
        return unplaced;
    }

    private void build(long[] seg, int node, int l, int r, int[] arr) {
        if (l == r) {
            seg[node] = arr[l];
            return;
        }
        int mid = l + (r - l) / 2;
        build(seg, node * 2, l, mid, arr);
        build(seg, node * 2 + 1, mid + 1, r, arr);
        seg[node] = Math.max(seg[node * 2], seg[node * 2 + 1]);
    }

    private int query(long[] seg, int node, int l, int r, int need) {
        if (l == r) return l;
        int mid = l + (r - l) / 2;
        if (seg[node * 2] >= need) {
            return query(seg, node * 2, l, mid, need);
        } else {
            return query(seg, node * 2 + 1, mid + 1, r, need);
        }
    }

    private void update(long[] seg, int node, int l, int r, int idx, long val) {
        if (l == r) {
            seg[node] = val;
            return;
        }
        int mid = l + (r - l) / 2;
        if (idx <= mid) update(seg, node * 2, l, mid, idx, val);
        else update(seg, node * 2 + 1, mid + 1, r, idx, val);
        seg[node] = Math.max(seg[node * 2], seg[node * 2 + 1]);
    }
}
