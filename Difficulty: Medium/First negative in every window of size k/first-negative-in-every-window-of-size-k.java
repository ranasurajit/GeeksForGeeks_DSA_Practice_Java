//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.HashMap;


// } Driver Code Ends
class Solution {

    // Function to find the first negative integer in every window of size k
    /**
     * Took two pointers i and j = 0 and increment j till window size of 'k' is
     * reached
     * 
     * add arr[i] < 0 to a Deque as we can add and remove from both ends of it
     * 
     * Window size: (j - i + 1)
     * 
     * when window size < k, then keep increasing j
     * when window size = k, 
     *  1. if deque is empty add 0 to result
     *  2. if not, add the 1st element of deque to result, check if arr[i] == deque's 
     *     1st element then remove from deque to move the sliding window
     * 
     * maintain this, by incrementing both i an j
     * 
     * TC: O(N)
     * SC: O(N)
     * @param arr
     * @param k
     * @return
     */
    static List<Integer> FirstNegativeInteger(int arr[], int k) {
        int n = arr.length;
        int i = 0; // pointer for start of sliding window
        int j = 0; // pointer for end of sliding window
        List<Integer> result = new ArrayList<Integer>();
        ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
        while (j < n) { // TC: O(N)
            if (arr[j] < 0) {
                deque.addLast(arr[j]);
            }
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                // window size is reached
                if (deque.isEmpty()) {
                    result.add(0);
                } else {
                    // deque has atleast 1 negative number present
                    result.add(deque.peekFirst());
                    if (deque.peekFirst() == arr[i]) {
                        deque.pollFirst();
                    }
                }
                // maintain the sliding window and move it further by 1 element
                i++;
                j++;
            }
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
            List<Integer> ans = ob.FirstNegativeInteger(arr, k);

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
