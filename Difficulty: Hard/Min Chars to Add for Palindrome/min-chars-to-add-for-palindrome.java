//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    /**
     * TC: O(2 x N) ~ O(N)
     * SC: O(2 x N) ~ O(N)
     */
    public static int minChar(String s) {
        String combined = s + reverse(s);    // TC: O(N), SC: O(N)
        int n = combined.length();
        int[] lps = computeLPS(combined, n); // TC: O(N), SC: O(N)
        return s.length() - lps[n - 1];
    }
    
    /**
     * TC: O(N)
     * SC: O(N)
     */
    private static String reverse(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int start = 0;
        int end = n - 1;
        while (start < end) {
            char temp = chars[end];
            chars[end] = chars[start];
            chars[start] = temp;
            start++;
            end--;
        }
        return String.valueOf(chars);
    }
    
    /**
     * TC: O(N)
     * SC: O(N)
     */
    private static int[] computeLPS(String s, int n) {
        int[] lps = new int[n]; // SC: O(N)
        lps[0] = 0;
        int i = 1;
        int j = 0;
        while (i < n) {         // TC: O(N)
            if (s.charAt(i) == s.charAt(j)) {
                lps[i] = j + 1;
                i++;
                j++;
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                    lps[i] = 0;
                } else {
                    i++;
                }
            }
        }
        return lps;
    }
}


//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        var sc = new FastReader();
        int test = sc.nextInt();
        while (test-- > 0) {
            String s = sc.nextString();
            System.out.println(Solution.minChar(s));

            System.out.println("~");
        }
    }

    public static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
            st = new StringTokenizer("");
        }

        private void read() throws IOException {
            st = new StringTokenizer(br.readLine());
        }

        public String nextString() throws IOException {
            while (!st.hasMoreTokens()) read();
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(nextString());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(nextString());
        }
    }
}
// } Driver Code Ends