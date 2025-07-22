class Solution {
    /**
     * Approach : Using Greedy + Heaps Approach
     * 
     * TC: O(N x log(N)) + O(N) ~ O(N x log(N))
     * SC: O(N)
     */
    double fractionalKnapsack(int[] values, int[] weights, int W) {
        int n = weights.length;
        // we will be storing { values[i] / weights[i], values[i], weights[i] } in the Max-Heap
       PriorityQueue<double[]> pq =
            new PriorityQueue<double[]>((p, q) -> {
                if (p[0] == q[0]) {
                    return Double.compare(p[2], q[2]);
                }
                return Double.compare(q[0], p[0]);
            }); // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            pq.offer(new double[] {
                (double) ((double) values[i] / weights[i]),
                (double) values[i],
                (double) weights[i]
            }); // TC: O(log(N))
        }
        double maxValue = 0d;
        double currentWeight = 0.0d;
        while (!pq.isEmpty()) { // TC: O(N)
            double[] current = pq.poll();
            if (currentWeight + current[2] <= W) {
                currentWeight += current[2];
                maxValue += current[1];
            } else {
                maxValue += (double) (W - currentWeight) * current[0];
                break;
            }
        }
        return maxValue;
    }
}
