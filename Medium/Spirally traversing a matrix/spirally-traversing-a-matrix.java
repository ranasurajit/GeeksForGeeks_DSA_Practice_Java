//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int r = sc.nextInt();
            int c = sc.nextInt();

            int matrix[][] = new int[r][c];

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.spirallyTraverse(matrix);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to return a list of integers denoting spiral traversal of matrix.
    public ArrayList<Integer> spirallyTraverse(int matrix[][]) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int directions = 4;
        int top = 0;
        int bottom = rows - 1;
        int left = 0;
        int right = cols - 1;
        /**
         * 0 for left to right
         * 1 for top to bottom
         * 2 for right to left
         * 3 for bottom to top
         */
        int currentDirection = 0;
        ArrayList<Integer> path = new ArrayList<Integer>();
        while (left <= right && top <= bottom) {
            if (currentDirection == 0) {
                // left to right
                for (int i = left; i <= right; i++) {
                    path.add(matrix[top][i]);
                }
                top++;
            } else if (currentDirection == 1) {
                // top to bottom
                for (int i = top; i <= bottom; i++) {
                    path.add(matrix[i][right]);
                }
                right--;
            } else if (currentDirection == 2) {
                // right to left
                for (int i = right; i >= left; i--) {
                    path.add(matrix[bottom][i]);
                }
                bottom--;
            } else {
                // bottom to top
                for (int i = bottom; i >= top; i--) {
                    path.add(matrix[i][left]);
                }
                left++;
            }
            currentDirection = (currentDirection + 1 ) % directions;
        }
        return path;
    }
}
