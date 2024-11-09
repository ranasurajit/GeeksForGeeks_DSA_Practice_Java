//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            // First array input
            String[] str1 = br.readLine().trim().split(
                " "); // Read the first line and split by spaces
            int n = str1.length;
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str1[i]); // Convert each element to an integer
            }

            // Second array input
            String[] str2 = br.readLine().trim().split(
                " "); // Read the second line and split by spaces
            int m = str2.length;
            int[] b = new int[m];
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(str2[i]); // Convert each element to an integer
            }

            Solution obj = new Solution();
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = obj.findUnion(a, b);
            for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
            System.out.println();

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// a,b : the arrays
class Solution {
    // Function to return a list containing the union of the two arrays.
    /**
     * TC: O(M + N)
     * SC: O(1)
     */
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        ArrayList<Integer> union = new ArrayList<Integer>();
        int p = 0;
        int q = 0;
        int m = a.length;
        int n = b.length;
        while (p < m && q < n) {                           // TC: O(M + N)
            if (a[p] < b[q]) {
                checkAndAdd(union, a[p]);
                p++;
            } else {
                checkAndAdd(union, b[q]);
                q++;
            }
        }
        while (p < m) {
            checkAndAdd(union, a[p]);
            p++;
        }
        while (q < n) {
            checkAndAdd(union, b[q]);
            q++;
        }
        return union;
    }
    
    /**
     * TC: O(1)
     * SC: O(1)
     */
    private static void checkAndAdd(ArrayList<Integer> union, int element) {
        if (union.isEmpty()) {
            union.add(element);
        } else {
            if (union.get(union.size() - 1) != element) {
                union.add(element);
            }
        }
    }
}
