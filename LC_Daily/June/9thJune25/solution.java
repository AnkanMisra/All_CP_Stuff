class Solution {
    public int findKthNumber(int n, int k) {
        int prefix = 1;

        for (int count = 1; count < k;) {
            int currCount = getCountWithPrefix(prefix, prefix + 1, n);

            if (count + currCount <= k) {
                count += currCount;
                prefix++;
            } else {
                prefix *= 10;
                count++;
            }
        }

        return prefix;
    }

    private int getCountWithPrefix(long startPrefix, long endPrefix, int max) {
        int count = 0;

        while (startPrefix <= max) {
            count += Math.min(max + 1, endPrefix) - startPrefix;
            startPrefix *= 10;
            endPrefix *= 10;
        }

        return count;
    }

}
