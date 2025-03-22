//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int n = s.length;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int[] arr = IntArray.input(br);

            Solution obj = new Solution();
            int res = obj.maxValue(arr);

            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    /**
     * Approach II : Using Memoization Approach
     * 
     * TC: O(3 x N)
     * SC: O(5 x N)
     */
    int maxValue(int[] arr) {
        int n = arr.length;
        int[] optArr1 = new int[n - 1]; // SC: O(N)
        int[] optArr2 = new int[n - 1]; // SC: O(N)
        for (int i = 0; i < n - 1; i++) { // TC: O(N)
            optArr1[i] = arr[i];
            optArr2[i] = arr[i + 1];
        }
        int[] memo1 = new int[n]; // SC: O(N)
        Arrays.fill(memo1, -1);
        int[] memo2 = new int[n]; // SC: O(N)
        Arrays.fill(memo2, -1);
        return Math.max(solveMemoization(n - 1, optArr1, memo1),
            solveMemoization(n - 1, optArr2, memo2));
    }
    
    /**
     * Using Memoization Approach
     * 
     * TC: O(N)
     * SC: O(N)
     */
    private int solveMemoization(int n, int[] arr, int[] memo) {
        // Base Case
        if (n <= 0) {
            return 0;
        }
        // Memoization Check
        if (memo[n] != -1) {
            return memo[n];
        }
        // Recursion Calls
        int option1 = arr[n - 1] + solveMemoization(n - 2, arr, memo);
        int option2 = solveMemoization(n - 1, arr, memo);
        return memo[n] = Math.max(option1, option2);
    }

    /**
     * Approach I : Using Recursion Approach
     * 
     * TC: O(N + 2 ^ (N + 1))
     * SC: O(4 x N)
     */
    int maxValueRecursion(int[] arr) {
        int n = arr.length;
        int[] optArr1 = new int[n - 1]; // SC: O(N)
        int[] optArr2 = new int[n - 1]; // SC: O(N)
        for (int i = 0; i < n - 1; i++) { // TC: O(N)
            optArr1[i] = arr[i];
            optArr2[i] = arr[i + 1];
        }
        return Math.max(solveRecursion(n - 1, optArr1), solveRecursion(n - 1, optArr2));
    }
    
    /**
     * Using Recursion Approach
     * 
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    private int solveRecursion(int n, int[] arr) {
        // Base Case
        if (n <= 0) {
            return 0;
        }
        // Recursion Calls
        int option1 = arr[n - 1] + solveRecursion(n - 2, arr);
        int option2 = solveRecursion(n - 1, arr);
        return Math.max(option1, option2);
    }
}
