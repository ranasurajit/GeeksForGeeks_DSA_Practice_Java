//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        while (T > 0) {
            int x = Integer.parseInt(br.readLine().trim());
            String[] input = br.readLine().trim().split(" ");
            int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();

            Solution solution = new Solution();
            System.out.println(solution.smallestSubWithSum(x, arr));

            T--;
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    /**
     * Using Deque
     * 
     * TC: O(N)
     * SC: O(N)
     */
    public static int smallestSubWithSum(int x, int[] arr) {
        int n = arr.length;
        int minLength = Integer.MAX_VALUE;
        long sum = 0L;
        ArrayDeque<Pair> deque = new ArrayDeque<Pair>(); // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            sum += arr[i];
            if (sum > x) {
                // capturing minLength when sum becomes > x
                minLength = Math.min(minLength, i + 1);
            }
            while (!deque.isEmpty() && sum - deque.peekFirst().sum > x) {
                minLength = Math.min(minLength, i - deque.pollFirst().index);
            }
            deque.addLast(new Pair(i, sum));
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
    
    static class Pair {
        int index;
        long sum;
        public Pair (int index, long sum) {
            this.index = index;
            this.sum = sum;
        }
    }

    /**
     * Using Two Pointers
     * 
     * TC: O(N)
     * SC: O(1)
     */
    public static int smallestSubWithSumUsingTwoPointers(int x, int[] arr) {
        int n = arr.length;
        int minLength = Integer.MAX_VALUE;
        long sum = 0L;
        for (int i = 0, j = 0; j < n; j++) { // TC: O(N)
            sum += arr[j];
            if (sum > x) {
                // capturing minLength when sum becomes > x
                minLength = Math.min(minLength, j - i + 1);
            }
            // capturing minLength if sum becomes > x by shrinking the sub-array length
            while (sum - arr[i] > x) {
                sum -= arr[i];
                i++;
                minLength = Math.min(minLength, j - i + 1);
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
