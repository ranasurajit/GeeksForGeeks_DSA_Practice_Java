//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            String[] inputArray = input.split("\\s+");
            ArrayList<Integer> a = new ArrayList<>();

            for (String s : inputArray) {
                a.add(Integer.parseInt(s));
            }

            Solution ob = new Solution();
            ob.sort012(a);

            for (int num : a) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to sort an array of 0s, 1s, and 2s
    
    /**
     * TC: O(N)
     * SC: O(1)
     */
    public void sort012(ArrayList<Integer> arr) {
        int n = arr.size();
        int low = 0, mid = 0, high = n - 1;
        while (mid <= high) {
            if (arr.get(mid) == 0) {
                swap(arr, mid, low);
                low++;
                mid++;
            } else if (arr.get(mid) == 1) {
                mid++;
            } else {
                swap(arr, mid, high);
                high--;
            }
        }
    }
    
    private void swap(ArrayList<Integer> arr, int a, int b) {
        int temp = arr.get(b);
        arr.set(b, arr.get(a));
        arr.set(a, temp);
    }
}
