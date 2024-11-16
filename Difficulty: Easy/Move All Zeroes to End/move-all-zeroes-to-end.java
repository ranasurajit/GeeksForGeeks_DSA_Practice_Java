//{ Driver Code Starts
// Initial Template for Java

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String[] inputLine = br.readLine().split(" ");
            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().pushZerosToEnd(arr);
            int n = arr.length;
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    /**
     * TC: O(N)
     * SC: O(1)
     */
    void pushZerosToEnd(int[] arr) {
        int n = arr.length;
        int p = 0; // pointer for zero elements
        while (p < n && arr[p] != 0) {
            p++;
        }
        if (p == n) {
            return;
        }
        int q = p + 1; // pointer for non-zero elements
        while (q < n) {
            while (q < n && arr[q] == 0) {
                q++;
            }
            if (q < n) {
                int temp = arr[q];
                arr[q] = arr[p];
                arr[p] = temp;
            }
            p++;
            q++;
        }
    }
}
