//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String arr[] = br.readLine().split(" ");
            int a[] = new int[arr.length];

            for (int i = 0; i < arr.length; i++) {
                a[i] = Integer.parseInt(arr[i]);
            }
            Solution obj = new Solution();
            int f = 0;
            String A = obj.minSum(a);
            System.out.println(A);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    /**
     * TC: O(N x log(N) + 2 x N) ~ TC: O(N x log(N))
     * SC: O(3 x N) ~ O(N)
     */
    String minSum(int[] arr) {
        // sort the numbers so that minimum two numbers goes in each set
        Arrays.sort(arr);                                    // TC: O(N x log(N))
        StringBuilder num1 = new StringBuilder();            // SC: O(N)
        StringBuilder num2 = new StringBuilder();            // SC: O(N)
        for (int i = 0; i < arr.length; i++) {               // TC: O(N)
            if (i % 2 == 0) {
                num1.append(arr[i]);
            } else {
                num2.append(arr[i]);
            }
        }
        num1 = num1.reverse();
        num2 = num2.reverse();
        StringBuilder sum = new StringBuilder();            // SC: O(N)
        int carry = 0;
        int p = 0;
        int q = 0;
        while (p < num1.length() || q < num2.length()) {    // TC: O(N)
            int s = carry;
            if (p < num1.length()) {
                s += Integer.valueOf(num1.charAt(p) - '0');
            }
            if (q < num2.length()) {
                s += Integer.valueOf(num2.charAt(q) - '0');
            }
            carry = 0;
            if (s > 9) {
                carry = s / 10;
                s = s % 10;
            }
            sum.append(s);
            p++;
            q++;
        }
        if (carry > 0) {
            sum.append(carry);
        }
        String minSum = sum.reverse().toString();
        int countLeadingZeros = 0;
        while (minSum.charAt(countLeadingZeros) == '0') {
            countLeadingZeros++;
        }
        return minSum.substring(countLeadingZeros);
    }
}
