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
     */
    public ArrayList<Integer> sortArray(int[] arr, int A, int B, int C) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) { // TC: O(N)
            result.add(0);
        }
        int left = 0;
        int right = n - 1;
        int index = A >= 0 ? n - 1 : 0;
        while (left <= right) { // TC: O(N)
            int resultLeft = computeEquation(arr[left], A, B, C);
            int resultRight = computeEquation(arr[right], A, B, C);
            if (A >= 0) {
                if (resultLeft >= resultRight) {
                    result.set(index, resultLeft);
                    left++;
                    index--;
                } else {
                    result.set(index, resultRight);
                    right--;
                    index--;
                }
            } else {
                if (resultLeft <= resultRight) {
                    result.set(index, resultLeft);
                    left++;
                    index++;
                } else {
                    result.set(index, resultRight);
                    right--;
                    index++;
                }
            }
        }
        return result;
    }

    /**
     * Approach I : Using Brute-Force Approach
     * 
     * TC: O(N + N x log(N)) ~ O(N x log(N))
     * SC: O(1)
     */
    public ArrayList<Integer> sortArrayBruteForce(int[] arr, int A, int B, int C) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) { // TC: O(N)
            result.add(computeEquation(arr[i], A, B, C));
        }
        Collections.sort(result); // TC: O(N x log(N))
        return result;
    }
    
    /**
     * Using Math
     * 
     * TC: O(1)
     * SC: O(1)
     */
    private int computeEquation(int x, int A, int B, int C) {
        return (A * x * x) + (B * x) + C;
    }
}
