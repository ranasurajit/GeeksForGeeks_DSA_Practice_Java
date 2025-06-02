//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // Number of test cases
        for (int g = 0; g < t; g++) {
            String[] str =
                (br.readLine()).trim().split(" "); // Reading input as a string array
            int arr[] = new int[str.length]; // Creating integer array from the input
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }

            // Getting the result from the Solution class
            ArrayList<Integer> result = new Solution().nextLargerElement(arr);

            // Printing the result in the required format
            if (result.isEmpty()) {
                System.out.println("[]");
            } else {
                for (int i = 0; i < result.size(); i++) {
                    if (i != 0) System.out.print(" ");
                    System.out.print(result.get(i));
                }
                System.out.println();
                System.out.println("~");
            }
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find the next greater element for each element of the array.
    /**
     * Approach II : Using Stack Approach
     * 
     * As we have inner loop j which is dependent on i as j starts from (i + 1) to n
     * so we can reduce the time complexity to Linear O(N) by using Stack data-structure
     * 
     * TC: O(2 x N) ~ O(N)
     * SC: O(N)
     */
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> nge = new ArrayList<Integer>();
        int[] result = new int[n]; // SC: O(N)
        Stack<Integer> st = new Stack<Integer>();
        for (int i = n - 1; i >= 0; i--) {     // TC: O(N)
            if (st.isEmpty()) {
                result[i] = -1;
            } else {
                while (!st.isEmpty() && st.peek() <= arr[i]) {
                    st.pop();
                }
                if (st.isEmpty()) {
                    result[i] = -1;
                } else {
                    result[i] = st.peek();
                }
            }
            st.push(arr[i]);
        }
        for (int i = 0; i < n; i++) { // TC: O(N)
            nge.add(result[i]);
        }
        return nge;
    }

    /**
     * Approach I : Using Brute-Force Approach
     * 
     * TC: O(N ^ 2)
     * SC: O(1)
     */
    public ArrayList<Integer> nextLargerElementBruteForce(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> nge = new ArrayList<Integer>();
        for (int i = 0; i < n - 1; i++) {     // TC: O(N)
            boolean isFound = false;
            for (int j = i + 1; j < n; j++) { // TC: O(N)
                if (arr[j] > arr[i]) {
                    nge.add(arr[j]);
                    isFound = true;
                    break;
                }
            }
            if (!isFound) {
                nge.add(-1);
            }
        }
        nge.add(-1);
        return nge;
    }
}
