import java.util.*;

class Solution {
    public int minDifference(String[] arr) {
        int n = arr.length;
        int[] seconds = new int[n];
        for (int i = 0; i < n; i++) {
            seconds[i] = hourToSecond(arr[i]);
        }
        Arrays.sort(seconds);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            minDiff = Math.min(minDiff, seconds[i] - seconds[i - 1]);
        }
        int wrapAroundDiff = 24 * 3600 - seconds[n - 1] + seconds[0];
        minDiff = Math.min(minDiff, wrapAroundDiff);

        return minDiff;
    }
    private int hourToSecond(String time) {
        int h = Integer.parseInt(time.substring(0, 2));
        int m = Integer.parseInt(time.substring(3, 5));
        int s = Integer.parseInt(time.substring(6, 8));
        return h * 3600 + m * 60 + s;
    }
}
