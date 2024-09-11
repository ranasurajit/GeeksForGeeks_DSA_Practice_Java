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
     * TC: O(N + M)
     * SC: O(1)
     */
    public static ArrayList<Integer> printClosest (int arr[], int brr[], int n, int m, int x) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int val1 = -1;
        int val2 = -1;
        // using the property of sorted Array
        int p = 0; // pointer for Array arr
        int q = m - 1; // pointer for Array brr
        int diff = Integer.MAX_VALUE;
        while (p < n && q >= 0) {
            if (arr[p] + brr[q] == x) {
                val1 = arr[p];
                val2 = brr[q];
                break;
            } else if (arr[p] + brr[q] < x) {
                if (diff > Math.abs(arr[p] + brr[q] - x)) {
                    diff = Math.abs(arr[p] + brr[q] - x);
                    val1 = arr[p];
                    val2 = brr[q];
                }
                p++;
            } else {
                if (diff > Math.abs(arr[p] + brr[q] - x)) {
                    diff = Math.abs(arr[p] + brr[q] - x);
                    val1 = arr[p];
                    val2 = brr[q];
                }
                q--;
            }
        }
        result.add(val1);
        result.add(val2);
        return result;
    }
}
