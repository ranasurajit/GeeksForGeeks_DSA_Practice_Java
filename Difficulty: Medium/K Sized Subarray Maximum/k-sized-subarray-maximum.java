//{ Driver Code Starts
// Initial template for JAVA

import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        // taking input using class Scanner
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            // taking total number of elements
            int k = Integer.parseInt(br.readLine());
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
            ArrayList<Integer> res = new Solution().max_of_subarrays(k, arr);

            // printing the elements of the ArrayList
            for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function template for JAVA

class Solution {
    // Function to find maximum of each subarray of size k.
    /**
     * Took two pointers i and j = 0 and increment j till window size of 'k' is
     * reached
     * 
     * add index j to a Deque (as we can add and remove from both ends of it)
     * remove all elements from beginning of a deque < arr[j]
     * 
     * Note: we will be storing indices in Deque
     * 
     * Window size: (j - i + 1)
     * 
     * when window size < k, then keep increasing j
     * when window size = k,
     * 1. add 1st element from beginning of deque to the resultant array/list
     * 2. remove 1st element from beginning of deque if it = i
     * 
     * maintain the sliding window size of k, by incrementing both i an j
     * 
     * TC: O(N)
     * SC: O(K)
     * 
     * @param arr
     * @param k
     * @return
     */
    public ArrayList<Integer> max_of_subarrays(int arr[], int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int n = arr.length;
        int i = 0; // pointer for start of sliding window
        int j = 0; // pointer for end of sliding window
        ArrayDeque<Integer> deque = new ArrayDeque<Integer>(); // O(K)
        while (j < n) { // TC: O(N)
            while (!deque.isEmpty() && arr[deque.peekLast()] < arr[j]) {
                deque.pollLast();
            }
            deque.addLast(j);
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                result.add(arr[deque.peekFirst()]);
                if (i == deque.peekFirst()) {
                    deque.pollFirst();
                }
                // slide the window
                i++;
                j++;
            }
        }
        return result;
    }
}
