//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            ArrayList<Integer> array1 = new ArrayList<Integer>();
            String line = read.readLine();
            String[] tokens = line.split(" ");
            for (String token : tokens) {
                array1.add(Integer.parseInt(token));
            }
            ArrayList<Integer> v = new ArrayList<Integer>();
            int[] arr = new int[array1.size()];
            int idx = 0;
            for (int i : array1) arr[idx++] = i;

            v = new Solution().modifyAndRearrangeArr(arr);

            for (int i = 0; i < v.size(); i++) System.out.print(v.get(i) + " ");

            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    /**
     * TC: O(N)
     * SC: O(1)
     */
    static ArrayList<Integer> modifyAndRearrangeArr(int arr[]) {
        int n = arr.length;
        int p = 0;
        int q = 1;
        while (p < n && q < n) { // TC: O(N)
            if (arr[p] == arr[q] && arr[p] > 0) {
                arr[p] = 2 * arr[p];
                arr[q] = 0;
            }
            p++;
            q++;
        }
        ArrayList<Integer> list = new ArrayList<Integer>(); // SC: O(N), ignored as it is output
        for (int it : arr) { // TC: O(N)
            if (it > 0) {
                list.add(it);
            }
        }
        while (list.size() < n) {
            list.add(0);
        }
        return list;
    }
}
