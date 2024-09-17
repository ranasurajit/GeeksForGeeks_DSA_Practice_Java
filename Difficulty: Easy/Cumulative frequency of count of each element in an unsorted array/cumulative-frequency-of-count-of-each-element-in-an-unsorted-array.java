//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    /**
     * TC: O(Nlog(N) + N) ~ O(Nlog(N))
     * SC: O(N)
     */
    public int[] countFreq(int arr[]) {
        TreeMap<Integer, Integer> hm = new TreeMap<Integer, Integer>(); // SC: O(N)
        for (int it : arr) { // TC: O(N)
            hm.put(it, hm.getOrDefault(it, 0) + 1); // TC: O(log(N)) - ordered Map
        }
        int[] cumFreq = new int[hm.size()];
        int index = 0;
        int sum = 0;
        for (Integer key : hm.keySet()) { // TC: O(N)
            sum += hm.get(key);
            cumFreq[index++] = sum;
        }
        return cumFreq;
    }
}


//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            // int k = Integer.parseInt(br.readLine());
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
            Solution obj = new Solution();
            int answer[] = obj.countFreq(arr);
            int sz = answer.length;

            StringBuilder output = new StringBuilder();
            for (int i = 0; i < sz; i++) output.append(answer[i] + " ");
            System.out.println(output);
        }
    }
}
// } Driver Code Ends