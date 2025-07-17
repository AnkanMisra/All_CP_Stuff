class Solution {

    private int getExponentOfPrimeInFactorial(int n, int p) {
        int count = 0;
        long powerOfP = p;

        while (powerOfP <= n) {
            count += n / powerOfP;
            if (powerOfP > n / p) {
                break;
            }
            powerOfP *= p;
        }
        return count;
    }

    public int maxKPower(int n, int k) {
        Map<Integer, Integer> primeFactorsK = new HashMap<>();
        int tempK = k;

        for (int i = 2; i * i <= tempK; i++) {
            while (tempK % i == 0) {
                primeFactorsK.put(i, primeFactorsK.getOrDefault(i, 0) + 1);
                tempK /= i;
            }
        }
        
        if (tempK > 1) {
            primeFactorsK.put(tempK, primeFactorsK.getOrDefault(tempK, 0) + 1);
        }

        int minX = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Integer> entry : primeFactorsK.entrySet()) {
            int prime = entry.getKey();
            int exponentInK = entry.getValue();

            int exponentInNFactorial = getExponentOfPrimeInFactorial(n, prime);

            if (exponentInNFactorial == 0) {
                 return 0;
            }

            int currentX = exponentInNFactorial / exponentInK;
            minX = Math.min(minX, currentX);
        }

        return minX;
    }
}