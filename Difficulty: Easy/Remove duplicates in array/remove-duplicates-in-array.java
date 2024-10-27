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

            v = new Solution().removeDuplicate(arr);

            for (int i = 0; i < v.size(); i++) System.out.print(v.get(i) + " ");

            System.out.println();
        
System.out.println("~");
}
    }
}

// } Driver Code Ends

class Solution {
    /**
     * TC: O(2 x N) ~ O(N)
     * SC: O(1)
     */
    ArrayList<Integer> removeDuplicate(int arr[]) {
        int n = arr.length;
        ArrayList<Integer> unique = new ArrayList<Integer>();
        HashSet<Integer> hs = new HashSet<Integer>(); // SC: O(100) ~ O(1)
        for (int i = 0; i < n; i++) { // TC: O(N)
            hs.add(arr[i]);
        }
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (hs.contains(arr[i])) {
                unique.add(arr[i]);
                hs.remove(arr[i]);
            }
        }
        return unique;
    }
}
