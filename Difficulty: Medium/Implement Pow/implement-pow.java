//{ Driver Code Starts
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            double b = sc.nextDouble();
            int e = sc.nextInt();
            Solution ob = new Solution();
            System.out.printf("%.5f\n", ob.power(b, e));
            System.out.println("~");
        }
        sc.close();
    }
}


// } Driver Code Ends
// User function Template for Java
class Solution {
    /**
     * Using Recursion
     * 
     * TC: O(log(E))
     * SC: O(log(E))
     */
    double power(double b, int e) {
        if (e == 0) {
            return 1.0;
        }
        boolean isNeg = b < 0;
        if (e < 0) {
            return 1 / power(b, -1 * e);
        }
        double answer = 1.0;
        double half = power(b, e / 2);
        answer = half * half;
        if (e % 2 == 1) {
            // power is odd
            answer = b * answer;
        }
        return answer;
    }
}


//{ Driver Code Starts.
// } Driver Code Ends