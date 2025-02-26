//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String line = sc.nextLine();
            String[] input = line.split(" ");
            int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
            Solution solution = new Solution();
            ArrayList<Integer> result = solution.maxOfMins(arr);
            for (int val : result) {
                System.out.print(val + " ");
            }
            System.out.println();
            System.out.println("~");
        }
        sc.close();
    }
}
// } Driver Code Ends



class Solution {
    /**
     * Using Stack Approach
     * 
     * TC: O(7 x N) ~ O(N)
     * SC: O(3 x N) ~ O(N)
     */
    public ArrayList<Integer> maxOfMins(int[] arr) {
        int n = arr.length;
        int[] pse = previousSmaller(arr, n); // TC: O(2 x N), SC: O(N)
        int[] nse = nextSmaller(arr, n);     // TC: O(2 x N), SC: O(N)
        int[] ans = new int[n];              // SC: O(N)
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {        // TC: O(N)
            // check arr[i] is smaller for which window size
            int windowSize = nse[i] - pse[i] - 1;
            ans[windowSize - 1] = Math.max(arr[i], ans[windowSize - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {   // TC: O(N)
            ans[i] = Math.max(ans[i], ans[i + 1]);
        }
        for (int i = 0; i < n; i++) {        // TC: O(N)
            result.add(ans[i]);
        }
        return result;
    }
    
    /**
     * Using Stack Approach
     *
     * TC: O(2 x N)
     * SC: O(N)
     */
    private int[] previousSmaller(int[] arr, int n) {
        int[] pse = new int[n];
        Stack<Integer> st = new Stack<Integer>(); // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            while (!st.isEmpty() && arr[i] <= arr[st.peek()]) { // TC: O(N)
                st.pop();
            }
            pse[i] = st.isEmpty() ?  -1 : st.peek();
            st.push(i);
        }
        return pse;
    }
    
    /**
     * Using Stack Approach
     *
     * TC: O(2 x N)
     * SC: O(N)
     */
    private int[] nextSmaller(int[] arr, int n) {
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<Integer>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[i] <= arr[st.peek()]) {
                st.pop();
            }
            nse[i] = st.isEmpty() ?  n : st.peek();
            st.push(i);
        }
        return nse;
    }
}
