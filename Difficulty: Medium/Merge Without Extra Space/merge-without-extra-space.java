//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases

        while (t-- > 0) {
            String arr1[] = br.readLine().trim().split(" ");
            String arr2[] = br.readLine().trim().split(" ");

            int a[] = new int[arr1.length];
            int b[] = new int[arr2.length];

            for (int i = 0; i < a.length; i++) a[i] = Integer.parseInt(arr1[i]);
            for (int i = 0; i < b.length; i++) b[i] = Integer.parseInt(arr2[i]);

            Solution ob = new Solution();
            ob.mergeArrays(a, b);

            StringBuffer str = new StringBuffer();
            for (int i = 0; i < a.length; i++) {
                str.append(a[i] + " ");
            }
            System.out.println(str);
            str = new StringBuffer();
            for (int i = 0; i < b.length; i++) {
                str.append(b[i] + " ");
            }
            System.out.println(str);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to merge the arrays.
    /**
     * Approach I : Using Two Pointers and Extra Space
     * 
     * TC: O(2 x (M + N)) ~ O(M + N)
     * SC: O(M + N)
     */
    public void mergeArrays(int a[], int b[]) {
        int m = a.length;
        int n = b.length;
        int[] result = new int[m + n]; // SC: O(M + N)
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < m && j < n) {
            if (a[i] < b[j]) {
                result[k++] = a[i++];
            } else {
                result[k++] = b[j++];
            }
        }
        while (i < m) {
            result[k++] = a[i++];
        }
        while (j < n) {
            result[k++] = b[j++];
        }
        int p = 0;
        for (p = 0; p < m; p++) { // TC: O(M)
            a[p] = result[p];
        }
        for (int q = 0; q < n; q++) { // TC: O(N)
            b[q] = result[m + q];
        }
    }
}
