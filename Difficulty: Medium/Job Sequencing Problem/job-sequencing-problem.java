//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class GfG {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            
            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");
            
            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            
            Solution ob = new Solution();
            
            //function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}
// } Driver Code Ends


class Solution {
    /**
     * Approach : Using Greedy Approach
     * 
     * TC: O(N + N x log(N) + N x K) ~ O(N x log(N) + N x K)
     * SC: O(2 x N + K) ~ O(N + K)
     * 
     * where K = average of deadline of N deadlines
     */
    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        int n = deadline.length;
        ArrayList<Integer> result = new ArrayList<Integer>();
        int[][] sequence = new int[n][2]; // SC: O(2 x N)
        int maxDeadline = -1;
        for (int i = 0; i < n; i++) { // TC: O(N)
            sequence[i] = new int[] { deadline[i], profit[i] };
            maxDeadline = Math.max(maxDeadline, deadline[i]);
        }
        // sort the sequence in descending order of profit
        Arrays.sort(sequence, (a, b) -> b[1] - a[1]); // TC: O(N x log(N))
        int jobsCount = 0;
        int totalProfit = 0;
        int[] slot = new int[maxDeadline + 1]; // SC: O(K)
        Arrays.fill(slot, -1);
        for (int i = 0; i < n; i++) { // TC: O(N)
            for (int j = sequence[i][0]; j >= 1; j--) { // TC: O(K)
                if (slot[j] == -1) {
                    jobsCount++;
                    slot[j] = i;
                    totalProfit += sequence[i][1];
                    break;
                }
            }
        }
        result.add(jobsCount);
        result.add(totalProfit);
        return result;
    }
}

/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
*/
