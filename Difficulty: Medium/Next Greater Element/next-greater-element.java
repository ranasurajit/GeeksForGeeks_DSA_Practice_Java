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
     * Using Stack Approach
     *
     * TC: O(N)
     * SC: O(N)
     */
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<Integer>(); // SC: O(N)
        ArrayList<Integer> nge = new ArrayList<Integer>();
        for (int i = n - 1; i >= 0; i--) {        // TC: O(N)
            if (st.isEmpty()) {
                nge.add(0, -1);
            } else {
                while (!st.isEmpty() && arr[i] >= st.peek()) {
                    st.pop();
                }
                int element = st.isEmpty() ? -1 : st.peek();
                nge.add(0, element);
            }
            st.push(arr[i]);
        }
        return nge;
    }
}
