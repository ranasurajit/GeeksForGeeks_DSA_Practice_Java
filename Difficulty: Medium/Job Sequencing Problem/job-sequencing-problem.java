class Solution {
    /**
     * Approach : Using Greedy Approach
     * 
     * TC: O(N) + O(N x log(N)) + O(N) ~ O(N x log(N))
     * SC: O(2 x N) ~ O(N)
     */
    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        int n = deadline.length;
        int[][] jobs = new int[n][2]; // SC: O(2 x N)
        int maxDeadline = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) { // TC: O(N)
            jobs[i] = new int[] { deadline[i], profit[i] };
            maxDeadline = Math.max(maxDeadline, deadline[i]);
        }
        // sorting the jobs in descending order of profits
        Arrays.sort(jobs, (a, b) -> b[1] - a[1]); // TC: O(N x log(N))
        int countJobs = 0;
        int totalProfits = 0;
        int[] slots = new int[maxDeadline + 1];
        Arrays.fill(slots, -1);
        for (int i = 0; i < n; i++) { // TC: O(N)
            // deadline of ith job can go from jobs[i][0] to 1
            for (int j = jobs[i][0]; j >= 1; j--) {
                if (slots[j] == -1) {
                    // fill the slot
                    slots[j] = i;
                    countJobs++;
                    totalProfits += jobs[i][1];
                    break;
                }
            }
        }
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(countJobs);
        result.add(totalProfits);
        return result;
    }
}
