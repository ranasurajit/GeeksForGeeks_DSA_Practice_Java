//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.minimumCostPath(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    //Function to return the minimum cost to react at bottom
	//right cell from top left cell.
    public int minimumCostPath(int[][] grid) {
        int n = grid.length;
        int[][] costGrid = new int[n][n];
        for (int[] cost1D : costGrid) {
            Arrays.fill(cost1D, Integer.MAX_VALUE);
        }
        costGrid[0][0] = grid[0][0];
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((Pair p, Pair q) -> p.cost - q.cost);
        pq.offer(new Pair(0, 0, grid[0][0]));
        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int[] delRow = { 0, -1, 0, 1 };
            int[] delCol = { -1, -0, 1, 0 };
            int directions = 4;
            for (int i = 0; i < directions; i++) {
                int effRow = current.row + delRow[i];
                int effCol = current.col + delCol[i];
                if (effRow >= 0 && effRow < n && effCol >= 0 && effCol < n &&
                    costGrid[effRow][effCol] > current.cost + grid[effRow][effCol]) {
                    costGrid[effRow][effCol] = current.cost + grid[effRow][effCol];
                    pq.offer(new Pair(effRow, effCol, costGrid[effRow][effCol]));
                }
            }
        }
        return costGrid[n - 1][n - 1];
    }
    
    class Pair {
        int row;
        int col;
        int cost;
        public Pair(int row, int col, int cost) {
            this.row = row;
            this.col = col;
            this.cost = cost;
        }
    }
}
