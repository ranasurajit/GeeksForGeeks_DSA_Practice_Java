class Solution {
    /**
     * Approach III : Using Hashing + Math + Mobius Function Approach
     * 
     * TC: O(N) + O(N) + O(Max(arr) × log(Max(arr))) + 
     *     O(Max(arr) × log(log(Max(arr)))) + O(Max(arr)) 
     *   ~ O(N + Max(arr) × log(Max(arr)) + Max(arr) × log(log(Max(arr))))
     * 
     * SC: O(3 x Max(arr)) ~ O(Max(arr))
     * 
     * Accepted (1120 / 1120 testcases passed)
     */
    int cntCoprime(int[] arr) {
        int n = arr.length;
        int MAX = 0; // as 1 ≤ arr[i] ≤ 10 ^ 4
        for (int i = 0; i < n; i++) {    // TC: O(N)
            MAX = Math.max(MAX, arr[i]);
        }
        int[] freq = new int[MAX + 1];        // SC: O(Max(arr))
        computeFreq(arr, freq); // TC: O(N)
        int[] divCounts = 
            computeDivisorsCount(MAX, freq); // TC: O(Max(arr) × log(Max(arr))), SC: O(Max(arr))
        int[] mobius = computeMobius(MAX); // TC: O(Max(arr) × log(log(Max(arr)))), SC: O(Max(arr))
        int result = 0;
        for (int i = 1; i <= MAX; i++) { // TC: O(Max(arr))
            if (mobius[i] == 0 || divCounts[i] < 2) {
                continue;
            }
            int pairs = (divCounts[i] * (divCounts[i] - 1)) / 2;
            result += mobius[i] * pairs;
        }
        return result;
    }

    /**
     * Compute Mobius function
     * 
     * TC: O(Max(arr) × log(log(Max(arr))))
     * SC: O(Max(arr))
     */
    private int[] computeMobius(int n) {
        int[] mobius = new int[n + 1];
        Arrays.fill(mobius, 1);

        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);

        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i; j <= n; j += i) {
                    mobius[j] *= -1;
                    isPrime[j] = false;
                }
                for (int j = i * i; j <= n; j += i * i) {
                    mobius[j] = 0;
                }
            }
        }

        mobius[0] = 0;
        return mobius;
    }
    
    /**
     * Compute number of elements divisible by each div
     * 
     * TC: O(Max(arr) × log(Max(arr)))
     * SC: O(Max(arr))
     */
    private int[] computeDivisorsCount(int MAX, int[] freq) {
        int[] divisibleCount = new int[MAX + 1];
        for (int d = 1; d <= MAX; d++) {
            for (int multiple = d; multiple <= MAX; multiple += d) {
                divisibleCount[d] += freq[multiple];
            }
        }
        return divisibleCount;
    }

    /**
     * Computing frequency of each numbers
     * 
     * TC: O(N)
     * SC: O(1)
     */
    private void computeFreq(int[] arr, int[] freq) {
        for (int elem : arr) {
            freq[elem]++;
        }
    }

    /**
     * Approach II : Using Sieve of Eratosthenes + Euclid's GCD Approach
     * 
     * TC: O(N) + O(N) + O(Max(arr) × log(log(Max(arr)))) + O(Max(arr) x Max(arr))
     * SC: O(Max(arr))
     * 
     * Time Limit Exceeded (1010 / 1120 testcases passed)
     */
    int cntCoprimeSieve(int[] arr) {
        int n = arr.length;
        int MAX = 0; // as 1 ≤ arr[i] ≤ 10 ^ 4
        for (int i = 0; i < n; i++) {    // TC: O(N)
            MAX = Math.max(MAX, arr[i]);
        }
        int[] freq = new int[MAX + 1];   // SC: O(Max(arr))
        int[] phi = new int[MAX + 1];    // SC: O(Max(arr))
        for (int i = 0; i < n; i++) {    // TC: O(N)
            freq[arr[i]]++;
        }
        computeTotients(phi, MAX);       // TC: O(Max(arr) × log(log(Max(arr))))
        long total = 0L;
        for (int i = 1; i <= MAX; i++) { // TC: O(Max(arr))
            if (freq[i] == 0) {
                continue;
            }
            int coprimeCount = 0;
            for (int j = 1; j <= MAX; j++) { // TC: O(Max(arr))
                if (freq[j] > 0 && gcd(i, j) == 1) {
                    coprimeCount += freq[j];
                }
            }
            total += (long) coprimeCount * freq[i];
        }
        return (int) (total / 2);
    }

    /**
     * Computing Totients Using Sieve of Eratosthenes
     * 
     * TC: O(Max(arr) × log(log(Max(arr))))
     * SC: O(1)
     */
    private void computeTotients(int[] phi, int MAX) {
        for (int i = 0; i <= MAX; i++) {
            phi[i] = i;
        }
        for (int i = 2; i <= MAX; i++) {
            if (phi[i] == i) { // untouched and i is prime
                for (int j = i * i; j <= MAX; j += i) {
                    phi[j] = phi[j] - (phi[j] / i);
                }
            }
        }
    }

    /**
     * Approach I : Using Simulation + Euclid's GCD Approach
     * 
     * TC: O(N x N x log(Min(a, b)))
     * SC: O(log(Min(a, b)))
     * 
     * Time Limit Exceeded (1010 / 1120 testcases passed)
     */
    int cntCoprimeZUsingEuclidsGCD(int[] arr) {
        int n = arr.length;
        int count = 0;
        for (int i = 0; i < n - 1; i++) { // TC: O(N)
            for (int j = i + 1; j < n; j++) { // TC: O(N)
                if (gcd(arr[i], arr[j]) == 1) { // TC: O(log(Min(a, b))), SC: O(log(Min(a, b)))
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Using Euclid's GCD Approach
     * 
     * TC: O(log(Min(a, b)))
     * SC: O(log(Min(a, b)))
     */
    private int gcd(int a, int b) {
        if (b > a) {
            return gcd(b, a);
        }
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
