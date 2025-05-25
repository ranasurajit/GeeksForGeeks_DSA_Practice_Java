class Solution {
    /**
     * Approach II : Using Hashing and Simulation Approach
     * 
     * TC: O(N ^ 2 + N)
     * SC: O(N)
     */
    boolean pythagoreanTriplet(int[] arr) {
        int n = arr.length;
        Set<Double> hs = new HashSet<Double>(); // SC: O(N)
        for (int num : arr) {                   // TC: O(N)
            hs.add((double) num * (double) num);
        }
        for (int i = 0; i < n; i++) {           // TC: O(N)
            double a = (double) arr[i];
            for (int j = i + 1; j < n; j++) {   // TC: O(N)
                double b = (double) arr[j];
                double summation = a * a + b * b;
                if (hs.contains(summation)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Approach I : Using Two Pointers and Sorting Approach
     * 
     * TC: O(N ^ 2 + N x log(N))
     * SC: O(1)
     */
    boolean pythagoreanTripletApproachI(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);                  // TC: O(N x log(N))
        for (int r = n - 1; r >= 2; r--) { // TC: O(N)
            int p = 0;
            int q = r - 1;
            while (p < q) {                // TC: O(N)
                double summation = arr[p] * arr[p] + arr[q] * arr[q];
                double result = arr[r] * arr[r];
                if (summation == result) {
                    return true;
                } else if (p < q && summation < result) {
                    p++;
                } else if (p < q && summation > result) {
                    q--;
                }
            }
        }
        return false;
    }
}
