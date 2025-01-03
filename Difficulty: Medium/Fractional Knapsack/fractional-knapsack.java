//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GfG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            // Read values array
            String[] valueInput = br.readLine().trim().split(" ");
            List<Integer> values = new ArrayList<>();
            for (String s : valueInput) {
                values.add(Integer.parseInt(s));
            }

            // Read weights array
            String[] weightInput = br.readLine().trim().split(" ");
            List<Integer> weights = new ArrayList<>();
            for (String s : weightInput) {
                weights.add(Integer.parseInt(s));
            }

            // Read the knapsack capacity
            int w = Integer.parseInt(br.readLine().trim());

            // Call fractionalKnapsack function and print result
            System.out.println(String.format(
                "%.6f", new Solution().fractionalKnapsack(values, weights, w)));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    // Function to get the maximum total value in the knapsack.
    /**
     * TC: O(2 x N) ~ O(N)
     * SC: O(N)
     */
    double fractionalKnapsack(List<Integer> val, List<Integer> wt, int capacity) {
        int n = val.size();
        /**
         * Fractional Knapsack is a greedy problem we need to
         * greedily pick the items based upon the value / weight
         * ratio.
         * 
         * So we need to create Max-Heap (Priority Queue)
         * of value / weight ratio
         * 
         * we will store int[] as { val/wt, val, wt } in the Max-heap
         */
        // SC: O(N)
        PriorityQueue<double[]> pq = new PriorityQueue<double[]>((double[] p, double[] q) -> {
            return Double.compare(q[0], p[0]);
        });
        for (int i = 0; i < n; i++) { // TC: O(N)
            pq.offer(new double[] { ((double) val.get(i) / wt.get(i)), val.get(i), wt.get(i) });
        }
        double maxValue = 0;
        double currentWeight = 0;
        while (!pq.isEmpty()) { // TC: O(N)
            double[] current = pq.poll();
            if (currentWeight + current[2] <= capacity) {
                maxValue += current[1];
                currentWeight = currentWeight + current[2];
            } else {
                double remaining = capacity - currentWeight;
                double frac = current[0] * remaining;
                maxValue += frac;
                break;
            }
        }
        return maxValue;
    }
}
