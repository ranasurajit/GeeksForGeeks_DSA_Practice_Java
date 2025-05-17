//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read number of test cases
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            // Read the array line and convert to int[]
            String input = br.readLine().trim();
            String[] tokens = input.split("\\s+");
            int n = tokens.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(tokens[i]);
            }

            // Read a, b, c from separate lines
            int a = Integer.parseInt(br.readLine().trim());
            int b = Integer.parseInt(br.readLine().trim());
            int c = Integer.parseInt(br.readLine().trim());

            // Call the solution method
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.sortArray(arr, a, b, c);

            // Output the result
            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    /**
     * Approach II : Using Two Pointers Approach
     * 
     * TC: O(2 x N) ~ O(N)
     * SC: O(1)
     * 
     * Accepted (1120 /1120 testcases passed)
     * 
     * @param arr
     * @param A
     * @param B
     * @param C
     * @return
     */
    public ArrayList<Integer> sortArray(int[] arr, int A, int B, int C) {
        int n = arr.length;
        ArrayList<Integer> sorted = new ArrayList<>();
        for (int i = 0; i < n; i++) { // TC: O(N)
            sorted.add(0);
        }
        int index = A >= 0 ? n - 1 : 0;
        int i = 0; // left pointer at array 'arr'
        int j = n - 1; // right pointer at array 'arr'
        while (i <= j) { // TC: O(N)
            int leftEq = computeEquation(arr[i], A, B, C);
            int rightEq = computeEquation(arr[j], A, B, C);
            if (A >= 0) {
                if (leftEq >= rightEq) {
                    sorted.set(index, leftEq);
                    i++;
                    index--;
                } else {
                    sorted.set(index, rightEq);
                    j--;
                    index--;
                }
            } else {
                if (leftEq <= rightEq) {
                    sorted.set(index, leftEq);
                    i++;
                    index++;
                } else {
                    sorted.set(index, rightEq);
                    j--;
                    index++;
                }
            }
        }
        return sorted;
    }

    /**
     * Approach I : Using Brute-Force Approach
     * 
     * TC: O(N + N x log(N)) ~ O(N x log(N))
     * SC: O(1)
     * 
     * Time limit exceeded (1110 /1120 testcases passed)
     * 
     * @param arr
     * @param A
     * @param B
     * @param C
     * @return
     */
    public ArrayList<Integer> sortArrayBruteForce(int[] arr, int A, int B, int C) {
        int n = arr.length;
        ArrayList<Integer> sorted = new ArrayList<>();
        for (int i = 0; i < n; i++) { // TC: O(N)
            sorted.add(computeEquation(arr[i], A, B, C));
        }
        Collections.sort(sorted); // TC: O(N x log(N))
        return sorted;
    }
    
    /**
     * TC: O(1)
     * SC: O(1)
     * 
     * @param x
     * @param a
     * @param b
     * @param c
     * @return
     */
    private int computeEquation(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }
}
