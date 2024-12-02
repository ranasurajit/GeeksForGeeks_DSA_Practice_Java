//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s, patt;
            s = sc.next();
            patt = sc.next();

            Solution ob = new Solution();

            ArrayList<Integer> res = ob.search(patt, s);
            if (res.size() == 0)
                System.out.print("[]");
            else {
                for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    /**
     * TC: O(M + N)
     * SC: O(N)
     */
    ArrayList<Integer> search(String pat, String txt) {
        int n = pat.length();
        int m = txt.length();
        ArrayList<Integer> result = new ArrayList<Integer>();
        int[] lps = computeLPS(pat, n); // TC: O(N), SC: O(N)
        int i = 0;
        int j = 0;
        while (i < m) {                 // TC: O(M)
            if (i < m && txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
            }
            if (j == n) {
                result.add(i - j);
                j = lps[j - 1];
            }
            if (i < m && txt.charAt(i) != pat.charAt(j)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return result;
    }
    
    /**
     * TC: O(N)
     * SC: O(N)
     */
    private int[] computeLPS(String pat, int n) {
        int[] lps = new int[n];
        lps[0] = 0;
        int i = 1;
        int j = 0;
        while (i < n) {
            if (pat.charAt(i) == pat.charAt(j)) {
                lps[i] = j + 1;
                i++;
                j++;
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
