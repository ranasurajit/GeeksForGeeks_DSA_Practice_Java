//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int m = Integer.parseInt(inputLine[1]);
            int[][] arr = new int[n][m];
            inputLine = br.readLine().trim().split(" ");

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(inputLine[i * m + j]);
                }
            }
            int ans = new Solution().rowWithMax1s(arr);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int rowWithMax1s(int arr[][]) {
        int n = arr.length;
        int m = arr[0].length;
        // { count of 1's, row index }
        int[] max = { 0, 0 };
        for (int i = 0; i < n; i++) {
            int[] current = { 0, 0 };
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1) {
                    current[0] = m - j;
                    current[1] = i;
                    break;
                }
            }
            // setting the maximum reached till row -> i
            if (max[0] < current[0]) {
                max = current;
            }
        }
        // if none of rows having 1's
        if (max[0] == 0) {
            return -1;
        }
        return max[1];
    }
}