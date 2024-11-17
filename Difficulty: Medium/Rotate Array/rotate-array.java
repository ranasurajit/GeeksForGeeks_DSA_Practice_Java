//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String line = in.readLine();
            String[] tokens = line.split(" ");
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int d = Integer.parseInt(in.readLine().trim()); // rotation count (key)
            int n = array.size();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = array.get(i);

            new Solution().rotateArr(arr, d); // rotating the array
            StringBuilder sb = new StringBuilder();

            // printing the elements of the array
            for (int value : arr) sb.append(value).append(" ");
            out.println(sb.toString().trim());

            out.println("~");
        }
        out.flush();
        out.close();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to rotate an array by d elements in counter-clockwise direction.
    
    /**
     * TC: O(3 x (N / 2)) ~ O(N)
     * SC: O(1)
     */
    static void rotateArr(int arr[], int d) {
        int n = arr.length;
        d = d % n; // rotating array n times returns the original array
        reverse(arr, 0, n - 1);      // TC: O(N / 2)
        // reverse arr from indices 0 to (n - d - 1)
        reverse(arr, 0, n - d - 1);  // TC: O(N / 2)
        // reverse arr from indices (n - d) to (n - 1)
        reverse(arr, n - d, n - 1);  // TC: O(N / 2)
    }
    
    /**
     * TC: O(N / 2)
     * SC: O(1)
     */
    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            // swapping the values at indices start and end
            arr[start] = arr[start] ^ arr[end];
            arr[end] = arr[start] ^ arr[end];
            arr[start] = arr[start] ^ arr[end];
            start++;
            end--;
        }
    }
}
