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

            v = new Solution().alternateSort(arr);

            for (int i = 0; i < v.size(); i++) System.out.print(v.get(i) + " ");

            System.out.println();
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    /**
     * TC: O(N x log(N) + N / 2) ~ O(N x log(N))
     * SC: O(1)
     */
    public static ArrayList<Integer> alternateSort(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr); // TC: O(N x log(N))
        ArrayList<Integer> sorted = new ArrayList<Integer>();
        int p = 0;
        int q = n - 1;
        while (p < q) { // TC: O(N / 2)
            sorted.add(arr[q]);
            sorted.add(arr[p]);
            q--;
            p++;
        }
        if (n % 2 != 0) {
            sorted.add(arr[p]);
        }
        return sorted;
    }
}
