class Solution {
    /**
     * Approach II : Using Math + Sieve of Eratosthenes Approach
     * 
     * TC: O(N x log(log(N)) + O(L) + O(L x L) 
     * - getPrimes(n) using Sieve: O(n × log log n)
     *   - Case 1 loop: O(L)
     *   - Case 2 nested loop: O(L²), but limited by p^2 × q^2 ≤ n and breaks early.
     * 
     * SC: O(N)
     * - Sieve array and list of primes
     * 
     * where L = number of prime numbers within N (L² << N × log(log(N)))
     * 
     * Accepted (1111 / 1111 testcases passed)
     */
    public static int countNumbers(int n) {
        int count = 0;
        ArrayList<Integer> primes = getPrimes((int) Math.sqrt(n)); // TC: O(N x log(log(N))), SC: O(N)
        /**
         * for a number to have exactly 9 divisors, we need to have 
         * two conditions for number to be expressed as:
         * 
         * 1. p ^ 8 where p = prime number so divisors = (1 + 8) = 9
         * 2. p ^ 2 x q ^ 2 where p and q are both prime numbers so divisors = (2 + 1) x (2 + 1) = 9
         */
        // Case 1: find p such that p ^ 8 <= n
        for (int i = 0; i < primes.size(); i++) { // TC: O(L)
            if (Math.pow(primes.get(i), 8) <= n) {
                count++;
            }
        }
        // Case 2: find p and q such that p ^ 2 + q ^ 2
        for (int i = 0; i < primes.size() - 1; i++) { // TC: O(L)
            long p = primes.get(i) * primes.get(i);
            if (p > n) {
                break;
            }
            for (int j = i + 1; j < primes.size(); j++) { // TC: O(L)
                long q = primes.get(j) * primes.get(j);
                if (p * q <= n) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }

    /**
     * Using Sieve of Eratosthenes Approach
     * 
     * TC: O(N x log(log(N)))
     * SC: O(N)
     */
    private static ArrayList<Integer> getPrimes(int n) {
        ArrayList<Integer> primes = new ArrayList<Integer>();
        // pre-computing all prime numbers till n
        int[] sieve = new int[n + 1];
        Arrays.fill(sieve, 1);
        // 0 and 1 are non-prime numbers
        sieve[0] = 0;
        sieve[1] = 0;
        for (int i = 2; i * i <= n; i++) {
            if (sieve[i] == 1) {
                for (int j = i * i; j <= n; j+=i) {
                    sieve[j] = 0;
                }
            }
        }
        for (int i = 2; i < n + 1; i++) {
            if (sieve[i] == 1) {
                primes.add(i);
            }
        }
        return primes;
    }

    /**
     * Approach I : Using Mathematical Simulation
     * 
     * TC: O(N x Sqrt(N))
     * SC: O(1)
     * 
     * Time Limit Exceeded (1010 / 1111 testcases passed)
     */
    public static int countNumbersUsingSimulation(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) { // TC: O(N)
            int countDivisors = 0;
            for (int j = 1; j * j <= i; j++) { // O(Sqrt(N))
                if (i % j == 0) {
                    countDivisors++;
                    if (j != i / j) {
                        countDivisors++;
                    }
                }
            }
            if (countDivisors == 9) {
                count++;
            }
        }
        return count;
    }
}
