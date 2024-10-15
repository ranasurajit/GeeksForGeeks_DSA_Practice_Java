//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    // Function to count the number of subarrays which adds to the given sum.
    /**
     * TC: O(N)
     * SC: O(N)
     */
    static int subArraySum(int arr[], int tar) {
        int n = arr.length;
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>(); // SC: O(N)
        hm.put(0, 1); // storing sum and it's occurence
        int sum = 0;
        int count = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            sum += arr[i];
            int diff = sum - tar;
            if (hm.containsKey(diff)) {
                count += hm.get(diff);
            }
            hm.put(sum, hm.getOrDefault(sum, 0) + 1);
        }
        return count;
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

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int tar = Integer.parseInt(br.readLine());
            Solution obj = new Solution();
            int res = obj.subArraySum(arr, tar);

            System.out.println(res);
            // System.out.println("~");
        }
    }
}
// } Driver Code Ends