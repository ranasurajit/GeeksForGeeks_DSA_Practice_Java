//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            String str[] = br.readLine().split(" ");
            int arr[] = new int[str.length];

            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            Solution obj = new Solution();

            obj.reverseArray(arr);
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    /**
     * TC: O(N / 2) ~ O(N)
     * SC: O(1)
     */
    public void reverseArray(int arr[]) {
        int low = 0; // pointer for begin
        int high = arr.length - 1; // pointer for end
        while (low < high) {
            // swapping the values of begin and end indices
            arr[low] = arr[low] ^ arr[high];
            arr[high] = arr[low] ^ arr[high];
            arr[low] = arr[low] ^ arr[high];
            low++;
            high--;
        }
    }
}
