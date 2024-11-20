//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.HashMap;


// } Driver Code Ends
class Solution {

    // Function to find the first negative integer in every window of size k
    /**
     * TC: O(N)
     * SC: O(N)
     */
    static List<Integer> FirstNegativeInteger(int arr[], int k) {
        int n = arr.length;
        List<Integer> result = new ArrayList<Integer>();
        ArrayDeque<Integer> negDeque = new ArrayDeque<Integer>(); // SC: O(N)
        for (int i = 0, j = 0; j < n; j++) { // TC: O(N)
            if (arr[j] < 0) {
                negDeque.addLast(arr[j]);
            }
            if (j - i + 1 == k) {
                // window size is valid
                if (!negDeque.isEmpty()) {
                    result.add(negDeque.peekFirst());
                } else {
                    result.add(0);
                }
                if (!negDeque.isEmpty() && arr[i] < 0) {
                    negDeque.pollFirst();
                }
                i++;
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