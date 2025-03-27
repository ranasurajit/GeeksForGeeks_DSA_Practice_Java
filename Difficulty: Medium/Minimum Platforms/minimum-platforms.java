//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            // First array input (arr)
            String[] str1 = br.readLine().trim().split(
                " "); // Read the first line and split by spaces
            int n = str1.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] =
                    Integer.parseInt(str1[i]); // Convert each element to an integer
            }

            // Second array input (dep)
            String[] str2 = br.readLine().trim().split(
                " "); // Read the second line and split by spaces
            int m = str2.length;
            int[] dep = new int[m];
            for (int i = 0; i < m; i++) {
                dep[i] =
                    Integer.parseInt(str2[i]); // Convert each element to an integer
            }

            Solution obj = new Solution();
            System.out.println(obj.findPlatform(arr, dep));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find the minimum number of platforms required at the
    // railway station such that no train waits.
    /**
     * Approach : Using Sweep Line Algorithm
     *
     * TC: O(3 x N x log(N)) ~ O(N x log(N))
     * SC: O(N)
     */
    static int findPlatform(int arr[], int dep[]) {
        TreeMap<Integer, Integer> timeline = new TreeMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) { // TC: O(N)
            timeline.put(arr[i], timeline.getOrDefault(arr[i], 0) + 1); // TC: O(log(N))
        }
        for (int i = 0; i < dep.length; i++) { // TC: O(N)
            timeline.put(dep[i] + 1, timeline.getOrDefault(dep[i] + 1, 0) - 1); // TC: O(log(N))
        }
        int maxParallelEvents = 0;
        int currentEvents = 0;
        for (Integer key : timeline.keySet()) { // TC: O(N)
            currentEvents += timeline.get(key); // TC: O(log(N))
            maxParallelEvents = Math.max(maxParallelEvents, currentEvents);
        }
        return maxParallelEvents;
    }
}
