class Solution {
    /**
     * Approach II : Using Max-Heap (PriorityQueue) + Sorting + Visited Set Approach
     * 
     * TC: O(2 x N x log(N) + K x log(K) + 2 x N) ~ O(N x log(K)) + O(K x log(K))
     * SC: O(K) + O(K)
     * 
     * Accepted (1100 / 1100 testcases passed)
     */
    public ArrayList<Integer> topKSumPairs(int[] a, int[] b, int k) {
        int n = a.length;
        Arrays.sort(a); // TC: O(N x log(N))
        Arrays.sort(b); // TC: O(N x log(N))
        reverse(a); // TC: O(N)
        reverse(b); // TC: O(N)
        // Using a Max-heap PriorityQueue
        PriorityQueue<Pair> pq = 
            new PriorityQueue<Pair>((p, q) -> q.sum - p.sum); // SC: O(K)
        Set<String> visited = new HashSet<String>(); // SC: O(K)
        pq.offer(new Pair(0, 0, a[0] + b[0])); // TC: O(log(1))
        ArrayList<Integer> result = new ArrayList<Integer>();
        while (k > 0 && !pq.isEmpty()) { // TC: O(K)
            Pair top = pq.poll();
            result.add(top.sum);
            int i = top.i;
            int j = top.j;
            if (i + 1 < n && !visited.contains((i + 1) + "|" + j)) {
                pq.offer(new Pair(i + 1, j, a[i + 1] + b[j])); // TC: O(log(K))
                visited.add((i + 1) + "|" + j);
            }
            if (j + 1 < n && !visited.contains(i + "|" + (j + 1))) {
                pq.offer(new Pair(i, j + 1, a[i] + b[j + 1])); // TC: O(log(K))
                visited.add(i + "|" + (j + 1));
            }
            k--;
        }
        return result;
    }
    
    /**
     * Using Two Pointers Approach
     * 
     * TC: O(N)
     * SC: O(1)
     */
    private void reverse(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int temp = arr[end];
            arr[end] = arr[start];
            arr[start] = temp;
            start++;
            end--;
        }
    }
    
    class Pair {
        int i;
        int j;
        int sum;
        
        public Pair (int i, int j, int sum) {
            this.i = i;
            this.j = j;
            this.sum = sum;
        }
    }

    /**
     * Approach I : Using Brute-Force (Min-Heap (PriorityQueue) + Sorting) Approach
     * 
     * TC: O(2 x N x log(N) + N ^ 2 x log(K) + K x log(K)) ~ O(N ^ 2 x log(K))
     * SC: O(K)
     * 
     * Time Limit Exceeded (1010 / 1100 testcases passed)
     */
    public ArrayList<Integer> topKSumPairsBruteForce(int[] a, int[] b, int k) {
        int n = a.length;
        Arrays.sort(a); // TC: O(N x log(N))
        Arrays.sort(b); // TC: O(N x log(N))
        ArrayList<Integer> result = new ArrayList<Integer>();
        // Using a Min-heap PriorityQueue
        PriorityQueue<Integer> pq = 
            new PriorityQueue<Integer>((p, q) -> p - q); // SC: O(K)
        for (int i = 0; i < n; i++) { // TC: O(N)
            for (int j = 0; j < n; j++) { // TC: O(N)
                int current = a[i] + b[j];
                if (pq.size() < k) {
                    pq.offer(current); // TC: O(log(K))
                } else {
                    if (current > pq.peek()) {
                        pq.poll();
                        pq.offer(current); // TC: O(log(K))
                    }
                }
            }
        }
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }
        result.sort((x, y) -> y - x);  // TC: O(K x log(K))
        return result;
    }
}
