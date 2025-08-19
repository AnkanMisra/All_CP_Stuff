class Solution {

    private void bs(int l, int r, int[] lowestFromRight, int ele, int[] temp) {
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (lowestFromRight[m] < ele) {
                temp[0] = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
    }

    private void findLowestFromRight(int[] lowestFromRight, int[] arr) {
        int n = arr.length;
        lowestFromRight[n - 1] = arr[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            lowestFromRight[i] = Math.min(lowestFromRight[i + 1], arr[i]);
        }
    }

    public ArrayList<Integer> farMin(int[] arr) {
        int n = arr.length;

        int[] lowestFromRight = new int[n];
        findLowestFromRight(lowestFromRight, arr);

        ArrayList<Integer> ans = new ArrayList<>(Collections.nCopies(n, -1));

        for (int i = 0; i < n; i++) {
            int[] temp = {-1};
            bs(i + 1, n - 1, lowestFromRight, arr[i], temp);
            ans.set(i, temp[0]);
        }

        return ans;
    }
}
