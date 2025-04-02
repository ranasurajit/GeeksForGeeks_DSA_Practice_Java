//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int mat[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) mat[i][j] = sc.nextInt();
            }
            Solution obj = new Solution();
            int ans = obj.orangesRotting(mat);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {

    private int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    /**
     * Approach : Using Multi-Source BFS
     * 
     * TC: O(2 x N x M) ~ O(N x M)
     * SC: O(2 x N x M) ~ O(N x M)
     */
    public int orangesRotting(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int freshOranges = 0;
        Queue<int[]> queue = new LinkedList<int[]>(); // SC: O(N x M)
        boolean[][] visited = new boolean[n][m];      // SC: O(N x M)
        for (int i = 0; i < n; i++) {     // TC: O(N)
            for (int j = 0; j < m; j++) { // TC: O(M)
                if (mat[i][j] == 1) {
                    freshOranges++;
                } else if (mat[i][j] == 2) {
                    queue.offer(new int[] { i, j, 0 });
                    visited[i][j] = true;
                }
            }
        }
        int time = 0;
        int convertedOranges = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int row = current[0];
                int col = current[1];
                int timeCell = current[2];
                time = Math.max(time, timeCell);
                for (int[] direction : directions) {
                    int effRow = row + direction[0];
                    int effCol = col + direction[1];
                    if (effRow >= 0 && effRow < n && effCol >= 0 && effCol < m &&
                        !visited[effRow][effCol] && mat[effRow][effCol] == 1) {
                        queue.offer(new int[] { effRow, effCol, time + 1 });
                        visited[effRow][effCol] = true;
                        convertedOranges++;
                    }
                }
            }
        }
        if (convertedOranges < freshOranges) {
            return -1;
        }
        return time;
    }
}
