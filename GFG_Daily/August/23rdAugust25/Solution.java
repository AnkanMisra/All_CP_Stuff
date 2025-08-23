class Solution {
    public int findPages(int[] arr, int k) {
        int n = arr.length;

        if (k > n) {
            return -1;
        }

        int low = getMax(arr);
        int high = getSum(arr);
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canAllocate(arr, k, mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }

    private boolean canAllocate(int[] arr, int k, int maxPages) {
        int students = 1;
        int currentPages = 0;

        for (int pages : arr) {
            if (currentPages + pages <= maxPages) {
                currentPages += pages;
            } else {
                students++;
                currentPages = pages;

                if (students > k) {
                    return false;
                }
            }
        }

        return true;
    }

    private int getMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            max = Math.max(max, num);
        }
        return max;
    }

    private int getSum(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }
}
