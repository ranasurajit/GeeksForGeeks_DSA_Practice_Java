//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read the number of test cases (t)
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine().trim());
            String input = br.readLine().trim();

            // Split the input line into integers and store them in the array
            String[] tokens = input.split(" ");
            int[] arr = new int[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                arr[i] = Integer.parseInt(tokens[i]);
            }

            // Create an instance of the Solution class
            Solution ob = new Solution();

            // Call the getMinDiff method
            int res = ob.getMinDiff(k, arr);

            // Print the result
            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    /**
     * TC: O(N + N x log(N)) ~ O(N x log(N))
     * SC: O(1)
     */
    public int getMinDiff(int k, int[] arr) {
        int n = arr.length;
        Arrays.sort(arr); // TC: O(N x log(N))
        int shortest = arr[0];
        int longest = arr[n - 1];
        int minDiff = longest - shortest;
        for (int i = 1; i < n; i++) { // TC: O(N)
            /*
             * at any index i, smallest height after operation
             * is min(current height - k, arr[0] + k)
             */
            shortest = Math.min(arr[0] + k, arr[i] - k);
            /*
             * at any index i, longest height after operation
             * is max((current - 1) height + k, arr[n - 1] - k)
             */
            longest = Math.max(arr[n - 1] - k, arr[i - 1] + k);
            // track the minimum difference found in each iteration
            minDiff = Math.min(minDiff, longest - shortest);
        }
        return minDiff;
    }
}
