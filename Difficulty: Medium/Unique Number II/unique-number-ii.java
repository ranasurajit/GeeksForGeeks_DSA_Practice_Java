//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.HashMap;


// } Driver Code Ends

class Solution {
    /**
     * Approach I : Using Hashing Approach
     * 
     * TC: O(2 x N) ~ O(N)
     * SC: O(N)
     */
    public int[] singleNum(int[] arr) {
        int x = 0;
        int y = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); // SC: O(N)
        for (int item : arr) { // TC: O(N)
            map.put(item, map.getOrDefault(item, 0) + 1);
        }
        for (Integer key : map.keySet()) { // TC: O(N)
            if (map.get(key) == 1) {
                if (x == 0) {
                    x = key;
                } else {
                    y = key;
                }
            } 
        }
        return x < y ? new int[] { x, y } : new int[] { y, x };
    }
}


//{ Driver Code Starts.
public class Main {

    public static void main(String[] args) throws Exception {
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

            // int k = Integer.parseInt(br.readLine());
            // Create Solution object and find closest sum
            Solution ob = new Solution();
            int[] ans = ob.singleNum(arr);

            // Print the result as a space-separated string
            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println(); // New line after printing the results
            System.out.println("~");
        }
    }
}

// } Driver Code Ends