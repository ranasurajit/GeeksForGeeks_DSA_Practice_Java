//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Reading number of test cases (t)
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            // Read the line of integers (prices)
            String input = br.readLine().trim();

            // Split the input line into integers and store in an array
            String[] tokens = input.split(" ");
            int[] arr = new int[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                arr[i] = Integer.parseInt(tokens[i]);
            }

            // Create an instance of the Solution class
            Solution ob = new Solution();

            // Call the missingNumber method
            int res = ob.missingNumber(arr);

            // Print the result
            System.out.println(res);

            // Print the "~" symbol to match the original output
            // System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    // Function to find the smallest positive number missing from the array.
    /**
     * TC: O(2 x N + K) ~ O(N + K)
     * SC: O(K)
     * where K = Max(arr)
     */
    public int missingNumber(int[] arr) {
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (arr[i] >= 0) {
                max = Math.max(max, arr[i]);
            }
        }
        if (max <= 0) {
            return 1;
        }
        int[] numbers = new int[max + 1]; // SC: O(K), where K = Max(arr)
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (arr[i] >= 0) {
                numbers[arr[i]]++;
            }
        }
        for (int i = 1; i < numbers.length; i++) { // TC: O(K), where K = Max(arr)
            if (numbers[i] == 0) {
                return i;
            }
        }
        return max + 1;
    }
}
