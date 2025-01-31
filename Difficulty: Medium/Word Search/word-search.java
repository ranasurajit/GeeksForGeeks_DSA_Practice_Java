//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt(); // Number of test cases
        while (tc-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            char[][] mat = new char[n][m];

            // Reading the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    mat[i][j] = sc.next().charAt(0);
                }
            }

            String word = sc.next();
            Solution obj = new Solution();
            boolean ans = obj.isWordExist(mat, word);
            if (ans)
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
        sc.close();
    }
}
// } Driver Code Ends


class Solution {
    private static int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    private static int n;
    private static int m;

    /**
     * Using Backtracking Approach
     * 
     * TC: O(M x N x 3 ^ L)
     * SC: O(L)
     */
    static public boolean isWordExist(char[][] mat, String word) {
        n = mat.length;
        m = mat[0].length;
        for (int i = 0; i < n; i++) {      // TC: O(N)
            for (int j = 0; j < m; j++) {  // TC: O(M)
                if (mat[i][j] == word.charAt(0) && findWord(0, i, j, mat, word)) {
                    return true; // TC: O(3 ^ L, SC: O(L)
                }
            }
        }
        return false;
    }
    
    /**
     * TC: O(3 ^ L)
     * SC: O(L)
     */
    private static boolean findWord(int index, int row, int col,
        char[][] mat, String word) {
        // base case
        if (index >= word.length()) {
            return true;
        }
        // validate cells
        if (row < 0 || row >= n || col < 0 || col >= m || 
            mat[row][col] != word.charAt(index)) {
            return false;
        }

        char temp = mat[row][col];
        mat[row][col] = '$'; // marking it as visited
        
        // explore all possibilities
        for (int[] direction : directions) {
            int effRow = row + direction[0];
            int effCol = col + direction[1];
            
            if (findWord(index + 1, effRow, effCol, mat, word)) {
                return true;
            }
            
        }
        // backtrack
        mat[row][col] = temp; // marking it as visited
        return false;
    }
}
