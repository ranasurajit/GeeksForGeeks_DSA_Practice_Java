//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            long p[] = new long[2];
            long q[] = new long[2];
            long r[] = new long[2];
            p[0] = Long.parseLong(S[0]);
            p[1] = Long.parseLong(S[1]);
            q[0] = Long.parseLong(S[2]);
            q[1] = Long.parseLong(S[3]);
            r[0] = Long.parseLong(S[4]);
            r[1] = Long.parseLong(S[5]);
            Solution ob = new Solution();
            long ans = ob.InternalCount(p, q, r);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    
    private long gcd(long m, long n) {
        while (n != 0) {
            long temp = n;
            n = m % n;
            m = temp;
        }
        return m;
    }

    long InternalCount(long p[], long q[], long r[]) {
        // Using Pick's theoram
        // I = A - (B / 2) + 1
        // where A (area of triangle) = 1/2*(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2))
        // B = GCD (| x1- x2 |, | y1 - y2 |)
        long A = Math.abs((long) (p[0] * (q[1] - r[1]) + q[0] * (r[1] - p[1]) + r[0] * (p[1] - q[1])));
        A = A / 2;
        long Bpq = gcd(Math.abs((long) (p[0] - q[0])), Math.abs((long) (p[1] - q[1])));
        long Bqr = gcd(Math.abs((long) (q[0] - r[0])), Math.abs((long) (q[1] - r[1])));
        long Brp = gcd(Math.abs((long) (r[0] - p[0])), Math.abs((long) (r[1] - p[1])));
        long B = Bpq + Bqr + Brp;
        return A - (B / 2) + 1;
    }
};