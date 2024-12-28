//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            // First array input
            String[] str1 = br.readLine().trim().split(
                " "); // Read the first line and split by spaces
            int n = str1.length;
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str1[i]); // Convert each element to an integer
            }

            // Second array input
            String[] str2 = br.readLine().trim().split(
                " "); // Read the second line and split by spaces
            int m = str2.length;
            int[] b = new int[m];
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(str2[i]); // Convert each element to an integer
            }

            Solution sol = new Solution();
            ArrayList<Integer> res = sol.intersectionWithDuplicates(a, b);

            // Sort the result
            Collections.sort(res);

            // Print the result
            if (res.isEmpty()) {
                System.out.println("[]");
            } else {
                for (int num : res) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    /**
     * TC: O(M + N)
     * SC: O(Min(M, N))
     */
    public ArrayList<Integer> intersectionWithDuplicates(int[] a, int[] b) {
        // swap arrays to make array 'a' always smaller
        if (a.length > b.length) {
            int[] temp = b;
            b = a;
            a = temp;
        }
        Set<Integer> set = new HashSet<Integer>(); // SC: O(Min(M, N))
        for (int i = 0; i < a.length; i++) {       // TC: O(M)
            set.add(a[i]);
        }
        Set<Integer> common = new HashSet<Integer>();
        for (int i = 0; i < b.length; i++) {       // TC: O(N)
            if (set.contains(b[i])) {
                common.add(b[i]);
            }
        }
        return new ArrayList<Integer>(common);
    }
}
