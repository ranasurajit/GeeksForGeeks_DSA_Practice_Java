//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java
class Solution {
    /**
     * TC: O(N ^ 2 + N) ~ O(N ^ 2)
     * SC: O(2 x N) ~ O(N)
     */
    public List<List<Integer>> findTriplets(int[] arr) {
        List<List<Integer>> triplets = new ArrayList<List<Integer>>();
        HashMap<Integer, List<int[]>> map = new HashMap<Integer, List<int[]>>(); // SC: O(N)
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {             // TC: O(N)
            for (int j = i + 1; j < n; j++) {         // TC: O(N)
                int sum = arr[i] + arr[j];
                if (!map.containsKey(sum)) {
                    map.put(sum, new ArrayList<int[]>());
                }
                map.get(sum).add(new int[] { i, j });
            }
        }
        HashSet<List<Integer>> hs = new HashSet<List<Integer>>();     // SC: O(N)
        for (int i = 0; i < n; i++) {                 // TC: O(N)
            if (map.containsKey(-1 * arr[i])) {
                List<int[]> indicesList = map.get(-1 * arr[i]);
                for (int[] indices : indicesList) {
                    if (i != indices[0] && i != indices[1]) {
                        List<Integer> list = Arrays.asList(i, indices[0], indices[1]);
                        Collections.sort(list);
                        hs.add(list);
                    }
                }
            }
        }
        return new ArrayList<List<Integer>>(hs);
    }
    
    /**
     * TC: O(N ^ 3)
     * SC: O(1)
     */
    public List<List<Integer>> findTripletsBruteForce(int[] arr) {
        List<List<Integer>> triplets = new ArrayList<List<Integer>>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {                 // TC: O(N)
            for (int j = i + 1; j < n; j++) {         // TC: O(N)
                for (int k = j + 1; k < n; k++) {     // TC: O(N)
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        triplets.add(Arrays.asList(i, j , k));
                    }
                }
            }
        }
        return triplets;
    }
}


//{ Driver Code Starts.

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String line = read.readLine().trim();
            String[] numsStr = line.split(" ");
            int[] nums = new int[numsStr.length];
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            Solution obj = new Solution();
            List<List<Integer>> res = obj.findTriplets(nums);
            Collections.sort(res, (a, b) -> {
                for (int i = 0; i < a.size(); i++) {
                    if (!a.get(i).equals(b.get(i))) {
                        return a.get(i) - b.get(i);
                    }
                }
                return 0;
            });
            if (res.size() == 0) {
                System.out.println("[]");
            }
            for (int i = 0; i < res.size(); i++) {
                for (int j = 0; j < res.get(i).size(); j++) {
                    System.out.print(res.get(i).get(j) + " ");
                }
                System.out.println();
            }
            System.out.println("~");
        }
    }
}
// } Driver Code Ends