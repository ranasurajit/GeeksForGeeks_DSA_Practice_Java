//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S[] = read.readLine().split(" ");
            int R = Integer.parseInt(S[0]);
            int C = Integer.parseInt(S[1]);
            int matrix[][] = new int[R][C];
            int c = 0;
            for(int i = 0; i < R; i++){
                String line[]=read.readLine().trim().split(" ");
                for(int j = 0; j < C; j++){
                    matrix[i][j] = Integer.parseInt(line[j]);
                }
            }
            Solution ob = new Solution();
            int ans = ob.median(matrix, R, C);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    int median(int matrix[][], int R, int C) {
        /**
         * R and C are odd i.e. number of elements is R x C which is odd
         * so we have only 1 element as median
         */
        int median = 0;
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for (int i = 0; i < R; i++) {
            low = Math.min(low, matrix[i][0]);
            high = Math.max(high, matrix[i][C - 1]);
        }
        int n = (R * C) / 2;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int lessThanEquals = getNumElementsLessThan(matrix, mid);
            if (lessThanEquals <= n) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
    
    private int getNumElementsLessThan(int[][] matrix, int k) {
        int upperBound = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            upperBound += getUpperBound(matrix[i], k, rows, cols);
        }
        return upperBound;
    }
    
    private int getUpperBound(int[] row, int k, int rows, int cols) {
        int low = 0;
        int high = cols - 1;
        int index = cols;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (row[mid] > k) {
                index = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return index;
    }
}
