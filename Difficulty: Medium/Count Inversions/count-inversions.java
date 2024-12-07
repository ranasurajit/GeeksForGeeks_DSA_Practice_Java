//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().inversionCount(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to count inversions in the array.
    /**
     * TC: O(N x log(N))
     * SC: O(N)
     */
    static int inversionCount(int arr[]) {
        int n = arr.length;
        int[] count = new int[1];
        mergeSort(arr, 0, n - 1, count);
        return count[0];
    }
    
    /**
     * TC: O(2 x log(N) + N x log(N)) ~ O(N x log(N))
     * SC: O(N)
     */
    private static void mergeSort(int[] arr, int low, int high, int[] count) {
        if (low >= high) {
            return;
        }
        int mid = low + (high - low) / 2;
        mergeSort(arr, low, mid, count);               // TC: O(log(N))
        mergeSort(arr, mid + 1, high, count);          // TC: O(log(N))
        mergeSortedArrays(arr, low, mid, high, count); // TC: O(N x log(N)), SC: O(N)
    }
    
    /**
     * TC: O(N x log(N))
     * SC: O(N)
     */
    private static void mergeSortedArrays(int[] arr, int low, int mid, int high, int[] count) {
        ArrayList<Integer> temp = new ArrayList<Integer>(); // SC: O(N)
        int left = low;
        int right = mid + 1;
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                // increase the count here where arr[left] > arr[right]
                temp.add(arr[right]);
                right++;
                count[0] += (mid - left + 1);
            }
        }
        // push all remaining elements if left pointer is at index <= mid
        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }
        // push all remaining elements if right pointer is at index <= high
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }
        // copying the elements from temp back to array
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }

    /**
     * TC: O(N ^ 2)
     * SC: O(1)
     */
    static int inversionCountBruteForce(int arr[]) {
        int n = arr.length;
        int count = 0;
        for (int i = 0; i < n; i++) {         // TC: O(N)
            for (int j = i + 1; j < n; j++) { // TC: O(N)
                if (arr[i] > arr[j]) {
                    count++;
                }
            }
        }
        return count;
    }
}
