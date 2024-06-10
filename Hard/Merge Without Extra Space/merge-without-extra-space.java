//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.io.*;

public class Main
{
    public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    String inputLine[] = br.readLine().trim().split(" ");
		    int n = Integer.parseInt(inputLine[0]);
		    int m = Integer.parseInt(inputLine[1]);
		    long arr1[] = new long[n];
		    long arr2[] = new long[m];
		    inputLine = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr1[i] = Long.parseLong(inputLine[i]);
		    }
		    inputLine = br.readLine().trim().split(" ");
		    for(int i=0; i<m; i++){
		        arr2[i] = Long.parseLong(inputLine[i]);
		    }
		    Solution ob = new Solution();
		    ob.merge(arr1, arr2, n, m);
		    
		    StringBuffer str = new StringBuffer();
		    for(int i=0; i<n; i++){
		        str.append(arr1[i]+" ");
		    }
		    for(int i=0; i<m; i++){
		        str.append(arr2[i]+" ");
		    }
		    System.out.println(str);
		}
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to merge the arrays.
    public static void merge(long arr1[], long arr2[], int n, int m) 
    {
        int p = 0;
        int q = 0;
        long[] result = new long[n + m];
        int r = 0;
        while (p < n && q < m) {
            if (arr1[p] <= arr2[q]) {
                result[r] = arr1[p];
                p++;
            } else {
                result[r] = arr2[q];
                q++;
            }
            r++;
        }
        if (q >= m) {
            while (p < n) {
                result[r++] = arr1[p++];
            }
        } else {
            while (q < m) {
                result[r++] = arr2[q++];
            }
        }
        for (int i = 0; i < (n + m); i++) {
            if (i < n)
                arr1[i] = result[i];
            else {
                arr2[i - n] = result[i];
            }
        }
    }
}
