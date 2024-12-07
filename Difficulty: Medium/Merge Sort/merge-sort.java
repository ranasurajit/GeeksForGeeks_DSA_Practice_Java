//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            ArrayList<Integer> array1 = new ArrayList<Integer>();
            String line = read.readLine();
            String[] tokens = line.split(" ");
            for (String token : tokens) {
                array1.add(Integer.parseInt(token));
            }
            ArrayList<Integer> v = new ArrayList<Integer>();
            int[] arr = new int[array1.size()];
            int idx = 0;
            for (int i : array1) arr[idx++] = i;

            new Solution().mergeSort(arr, 0, arr.length - 1);

            for (int i = 0; i < arr.length; i++) System.out.print(arr[i] + " ");

            System.out.println();

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    /**
     * TC: O(N x log(N))
     * SC: O(N)
     */
    void mergeSort(int arr[], int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = l + (r - l) / 2;
        mergeSort(arr, l, mid);            // TC: O(log(N))
        mergeSort(arr, mid + 1, r);        // TC: O(log(N))
        mergeSortedArrays(arr, l, mid, r); // TC: O(N x log(N)), SC: O(N)
    }
    
    private void mergeSortedArrays(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<Integer>();
        int left = low;
        int right = mid + 1;
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
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
}
