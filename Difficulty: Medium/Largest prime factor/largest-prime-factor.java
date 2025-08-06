// User function Template for Java

class Solution {
    /**
     * Approach II : Using Efficient Prime Factorization Approach
     * 
     * TC: O(Sqrt(N))
     * SC: O(1)
     * 
     * Accepted (1111 / 1111 testcases passed)
     */
    static int largestPrimeFactor(int n) {
        int maxPrime = -1;
        while (n % 2 == 0) {
            n = n / 2;
            maxPrime = 2;
        }
        for (int i = 3; i * i <= n; i++) { // TC: O(Sqrt(N))
            while (n > 0 && (n % i) == 0) {
                n = n / i;
                maxPrime = i;
            }
        }
        if (n > 2) {
            // if still n > 2 then n is itself prime
            maxPrime = n;
        }
        return maxPrime;
    }

    /**
     * Approach I : Using Sieve Of Eratosthenes Approach
     * 
     * TC: O(N x log(log(N))) + O(N) ~ O(N x log(log(N)))
     * SC: O(N)
     * 
     * Time Limit Exceeded (1010 / 1111 testcases passed)
     */
    static int largestPrimeFactorUsingSieveOfEratosthenes(int n) {
        int[] primes = new int[n + 1]; // SC: O(N)
        Arrays.fill(primes, 1);
        primes[0] = 0;
        if (n > 1) {
            primes[1] = 0;
        }
        for (int i = 2; i * i <= n; i++) { // TC: O(N x log(log(N)))
            if (primes[i] == 1) {
                for (int j = i * i; j <= n; j += i) {
                    primes[j] = 0;
                }
            }
        }
        int maxPrimeFactor = 0;
        for (int i = 2; i <= n; i++) { // TC: O(N)
            while (n > 0 && primes[i] == 1 && n % i == 0) {
                maxPrimeFactor = Math.max(maxPrimeFactor, i);
                n = n / i;
            }
        }
        return maxPrimeFactor;
    }
}
