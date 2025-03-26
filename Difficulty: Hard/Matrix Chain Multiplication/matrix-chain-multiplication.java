//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            System.out.println(new Solution().matrixMultiplication(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    /**
     * Approach II : Using Memoization Approach
     * 
     * TC: O(N x N)
     * SC: O(N x N + N)
     */
    static int matrixMultiplication(int arr[]) {
        int n = arr.length;
        int[][] memo = new int[n + 1][n + 1]; // SC: O(N x N)
        for (int[] mem : memo) {
            Arrays.fill(mem, -1);
        }
        return solveMemoization(1, n - 1, arr, memo);
    }
    
    /**
     * Using Memoization
     * 
     * TC: O(N x N)
     * SC: O(N)
     */
    private static int solveMemoization(int i, int j, int[] arr, int[][] memo) {
        // Base Case
        if (i >= j) {
            return 0;
        }
        // Memoization Check
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        // Recursion Calls
        int minOperation = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int currentOperation = 
                solveMemoization(i, k, arr, memo) + solveMemoization(k + 1, j, arr, memo) +
                arr[i - 1] * arr[k] * arr[j];
            minOperation = Math.min(minOperation, currentOperation);
        }
        return memo[i][j] = minOperation;
    }

    /**
     * Approach I : Using Recursion Approach
     * 
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    static int matrixMultiplicationRecursion(int arr[]) {
        int n = arr.length;
        return solveRecursion(1, n - 1, arr);
    }
    
    /**
     * Using Recursion
     * 
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    private static int solveRecursion(int i, int j, int[] arr) {
        // Base Case
        if (i >= j) {
            return 0;
        }
        // Recursion Calls
        int minOperation = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int currentOperation = 
                solveRecursion(i, k, arr) + solveRecursion(k + 1, j, arr) +
                arr[i - 1] * arr[k] * arr[j];
            minOperation = Math.min(minOperation, currentOperation);
        }
        return minOperation;
    }
}
