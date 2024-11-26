//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
     
      Solution obj = new Solution();
      long ans = obj.count(n);
      System.out.println(ans);
    
System.out.println("~");
}
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    /**
     * TC: O(2 ^ Y)
     * SC: O(log(Y))
     */
    static long count(int n) {
        long exp = (n * (n - 1)) / 2;
        return power((long) 2, exp);
    }
    
    /**
     * TC: O(log(Y))
     * SC: O(log(Y))
     */
    private static long power(long x, long y) {
        if (y == 0) {
            return 1;
        }
        long temp = power(x, y / 2);
        if (y % 2 == 0) {
            return temp * temp;
        } else {
            if (y > 0) {
                return x * temp * temp;
            }
            else {
                return (temp * temp) / x;
            }
        }
    }
}
