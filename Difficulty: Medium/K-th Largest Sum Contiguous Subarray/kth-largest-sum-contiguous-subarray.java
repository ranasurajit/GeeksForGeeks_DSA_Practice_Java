//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends

class Solution {
    /**
     * Approach : Using Min-Heap (PriorityQueue) Approach
     * 
     * TC: O(N ^ 2 x log(K))
     * SC: O(K)
     */
    public static int kthLargest(int[] arr, int k) {
        int n = arr.length;
        // Min-Heap to store k elements
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(); // SC:O(K)
        for (int i = 0; i < n; i++) { // TC: O(N)
            int sum = 0;
            for (int j = i; j < n; j++) { // TC: O(N)
                sum += arr[j];
                if (pq.isEmpty() || pq.size() < k) {
                    pq.offer(sum); // TC: log(K)
                } else {
                    if (sum > pq.peek()) {
                        pq.poll(); // TC: log(K)
                        pq.offer(sum); // TC: log(K)
                    }
                }
            }
        }
        return pq.peek();
    }
}


//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }
            int k = Integer.parseInt(br.readLine());

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            Solution obj = new Solution();
            int res = obj.kthLargest(arr, k);

            System.out.println(res);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends