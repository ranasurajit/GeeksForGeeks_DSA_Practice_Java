//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.HashMap;


// } Driver Code Ends


class Solution {
    /**
     * Using Sliding Window (Variable) Technique and ArrayDeque Approach
     * 
     * TC: O(N + K)
     * SC: O(N)
     */
    public ArrayList<Integer> longestSubarray(int[] arr, int x) {
        int n = arr.length;
        int i = 0; // start pointer of sliding window
        int j = 0; // end pointer of sliding window
        ArrayDeque<Integer> minDeque = new ArrayDeque<Integer>(); // SC: O(N / 2)
        ArrayDeque<Integer> maxDeque = new ArrayDeque<Integer>(); // SC: O(N / 2)
        int maxLength = 0;
        int startIndex = 0;
        int endIndex = 0;
        while (j < n) { // TC: O(N)
            while (!minDeque.isEmpty() && arr[minDeque.peekLast()] >= arr[j]) {
                minDeque.pollLast();
            }
            minDeque.addLast(j);
            while (!maxDeque.isEmpty() && arr[maxDeque.peekLast()] <= arr[j]) {
                maxDeque.pollLast();
            }
            maxDeque.addLast(j);
            while (arr[maxDeque.peekFirst()] - arr[minDeque.peekFirst()] > x) {
                // remove all calculations from ith index
                if (!minDeque.isEmpty() && minDeque.peekFirst() == i) {
                    minDeque.pollFirst();
                }
                if (!maxDeque.isEmpty() && maxDeque.peekFirst() == i) {
                    maxDeque.pollFirst();
                }
                // slide the index
                i++;
            }
            if (arr[maxDeque.peekFirst()] - arr[minDeque.peekFirst()] <= x &&
                maxLength < (j - i + 1)) {
                maxLength = j - i + 1;
                startIndex = i;
                endIndex = j;
            }
            j++;
        }
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (i = startIndex; i <= endIndex; i++) { // TC: O(K = endIndex - startIndex + 1)
            result.add(arr[i]);
        }
        return result;
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

            int k = Integer.parseInt(br.readLine());
            // Create Solution object and find closest sum
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.longestSubarray(arr, k);

            // Print the result as a space-separated string
            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println(); // New line after printing the results
            System.out.println("~");
        }
    }
}

// } Driver Code Ends