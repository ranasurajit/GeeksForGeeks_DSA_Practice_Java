//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java
class Solution {
    // Non-static method, so you need to call it on an instance of the class
    /**
     * TC: O(N x log(K) + K x log(K))
     * SC: O(K)
     */
    public void nearlySorted(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(); // SC: O(K)
        for (int i = 0; i <= k; i++) { // TC: O(K)
            pq.offer(arr[i]); // TC: O(log(K))
        }
        int j = 0; // pointer for in place swap
        for (int i = k + 1; i < arr.length; i++) { // TC: O(N)
            arr[j] = pq.poll(); // TC: O(log(K))
            pq.offer(arr[i]);
            j++;
        }
        while (!pq.isEmpty()) { // if PriorityQueue has few elements left
            arr[j] = pq.poll();
            j++;
        }
    }
}


//{ Driver Code Starts.
class GFG {
    public static void main(String[] args) throws IOException {
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
            int k = Integer.parseInt(br.readLine());
            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            // Create an instance of the Solution class
            Solution obj = new Solution();
            // Call nearlySorted on the instance
            obj.nearlySorted(arr, k);

            // Print the sorted array
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();

            // System.out.println("~");
        }
    }
}

// } Driver Code Ends