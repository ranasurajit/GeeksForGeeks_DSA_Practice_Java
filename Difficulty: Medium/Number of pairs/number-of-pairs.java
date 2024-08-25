//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int x[] = new int[str.length];
            for (int i = 0; i < str.length; i++) x[i] = Integer.parseInt(str[i]);
            str = (br.readLine()).trim().split(" ");
            int[] y = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                y[i] = Integer.parseInt(str[i]);
            }
            System.out.println(new Solution().countPairs(x, y, x.length, y.length));
        }
    }
}

// } Driver Code Ends


//Back-end complete function Template for Java
class Solution {
    // Function to count number of pairs such that x^y is greater than y^x.
    /**
     * TC: O(Mlog(M)) + O(Nlog(N)) + O(M) + O(N) ~ O(Mlog(M) + Nlog(N))
     * SC: O(1)
     * 
     */
    public long countPairs(int x[], int y[], int M, int N) {
        Arrays.sort(x); // TC: O(Mlog(M))
        Arrays.sort(y); // TC: O(Nlog(N))
        int count0s = 0;
        int count1s = 0;
        int count2s = 0;
        int count3s = 0;
        int count4s = 0;
        for (int i = 0; i < N; i++) { // TC: O(N)
            if (y[i] == 0) {
                count0s++;
            }
            if (y[i] == 1) {
                count1s++;
            }
            if (y[i] == 2) {
                count2s++;
            }
            if (y[i] == 3) {
                count3s++;
            }
            if (y[i] == 4) {
                count4s++;
            }
        }
        long pairs = 0L;
        for (int i = 0; i < M; i++) { // TC: O(M)
            if (x[i] == 0){ // does not contribute anything
                continue;
            } else if (x[i] == 1) {
                pairs += count0s;
            } else if (x[i] == 2) {
                int count = findIndexMoreThan(y, N, x[i]);
                if (count != -1) {
                    pairs += N - count;
                }
                pairs -= count3s;
                pairs -= count4s;
                pairs += count0s;
                pairs += count1s;
            } else {
                int count = findIndexMoreThan(y, N, x[i]);
                if (count != -1) {
                    pairs += N - count;
                }
                if (x[i] == 3) {
                    pairs += count2s;
                }
                pairs += count0s;
                pairs += count1s;
            }
        }
        return pairs;
    }
    
    private int findIndexMoreThan(int[] y, int n, int target) {
        int low = 0;
        int high = n - 1;
        int index = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (y[mid] > target) {
                index = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return index;
    }
}
