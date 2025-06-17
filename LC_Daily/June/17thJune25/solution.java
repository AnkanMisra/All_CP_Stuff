class Solution {

    static long MOD = (long)(1e9)+7;
    static long factorial[];
    static long inverseFactorial[];

    static long power(long base, long exponent) {
        long result = 1L;
        while (exponent > 0) {
            if ((exponent & 1) == 1) {
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            exponent >>= 1;
        }
        return result;
    }

    static long computeNCR(int total, int choose){
        if(choose < 0 || choose > total) return 0;

        long num = factorial[total];
        long denom1 = inverseFactorial[choose];
        long denom2 = inverseFactorial[total - choose];
        return ((num * denom1) % MOD * denom2) % MOD;
    }

    static void initializeFactorials(int size){
        factorial = new long[size + 1];
        inverseFactorial = new long[size + 1];

        factorial[0] = 1;
        for(int i = 1; i <= size; i++){
            factorial[i] = (factorial[i - 1] * i) % MOD;
        }

        inverseFactorial[size] = power(factorial[size], MOD - 2) % MOD;
        for(int i = size - 1; i >= 0; i--){
            inverseFactorial[i] = (inverseFactorial[i + 1] * (i + 1)) % MOD;
        }
    }

    public int countGoodArrays(int len, int maxVal, int fixed) {
        initializeFactorials(len);
        long remaining = len - fixed;
        long combinations = computeNCR(len - 1, fixed);
        long powerTerm = power(maxVal - 1, remaining - 1);
        long result = (powerTerm * maxVal) % MOD;
        result = (result * combinations) % MOD;
        return (int)result;
    }
}
