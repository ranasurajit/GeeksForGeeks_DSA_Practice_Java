//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class GFG {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String[] element = br.readLine().split(" ");
		    int N = Integer.parseInt(element[0]);
		    int M = Integer.parseInt(element[1]);
		    int arr [] = new int[N];
		    int brr [] = new int[M];
		    String[] elements = br.readLine().split(" ");
		    for(int i=0; i<N; i++)
		        arr[i] = Integer.parseInt(elements[i]);
		        
		    String[] ele = br.readLine().split(" ");
		    for(int i=0; i<M; i++)
		        brr[i] = Integer.parseInt(ele[i]);
		    
		    int X = Integer.parseInt(br.readLine());
		    
		    Solution obj = new Solution();
		    ArrayList<Integer> ans;
		    ans = obj.printClosest(arr, brr, N, M, X);
		    System.out.println(Math.abs(ans.get(0) + ans.get(1) - X));
		}
	}
}


// } Driver Code Ends


//User function Template for Java

class Solution{
    // Function for finding maximum and value pair
    /**
     * TC: O(M + N)
     * SC: O(1)
     */ 
    public static ArrayList<Integer> printClosest (int arr[], int brr[], int n, int m, int x) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int num1 = -1;
        int num2 = -1;
        int p = 0; // pointer for arr
        int q = m - 1; // pointer for brr
        int minDiff = Integer.MAX_VALUE;
        while (p < n && q >= 0) {
            int sum = arr[p] + brr[q];
            if (sum == x) {
                num1 = arr[p];
                num2 = brr[q];
                break;
            } else if (sum > x) {
                if (minDiff > sum - x) {
                    minDiff = sum - x;
                    num1 = arr[p];
                    num2 = brr[q];
                }
                q--;
            } else {
                if (minDiff > x - sum) {
                    minDiff = x - sum;
                    num1 = arr[p];
                    num2 = brr[q];
                }
                p++;
            }
        }
        result.add(num1);
        result.add(num2);
        return result;
    }
}
