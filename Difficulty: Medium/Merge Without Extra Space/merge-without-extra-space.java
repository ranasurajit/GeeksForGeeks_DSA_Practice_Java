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
     * Using GAP Method / Shell Sorting Approach
     * 
     * TC: O((M + N) x log(M + N))
     * SC: O(1)
     */
    public void mergeArrays(int a[], int b[]) {
        int m = a.length;
        int n = b.length;
        int len = m + n;
        int gap = (len / 2) + (len % 2);
        while (gap > 0) {
            int left = 0;
            int right = left + gap;
            while (right < len) {
                if (left < m && right >= m) {
                    // left pointer is at array a and right pointer in array b
                    swapIfGreater(a, b, left, right - m);
                } else if (left >= m) {
                    // left pointer and right pointer in array b
                    swapIfGreater(b, b, left - m, right - m);
                } else if (right < m) {
                    // left pointer and right pointer in array a
                    swapIfGreater(a, a, left, right);
                }
                left++;
                right++;
            }
            if (gap == 1) {
                break;
            }
            gap = (gap / 2) + (gap % 2);
        }
    }
    
    private void swapIfGreater(int[] a, int[] b, int p, int q) {
        if (a[p] > b[q]) {
            // swap elements
            int temp = b[q];
            b[q] = a[p];
            a[p] = temp;
        }
    }
}
