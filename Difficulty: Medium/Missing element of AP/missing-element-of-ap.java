//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine().trim());

        Solution solution = new Solution();
        while (t-- > 0) {
            String input = reader.readLine().trim();
            String[] parts = input.split("\\s+");
            int[] arr = Arrays.stream(parts).mapToInt(Integer::parseInt).toArray();

            System.out.println(solution.findMissing(arr));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    /**
     * Approach II : Using Simulation + Math Approach
     *
     * TC: O(N)
     * SC: O(1)
     */
    public int findMissing(int[] arr) {
        int n = arr.length;
        int extremeDiffs = arr[n - 1] - arr[0];
        int expectedDiff = (extremeDiffs & 1) == 0 ? extremeDiffs / n : extremeDiffs / (n - 1);
        for (int i = 1; i < n; i++) { // TC: O(N)
            int currentDiff = arr[i] - arr[i - 1];
            if (currentDiff != expectedDiff) {
                return arr[i] - expectedDiff;
            }
        }
        return arr[n - 1] + expectedDiff;
    }

    /**
     * Approach I : Using Simulation Approach
     *
     * TC: O(N)
     * SC: O(1)
     */
    public int findMissingApproachI(int[] arr) {
        int n = arr.length;
        int diff = 0;
        int maxDiff = 0;
        int index = 0;
        for (int i = 0; i < n - 1; i++) { // TC: O(N)
            diff = arr[i + 1] - arr[i];
            if (maxDiff < diff) {
                maxDiff = diff;
                index = i;
            }
        }
        return index == 0 ? 
            arr[n - 1] + maxDiff : 
            arr[index] + (arr[index + 1] - arr[index]) / 2;
    }
}
