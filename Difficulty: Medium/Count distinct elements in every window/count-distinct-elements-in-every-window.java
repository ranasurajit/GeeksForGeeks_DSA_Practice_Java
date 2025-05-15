//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.HashMap;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            ArrayList<Integer> array = new ArrayList<>();

            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int k = Integer.parseInt(br.readLine());

            ArrayList<Integer> ans = new Solution().countDistinct(arr, k);

            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();

            t--;
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    /**
     * Approach : Using Sliding Window (Fixed Size) Approach
     *
     * TC: O(N)
     * SC: O(N)
     */
    ArrayList<Integer> countDistinct(int arr[], int k) {
        int n = arr.length;
        ArrayList<Integer> distincts = new ArrayList<Integer>();
        int i = 0; // start pointer of sliding window
        int j = 0; // end pointer of sliding window
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); // SC: O(N)
        while (j < n) { // TC: O(N)
            map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                distincts.add(map.size());
                // remove computation of index 'i'
                int freq = map.get(arr[i]);
                if (freq == 1) {
                    map.remove(arr[i]);
                } else {
                    map.put(arr[i], map.getOrDefault(arr[i], 0) - 1);
                }
                // move to next window of size k
                i++;
                j++;
            }
        }
        return distincts;
    }
}
