//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.HashMap;


// } Driver Code Ends
// User function Template for Java

class Solution {
    /**
     * Using Tabulation
     * 
     * TC: O(N x R + 2 x N) ~ O(N x R)
     * SC: O(N x R)
     * 
     * where R = sum of array 'arr' elements
     * 
     * @param arr
     * @return
     */
    public int minDifference(int arr[]) {
        int n = arr.length;
        int range = 0;
        for (int i = 0; i < n; i++) {
            range += arr[i];
        }
        List<Integer> vec = solveTabulation(arr, n, range);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < vec.size(); i++) {
            minDiff = Math.min(minDiff, Math.abs(range - (2 * vec.get(i))));
        }
        return minDiff;
    }

    private List<Integer> solveTabulation(int[] arr, int n, int range) {
        boolean[][] dp = new boolean[n + 1][range + 1];

        // initialization
        Arrays.fill(dp[0], false);
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = true;
        }

        // iterative call
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < range + 1; j++) {
                // convert (n, range) to (i, j)
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        List<Integer> vec = new ArrayList<Integer>();

        for (int i = 0; i < range + 1; i++) {
            if (dp[n][i]) {
                vec.add(i);
            }
        }
        return vec;
    }
}


//{ Driver Code Starts.
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            // int k = Integer.parseInt(br.readLine());
            // Create Solution object and find closest sum
            Solution ob = new Solution();
            int ans = ob.minDifference(arr);

            System.out.print(ans);

            System.out.println(); // New line after printing the results
        }
    }
}

// } Driver Code Ends