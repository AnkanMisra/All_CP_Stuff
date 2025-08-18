class Solution {
    public long minimumPerimeter(long neededApples) {
        long left = 1, right = 1000000;
        while (left < right) {
            long mid = (left + right) >> 1;
            if (applesInside(mid) >= neededApples) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left * 8;
    }

    private long applesInside(long n) {
        return 2L * (2L * n + 1) * n * (n + 1);
    }
}
