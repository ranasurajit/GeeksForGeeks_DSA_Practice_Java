//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String input = br.readLine();
            String[] inputArray = input.split("\\s+");
            ArrayList<Integer> arr = new ArrayList<>();

            for (String s : inputArray) {
                arr.add(Integer.parseInt(s));
            }

            new Solution().rearrange(arr);
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    /**
     * TC: O(N)
     * SC: O(N)
     */
    void rearrange(ArrayList<Integer> arr) {
        // SC: O(N)
        ArrayList<Integer> pos = new ArrayList<Integer>();
        ArrayList<Integer> neg = new ArrayList<Integer>();
        // TC: O(N)
        for (Integer num : arr) {
            if (num >= 0) {
                pos.add(num);
            } else {
                neg.add(num);
            }
        }
        int p = 0;
        int q = 0;
        int index = 0;
        // TC: O(N) for all below operations
        while (p < pos.size() && q < neg.size()) {
            if (index % 2 == 0) {
                arr.set(index++, pos.get(p++));
            } else {
                arr.set(index++, neg.get(q++));
            }
        }
        while (p < pos.size()) {
            arr.set(index++, pos.get(p++));
        }
        while (q < neg.size()) {
            arr.set(index++, neg.get(q++));
        }
    }
}
