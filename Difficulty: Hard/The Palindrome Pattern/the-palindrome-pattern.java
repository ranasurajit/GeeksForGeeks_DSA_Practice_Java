//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        Solution ob = new Solution();
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String input_line[] = read.readLine().trim().split("\\s+");
            int n = Integer.parseInt(input_line[0]);
            String input_line1[] = read.readLine().trim().split("\\s+");
            int[][] a = new int[n][n];
            int c = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = Integer.parseInt(input_line1[c]);
                    c++;
                }
            }
            String ans = ob.pattern(a);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public String pattern(int[][] arr) {
        int rows = arr.length;
        int cols = arr[0].length;
        for (int i = 0; i < rows; i++) {
            if (isPalindrome(arr[i])) {
                return i + " R";
            }
        }
        int[] colArr = new int[rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                colArr[j] = arr[j][i];
            }
            if (isPalindrome(colArr)) {
                return i + " C";
            }
        }
        return "-1";
    }
    
    private boolean isPalindrome(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            if (nums[low] != nums[high]) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
}
