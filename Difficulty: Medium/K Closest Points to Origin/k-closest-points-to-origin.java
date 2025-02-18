//{ Driver Code Starts
import java.util.*;


// } Driver Code Ends
class Solution {
    /**
     * Using Max-Heap (PriorityQueue) Approach
     * 
     * TC: O(N + K)
     * SC: O(K)
     */
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        // use a Max-Heap (PriorityQueue) to store the distances of coordinates from origin
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((p, q) -> q[0] - p[0]); // SC: O(K)
        for (int i = 0; i < k; i++) { // TC: O(K)
            int sqrDist = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            pq.offer(new int[] { sqrDist, points[i][0], points[i][1] });
        }
        for (int i = k; i < n; i++) { // TC: O(N - K)
            int sqrDist = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            if (pq.peek()[0] > sqrDist) {
                pq.poll();
                pq.offer(new int[] { sqrDist, points[i][0], points[i][1] });
            }
        }
        int[][] result = new int[k][2];
        int index = 0;
        while (!pq.isEmpty()) { // TC: O(K)
            int[] current = pq.poll();
            result[index++] = new int[] { current[1], current[2] };
        }
        return result;
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        while (t-- > 0) {
            int k = scanner.nextInt();
            int n = scanner.nextInt();
            int[][] points = new int[n][2];
            for (int i = 0; i < n; i++) {
                points[i][0] = scanner.nextInt();
                points[i][1] = scanner.nextInt();
            }
            Solution solution = new Solution();
            int[][] ans = solution.kClosest(points, k);

            Arrays.sort(ans, (a, b) -> {
                if (a[0] != b[0]) {
                    return Integer.compare(a[0], b[0]);
                }
                return Integer.compare(a[1], b[1]);
            });
            for (int[] point : ans) {
                System.out.println(point[0] + " " + point[1]);
            }
            System.out.println("~");
        }

        scanner.close();
    }
}
// } Driver Code Ends