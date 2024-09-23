//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    /**
     * TC: O(N)
     * SC: O(1)
     */
    int[] findTwoElement(int arr[]) {
        long n = arr.length;
        long sum1 = (n * (n + 1)) / 2; // sum of numbers 1 to n
        long sum2 = 0L;
        long sq1 = (n * (n + 1) * (2 * n + 1)) / 6; // sum of squares of numbers 1 to n
        long sq2 = 0L;
        for (int i = 0; i < n; i++) { // TC: O(N)
            sum2 += (long) arr[i];
            sq2 += (long) arr[i] * (long) arr[i];
        }
        long xMinusY = sum2 - sum1; // x - y
        long xPlusY = (sq2 - sq1) / xMinusY; // (x + y) = (x^2 - y^2) / (x - y)
        long repeating = (xMinusY + xPlusY) / 2;
        long missing = xPlusY - repeating;
        return new int[] { (int) repeating, (int) missing };
    }
}
