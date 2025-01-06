//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            ArrayList<Integer> array = new ArrayList<>();

            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int target = Integer.parseInt(br.readLine());

            Solution ob = new Solution();
            List<Integer> res = ob.sumClosest(arr, target);
            if (res.isEmpty()) {
                System.out.print("[]");
            } else {
                for (Integer num : res) {
                    System.out.print(num + " ");
                }
            }
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    /**
     * TC: O(N)
     * SC: O(1)
     */
    public List<Integer> sumClosest(int[] arr, int target) {
        Arrays.sort(arr);
        int n = arr.length;
        List<Integer> result = new ArrayList<Integer>();
        int start = 0;
        int end = n - 1;
        int diff = Integer.MAX_VALUE;
        while (start < end) { // TC: O(N)
            int sum = arr[start] + arr[end];
            if (Math.abs(target - sum) < diff) {
                diff = Math.abs(target - sum);
                result = Arrays.asList(arr[start], arr[end]);
            }
            if (sum > target) {
                end--;
            } else if (sum < target) {
                start++;
            } else {
                return result;   
            }
        }
        return result;
    }
}
