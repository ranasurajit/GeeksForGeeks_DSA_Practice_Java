//{ Driver Code Starts
import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int r = sc.nextInt();
            int c = sc.nextInt();
            
            int matrix[][] = new int[r][c];
            
            for(int i = 0; i < r; i++)
            {
                for(int j = 0; j < c; j++)
                 matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.spirallyTraverse(matrix, r, c);
            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution {
    //Function to return a list of integers denoting spiral traversal of matrix.
    static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int direction = 0;
        int left = 0;
        int right = c - 1;
        int top = 0;
        int bottom = r - 1;
        while (left <= right && top <= bottom) {
            direction = direction % 4;
            switch (direction) {
                case 0:
                    // left to right
                    for (int i = left; i <= right; i++) {
                        result.add(matrix[top][i]);
                    }
                    top += 1;
                    direction++;
                    break;
                case 1:
                    // top to bottom
                    for (int i = top; i <= bottom; i++) {
                        result.add(matrix[i][right]);
                    }
                    right -= 1;
                    direction++;
                    break;
                case 2:
                    // right to left
                    for (int i = right; i >= left; i--) {
                        result.add(matrix[bottom][i]);
                    }
                    bottom -= 1;
                    direction++;
                    break;
                case 3:
                    // bottom to top
                    for (int i = bottom; i >= top; i--) {
                        result.add(matrix[i][left]);
                    }
                    left += 1;
                    direction++;
                    break;
                default:
                    // nothing
            }
        }
        return result;
    }
}
