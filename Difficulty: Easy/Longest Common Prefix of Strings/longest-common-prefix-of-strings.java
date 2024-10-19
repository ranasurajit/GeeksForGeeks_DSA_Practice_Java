//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public String longestCommonPrefix(String arr[]) {
        int n = arr.length;
        String common = arr[0];
        for (int i = 1; i < n; i++) {
            common = getCommonPrefix(common, arr[i]);
        }
        return common == "-1" ? "-1" : common;
    }
    
    private String getCommonPrefix(String str1, String str2) {
        int n = Math.min(str1.length(), str2.length());
        int index = -1;
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                break;
            } else {
                index = i;
            }
        }
        return index == -1 ? "-1" : str1.substring(0, index + 1);
    }
}
