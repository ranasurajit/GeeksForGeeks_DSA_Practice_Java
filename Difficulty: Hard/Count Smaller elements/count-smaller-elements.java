//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int arr[] = new int[s.length];
            for (int i = 0; i < s.length; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }

            int[] ans = new Solution().constructLowerArray(arr);
            for (int i = 0; i < arr.length; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int[] constructLowerArray(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        ArrayList<Integer> list = new ArrayList<Integer>();
        int index = 0;
        for (int i = n - 1; i >= 0; i--) {
            int idx = addBinary(list, index, arr[i]);
            ans[i] = idx;
            index++;
        }
        return ans;
    }
    
    private int addBinary(ArrayList<Integer> list, int n, int target) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (list.get(mid) >= target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (low == n) {
            list.add(target);
            return low;
        }
        list.add(low, target);
        return low;
    }
}
