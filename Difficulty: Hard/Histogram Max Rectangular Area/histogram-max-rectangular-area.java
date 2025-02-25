//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends

class Solution {
    /**
     * Using Stack Approach
     * 
     * TC: O(5 x N) ~ O(N)
     * SC: O(2 x N) ~ O(N)
     */
    public static int getMaxArea(int arr[]) {
        int n = arr.length;
        int[] pse = prevSmaller(arr, n); // TC: O(2 x N), SC: O(N)
        int[] nse = nextSmaller(arr, n); // TC: O(2 x N), SC: O(N)
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {    // TC: O(N), SC: O(1)
            maxArea = Math.max(maxArea, (nse[i] - pse[i] - 1) * arr[i]);
        }
        return maxArea;
    }
    
    /**
     * TC: O(2 x N)
     * SC: O(N)
     */
    private static int[] prevSmaller(int[] arr, int n) {
        int[] pse = new int[n];
        Stack<Integer> st = new Stack<Integer>(); // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) { // TC: O(N)
                st.pop();
            }
            if (st.isEmpty()) {
                pse[i] = -1;
            } else {
                pse[i] = st.peek();
            }
            st.push(i);
        }
        return pse;
    }
    
    /**
     * TC: O(2 x N)
     * SC: O(N)
     */
    private static int[] nextSmaller(int[] arr, int n) {
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<Integer>(); // SC: O(N)
        for (int i = n - 1; i >= 0; i--) { // TC: O(N)
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) { // TC: O(N)
                st.pop();
            }
            if (st.isEmpty()) {
                nse[i] = n;
            } else {
                nse[i] = st.peek();
            }
            st.push(i);
        }
        return nse;
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

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            Solution obj = new Solution();
            int res = obj.getMaxArea(arr);

            System.out.println(res);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends