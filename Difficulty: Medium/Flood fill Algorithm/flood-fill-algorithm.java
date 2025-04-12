//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int m = Integer.parseInt(br.readLine().trim());
            int[][] image = new int[n][m];
            for (int i = 0; i < n; i++) {
                String[] S2 = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) image[i][j] = Integer.parseInt(S2[j]);
            }
            int sr = Integer.parseInt(br.readLine().trim());
            int sc = Integer.parseInt(br.readLine().trim());
            int newColor = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            int[][] ans = obj.floodFill(image, sr, sc, newColor);
            for (int i = 0; i < ans.length; i++) {
                for (int j = 0; j < ans[i].length; j++)
                    System.out.print(ans[i][j] + " ");
                System.out.println();
            }

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    private static int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    private int n;
    private int m;
    private int originalColor;

    /**
     * Approach: Using DFS Approach
     * 
     * TC: O(5 x N x M) ~ O(N x M)
     * SC: O(2 x N x M) ~ O(N x M)
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        n = image.length;
        m = image[0].length;
        originalColor = image[sr][sc];
        boolean[][] visited = new boolean[n][m]; // SC: O(N x M)
        for (int i = 0; i < n; i++) { // TC: O(N)
            for (int j = 0; j < m; j++) { // TC: O(M)
                if (image[i][j] != originalColor) {
                    visited[i][j] = true;
                }
            }
        }
        dfsGraph(sr, sc, image, visited, newColor); // TC: O(4 x N x M), SC: O(N x M)
        return image;
    }
    
    /**
     * Using DFS Approach
     * 
     * TC: O(4 x N x M)
     * SC: O(N x M)
     */
    private void dfsGraph(int row, int col, int[][] image, boolean[][] visited,
        int newColor) {
        if (row < 0 || row >= n || col < 0 || col >= m || image[row][col] != originalColor ||
            visited[row][col]) {
            return;    
        }
        visited[row][col] = true;
        image[row][col] = newColor;
        for (int[] direction : directions) { // TC: O(4)
            int effRow = row + direction[0];
            int effCol = col + direction[1];
            dfsGraph(effRow, effCol, image, visited, newColor);
        }
    }
}
