//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine().trim());

            String[] line1 = br.readLine().trim().split(" ");
            int[] arr1 = new int[line1.length];
            for (int i = 0; i < line1.length; i++) {
                arr1[i] = Integer.parseInt(line1[i]);
            }

            String[] line2 = br.readLine().trim().split(" ");
            int[] arr2 = new int[line2.length];
            for (int i = 0; i < line2.length; i++) {
                arr2[i] = Integer.parseInt(line2[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.kthElement(k, arr1, arr2));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public long kthElement(int k, int arr1[], int arr2[]) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        int p = 0;
        int q = 0;
        int r = 0;
        int kAnswer = 0;
        while (p < len1 && q < len2) {
            if (arr1[p] < arr2[q]) {
                kAnswer = arr1[p];
                p++;
            } else {
                kAnswer = arr2[q];
                q++;
            }
            if (r == k - 1) {
                return kAnswer;
            }
            r++;
        }
        while (p < len1 && r <= k - 1) {
            kAnswer = arr1[p];
            p++;
            r++;
        }
        while (q < len2 && r <= k - 1) {
            kAnswer = arr2[q];
            q++;
            r++;
        }
        return kAnswer;
    }
}
