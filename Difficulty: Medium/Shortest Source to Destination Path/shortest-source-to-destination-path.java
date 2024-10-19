//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N, M, x, y;
            String S[] = read.readLine().split(" ");
            N = Integer.parseInt(S[0]);
            M = Integer.parseInt(S[1]);
            int a[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String s[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) a[i][j] = Integer.parseInt(s[j]);
            }
            String s1[] = read.readLine().split(" ");
            x = Integer.parseInt(s1[0]);
            y = Integer.parseInt(s1[1]);
            Solution ob = new Solution();
            System.out.println(ob.shortestDistance(N, M, a, x, y));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int shortestDistance(int N, int M, int A[][], int X, int Y) {
        int[][] minSteps = new int[N][M];
        for (int[] min1D : minSteps) {
            Arrays.fill(min1D, Integer.MAX_VALUE);
        }
        minSteps[0][0] = 0;
        if (A[0][0] == 0) {
            return -1;
        }
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((Pair p, Pair q) -> p.steps - q.steps);
        pq.offer(new Pair(0, 0, 0));
        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int crow = current.row;
            int ccol = current.col;
            int steps = current.steps;
            int directions = 4;
            int[] delRow = { -1, 0, 1, 0 };
            int[] delCol = { 0, 1, 0, -1 };
            for (int i = 0; i < directions; i++) {
                int effRow = crow + delRow[i];
                int effCol = ccol + delCol[i];
                if (effRow >= 0 && effRow < N && effCol >= 0 && effCol < M &&
                    A[effRow][effCol] == 1 && minSteps[effRow][effCol] == Integer.MAX_VALUE) {
                    minSteps[effRow][effCol] = steps + 1;
                    pq.offer(new Pair(effRow, effCol, steps + 1));        
                }
            }
        }
        return minSteps[X][Y] == Integer.MAX_VALUE ? -1 : minSteps[X][Y];
    }
    
    class Pair {
        int row;
        int col;
        int steps;
        public Pair(int row, int col, int steps) {
            this.row = row;
            this.col = col;
            this.steps = steps;
        }
    }
};
