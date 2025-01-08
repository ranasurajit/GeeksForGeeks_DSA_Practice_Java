//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            System.out.println(new Solution().countTriangles(arr));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to count the number of possible triangles.
    /**
     * Using Two Pointers Approach
     * 
     * TC: O(N x log(N) + N ^ 2) ~ O(N ^ 2)
     * SC: O(1)
     */
    static int countTriangles(int arr[]) {
        int n = arr.length;
        Arrays.sort(arr);                  // TC: O(N x log(N))
        int count = 0;
        for (int i = n - 1; i >= 2; i--) { // TC: O(N)
            int left = 0;
            int right = i - 1;
            while (left < right) {         // TC: O(N)
                int sum = arr[left] + arr[right];
                if (sum > arr[i]) {
                    count += right - left;
                    right--;
                } else {
                    left++;
                }
            }
        }
        return count;
    }
}
