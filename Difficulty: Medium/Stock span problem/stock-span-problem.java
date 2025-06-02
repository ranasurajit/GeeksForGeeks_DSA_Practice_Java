//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            ArrayList<Integer> array1 = new ArrayList<Integer>();
            String line = read.readLine();
            String[] tokens = line.split(" ");
            for (String token : tokens) {
                array1.add(Integer.parseInt(token));
            }
            ArrayList<Integer> v = new ArrayList<Integer>();
            int[] arr = new int[array1.size()];
            int idx = 0;
            for (int i : array1) arr[idx++] = i;

            v = new Solution().calculateSpan(arr);

            for (int i = 0; i < v.size(); i++) System.out.print(v.get(i) + " ");

            System.out.println();

            System.out.println("~");
        }
    }
}
// } Driver Code Ends

class Solution {
    /**
     * Approach II : Using Stacks Approach
     * 
     * The problem is similar to finding the index of nearest greater elemnt to left
     * 
     * TC: O(2 x N) ~ O(N)
     * SC: O(2 x N) ~ O(N)
     * 
     * Accepted. Test Cases Passed: (1120 /1120)
     */
    public ArrayList<Integer> calculateSpan(int[] arr) {
        ArrayList<Integer> spanList = new ArrayList<Integer>();
        int n = arr.length;
        int[] result = new int[n]; // SC: O(N)
        // we will be storing { nearest greater element, index } in Stack
        Stack<int[]> st = new Stack<int[]>(); // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (st.isEmpty()) {
                result[i] = -1;
            } else {
                while (!st.isEmpty() && arr[i] >= st.peek()[0]) {
                    // compared with pair's value from stack
                    st.pop();
                }
                if (st.isEmpty()) {
                    result[i] = -1;
                } else {
                    result[i] = st.peek()[1]; // setting index from stack
                }
            }
            st.push(new int[] { arr[i], i });
        }
        for (int i = 0; i < n; i++) { // TC: O(N)
            spanList.add(i - result[i]);
        }
        return spanList;
    }

    /**
     * Approach I : Using Brute-Force Approach
     * 
     * TC: O(N ^ 2 + N) ~ O(N ^ 2)
     * SC: O(N)
     * 
     * Time limit exceeded. Test Cases Passed: (1110 /1120)
     */
    public ArrayList<Integer> calculateSpanBruteForce(int[] arr) {
        ArrayList<Integer> spanList = new ArrayList<Integer>();
        int n = arr.length;
        int[] span = new int[n];           // SC: O(N)
        for (int i = 0; i < n; i++) {      // TC: O(N)
            int count = 0;
            for (int j = i; j >= 0; j--) { // TC: O(N)
                if (arr[j] <= arr[i]) {
                    count++;
                } else {
                    break;
                }
            }
            span[i] = count;
        }
        for (int i = 0; i < n; i++) { // TC: O(N)
            spanList.add(span[i]);
        }
        return spanList;
    }
}
