//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            int []arr=new int[N];
            for(int i=0;i<N;i++){
                arr[i]=sc.nextInt();
                
            }
            Solution obj=new Solution();
            int res=obj.minimumEnergy(arr,N);
            System.out.println(res);
            
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution{
    /**
     * TC: O(N)
     * SC: O(N)
     */
    public int minimumEnergy(int arr[],int N){
        int[] dp = new int[N]; // SC: O(N)
        dp[0] = 0;
        // dp[1] = Math.abs(arr[1] - arr[0]) + dp[0];
        // dp[2] = Math.min(Math.abs(arr[2] - arr[1]) + dp[1], Math.abs(arr[2] - arr[0]) + dp[0]);
        for (int i = 1; i < N; i++) { // TC: O(N)
            int x = Math.abs(arr[i] - arr[i - 1]) + dp[i - 1];
            int y = Integer.MAX_VALUE;
            if (i > 1) {
                y = Math.abs(arr[i] - arr[i - 2]) + dp[i - 2];
            }
            dp[i] = Math.min(x, y);
        }
        return dp[N - 1];
    }
}
