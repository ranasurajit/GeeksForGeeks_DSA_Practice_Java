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
     * TC: O(N)
     * SC: O(k)
     */
    public ArrayList<Integer> max_of_subarrays(int k, int arr[]) {
        int n = arr.length;
        ArrayList<Integer> windowMax = new ArrayList<Integer>();
        if (n == 0) {
            // if arr is empty
            return windowMax;
        }
        Deque<Integer> deque = new ArrayDeque<Integer>(); // SC: O(k)
        int index = 0;
        // creating window of size 'k'
        while (index < k) { // TC: O(k)
            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[index]) {
                /*
                 * removing the indices from deque whose value in arr 
                 * is less than equals incoming arr index value
                 */
                deque.pollLast();
            }
            deque.offerLast(index);
            index++;
        }
        windowMax.add(arr[deque.peekFirst()]);
        // process for next windows starting from index 1 to n - k
        for (int i = 1; i < n - k + 1; i++) { // TC: O(N - k)
            while (!deque.isEmpty() && deque.peekFirst() <= i - 1) {
                // removing the indices which are not part of current window of size k
                deque.pollFirst();
            }
            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i + k - 1]) {
                /*
                 * removing the indices from deque whose value in arr 
                 * is less than equals incoming arr index value
                 */
                deque.pollLast();
            }
            deque.offerLast(i + k - 1);
            windowMax.add(arr[deque.peekFirst()]);
        }
        return windowMax;
    }
}
