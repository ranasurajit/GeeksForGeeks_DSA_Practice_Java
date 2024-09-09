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
    /**
     * TC: O(R) + O(Rlog(C)) ~ O(Rlog(C))
     * SC: O(1)
     * 
     * @param matrix
     * @param R
     * @param C
     * @return
     */
    int median(int matrix[][], int R, int C) {
        // finding range
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for (int i = 0; i < R; i++) { // TC: O(R)
            low = Math.min(low, matrix[i][0]);
            high = Math.max(high, matrix[i][C - 1]);
        }
        /**
         * R and C are odd i.e. number of elements is R x C which is odd
         * so we have only 1 element as median
         */
        int targetIndex = (R * C) / 2;
        // Applying Binary Search
        while (low <= high) { // TC: O(log(Range)) where Range = high - low i.e. constant
            int mid = low + (high - low) / 2;
            // find number of elements less than mid value in matrix
            int lessThanEquals = getLessThanEquals(matrix, R, C, mid);
            if (lessThanEquals <= targetIndex) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;     
    }
    
    /**
     * TC: O(Rlog(C))
     * SC: O(1)
     * 
     * @param matrix
     * @param R
     * @param C
     * @param mid
     * @return
     */
    private int getLessThanEquals(int[][] matrix, int R, int C, int mid) {
        // finding sum of occurences of mid value in each row
        int count = 0;
        for (int i = 0; i < R; i++) {
            count += getUpperBound(matrix[i], mid);
        }
        return count;
    }

    /**
     * TC: O(log(C))
     * SC: O(1)
     * 
     * @param row
     * @param k
     * @return
     */
    private int getUpperBound(int[] row, int k) {
        int low = 0;
        int high = row.length - 1;
        int lessThan = row.length;
        // Applying Binary Search
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (row[mid] > k) {
                lessThan = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return lessThan;
    }
}
