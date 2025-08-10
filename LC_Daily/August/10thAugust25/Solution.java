class Solution {
    public boolean reorderedPowerOf2(int n) {

        int count = count(n);

        for(int i = 0; i < 31; i++){

            if(count == count(1 << i)) return true;
        }
        return false;
    }

    private int count(int n) {

        int cnt = 0;
        while (n > 0) {
            cnt += (int) Math.pow(10, n % 10);
            n /= 10;
        }
        return cnt;
    }
}
