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
     * Using Recursion Approach
     * 
     * TC: O(log(E))
     * SC: O(log(E))
     * 
     * @param b
     * @param e
     * @return
     */
    double power(double b, int e) {
        if (e < 0) {
            return 1 / pow(b, -1 * e);
        }
        return pow(b, e);
    }
    
    /**
     * Using Recursion
     * 
     * TC: O(log(N))
     * SC: O(log(N))
     * 
     * @param x
     * @param n
     * @return
     */
    private double pow(double x, int n) {
        if (n == 1) {
            return x;
        }
        if (x == 1.0 || n == 0) {
            return 1.0;
        }
        double answer = pow(x, n / 2);
        if ((n & 1) == 0) {
            // n is even
            return answer * answer;
        } else {
            // n is odd
            return x * answer * answer;
        }
    }
}


//{ Driver Code Starts.
// } Driver Code Ends