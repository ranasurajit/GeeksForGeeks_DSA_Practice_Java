// User function Template for Java

class Solution {
    private static int num;
    private static int[] primes;

    /**
     * Using Sieve Of Eratosthenes Approach
     * 
     * TC: O(N x log(log(N)))
     * SC: O(N)
     */
    static void sieve() {
        primes = new int[num + 1];
        Arrays.fill(primes, 1);
        primes[0] = 0;
        if (num > 1) {
            primes[1] = 0;
        }
        for (int i = 2; i * i <= num; i++) {
            for (int j = i * i; j <= num; j += i) {
                primes[j] = 0;
            }
        }
    }

    /**
     * Approach : Using Sieve Of Eratosthenes Approach : 
     * 
     * TC: O(N x log(log(N))) + O(N) ~ O(N x log(log(N)))
     * SC: O(N)
     */
    static List<Integer> findPrimeFactors(int N) {
        num = N;
        sieve(); // TC: O(N x log(log(N))), SC: O(N)
        List<Integer> factors = new ArrayList<Integer>();
        for (int i = 2; i <= N; i++) { // TC: O(N)
            while (N > 0 && primes[i] == 1 && (N % i) == 0) {
                factors.add(i);
                N = N / i;
            }
        }
        return factors;
    }
}
