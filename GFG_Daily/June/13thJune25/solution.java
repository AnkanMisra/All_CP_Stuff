class Solution {
    public int kokoEat(int[] arr, int k) {

        int n = arr.length;
        int l = 1;
        int r = Arrays.stream(arr).max().getAsInt();
        int result = r;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (isValid(arr, mid, k) <= k) {
                result = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return result;
    }

    private int isValid(int[] arr, int S, int k) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];

            if (S >= num) {
                count++;
                continue;
            }

            while (num > 0) {
                num -= S;
                count++;
            }
        }
        return count;
    }
}
