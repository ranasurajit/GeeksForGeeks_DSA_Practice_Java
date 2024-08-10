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
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n) {
        // sort the jobs in descending order of profit to perform greedy solution
        Arrays.sort(arr, (p, q) -> q.profit - p.profit);
        // calculating the range for array from 0 to max(deadline)
        int maximumDeadline = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maximumDeadline = Math.max(maximumDeadline, arr[i].deadline);
        }
        int[] sequence = new int[maximumDeadline + 1];
        Arrays.fill(sequence, -1);
        int profit = 0;
        int jobs = 0;
        for (int i = 0; i < n; i++) {
            // we will fill the job with max profit with max deadline value if empty
            for (int j = arr[i].deadline; j > 0; j--) {
                if (sequence[j] == -1) {
                    // if the job slot is free
                    sequence[j] = arr[i].id;
                    profit += arr[i].profit;
                    jobs++;
                    break;
                }
            }
        }
        int[] jobsDone = new int[]{ jobs, profit };
        return jobsDone;
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