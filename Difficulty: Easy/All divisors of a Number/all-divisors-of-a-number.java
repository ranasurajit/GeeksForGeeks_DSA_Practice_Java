class Solution {
    /**
     * Approach II : Using Optimal (Math + Simulation) Approach
     * 
     * TC: O(Sqrt(N)) + O(Sqrt(N)) ~ O(Sqrt(N))
     * SC: O(1)
     * 
     * Accepted (1120 /1120 testcases passed)
     */
    public static void print_divisors(int n) {
        Stack<Integer> st = new Stack<Integer>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
                if ((n / i) != i) {
                    st.push(n / i);
                }
            }
        }
        while (!st.isEmpty()) { // TC: O(Sqrt(N))
            System.out.print(st.pop() + " ");
        }
    }

    /**
     * Approach I : Using Brute-Force (Simulation) Approach
     * 
     * TC: O(N)
     * SC: O(1)
     * 
     * Time Limit Exceeded (1110 /1120 testcases passed)
     */
    public static void print_divisorsBruteForce(int n) {
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
            }
        }
    }
}
