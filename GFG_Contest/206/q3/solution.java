class Solution {
    public boolean makeZero(int arr[]) {
        int b = arr.length;
        int c = 0;
        for (int d : arr) {
            c ^= d;
        }
        if (c != 0 && (b % 2 == 1)) {
            return true;
        } else {
            return false;
        }
    }
}