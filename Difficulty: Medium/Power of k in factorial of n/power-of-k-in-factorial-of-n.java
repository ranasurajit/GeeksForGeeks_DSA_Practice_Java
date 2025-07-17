class Solution {
    /**
     * Approach : Using Math Approach
     * 
     * TC: O(Sqrt(K)) + O(Sqrt(K)) x O(log(N) Base P) ~ O(Sqrt(K) x log(N) Base P)
     * SC: O(Sqrt(K))
     */
    public int maxKPower(int n, int k) {
        Map<Integer, Integer> primes = getPrimeFactorsOfK(k); // TC: O(Sqrt(K)), SC: O(Sqrt(K))
        int result = Integer.MAX_VALUE;
        for (Integer key : primes.keySet()) { // TC: O(Sqrt(K))
            int primeFactor = key;
            int freq = primes.get(key);
            int countPrime = getCountInFactorial(n, primeFactor); // TC: O(log(N) Base P)
            result = Math.min(result, countPrime / freq);
        }
        return result;
    }

    /**
     * TC: O(log(N) Base P)
     * SC: O(1)
     */
    private int getCountInFactorial(int n, int p) {
        int count = 0;
        while (n > 0) {
            n = n / p;
            count += n;
        }
        return count;
    }

    /**
     * Using Hashing Approach
     * 
     * TC: O(Sqrt(K))
     * SC: O(Sqrt(K))
     */
    private Map<Integer, Integer> getPrimeFactorsOfK(int k) {
        Map<Integer, Integer> factors = new HashMap<Integer, Integer>(); // SC: O(Sqrt(K))
        for (int i = 2; i * i <= k; i++) { // TC: O(Sqrt(K))
            while (k % i == 0) {
                factors.put(i, factors.getOrDefault(i, 0) + 1);
                k = k / i;
            }
        }
        if (k > 1) {
            factors.put(k, factors.getOrDefault(k, 0) + 1);
        }
        return factors;
    }
}
