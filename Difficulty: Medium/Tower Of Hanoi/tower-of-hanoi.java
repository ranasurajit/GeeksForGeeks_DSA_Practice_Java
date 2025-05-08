//{ Driver Code Starts
// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Recursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt(); // total testcases
        while (T-- > 0) {
            Solution obj = new Solution();
            int N;

            // taking input N
            N = sc.nextInt();

            // calling toh() method
            System.out.println(obj.towerOfHanoi(N, 1, 3, 2));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    /**
     * Approach : Using Bit-Manipulation Approach
     * 
     * TC: O(1)
     * SC: O(1)
     */
    public int towerOfHanoi(int n, int from, int to, int aux) {
        return (1 << n) - 1;
    }

    /**
     * Approach : Using Recursion Approach
     * 
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    public int towerOfHanoiRecursion(int n, int from, int to, int aux) {
        int[] count = { 0 };
        solveRecursion(n, from, to, aux, count);
        return count[0];
    }
    
    /**
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    private void solveRecursion(int n, int from, int to, int aux, int[] count) {
        // Base Case
        count[0]++;
        if (n == 1) {
            return;
        }
        /**
         * Hypothesis
         * we will assume recursion will stack (n - 1) disks
         * if moved from source - from to destination - aux
         * using helper - to
         */
        solveRecursion(n - 1, from, aux, to, count);
        // Induction - we will move nth disk from source 'from' to destination 'to'
        /**
         * Hypothesis
         * we will assume recursion will stack (n - 1) disks
         * if moved from source - aux to destination - to
         * using helper - from
         */
        solveRecursion(n - 1, aux, to, from, count);
    }
}
