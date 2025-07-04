class Solution {
    public char kthCharacter(long k, int[] operations) {
        int i = (int) (Math.ceil(Math.log(k) / Math.log(2))) - 1;
        int count = 0;

        while (k > 1) {
            if (k > (1L << i)) {
                if (operations[i] == 1) {
                    count++;
                }
                k -= (1L << i);
            }
            i--;
        }

        return (char) ('a' + (count % 26));
    }
}
