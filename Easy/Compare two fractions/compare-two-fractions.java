//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class GFG {
    public static void main(String args[]) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        Solution ob = new Solution();
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str = read.readLine().trim();
            String ans = ob.compareFrac(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {

    String compareFrac(String str) {
        String[] splits = str.split(", ");
        String[] numStr1 = splits[0].trim().split("/");
        String[] numStr2 = splits[1].trim().split("/");
        double num1 = Double.parseDouble(numStr1[0]) / Double.parseDouble(numStr1[1]);
        double num2 = Double.parseDouble(numStr2[0]) / Double.parseDouble(numStr2[1]);
        if (num1 == num2) {
            return "equal";
        }
        return num1 > num2 ? splits[0].trim() : splits[1].trim();
    }
}
