//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] element = line.trim().split("\\s+");
		    int sizeOfArray = Integer.parseInt(element[0]);
		    
		    int arr [] = new int[sizeOfArray];
		    
		    line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    int brr [] = new int[sizeOfArray];
		    
		    line = br.readLine();
		    String[] ele = line.trim().split("\\s+");
		    for(int i = 0;i<sizeOfArray;i++){
		        brr[i] = Integer.parseInt(ele[i]);
		    }
		    
		    Complete obj = new Complete();
		    int res = obj.check(arr, brr, sizeOfArray);
		    
		    System.out.println(res);
		}
	}
}


            

// } Driver Code Ends


            

class Complete {
    
    // Function for finding maximum and value pair
    public static int check (int arr[], int[] brr, int n) {
        // mergeSort(arr, 0, n - 1);
        // mergeSort(brr, 0, n - 1);
        Arrays.sort(arr);
        Arrays.sort(brr);
        int p = 0;
        int q = 0;
        while (p < n && q < n) {
            if (arr[p] != brr[q]) {
                return 0;
            }
            p++;
            q++;
        }
        return 1;
    }
    
    private static void mergeSort(int[] nums, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(nums, low, mid);
            mergeSort(nums, mid + 1, high);
            mergeSortedArrays(nums, low, mid, high);
        }
    }
    
    private static void mergeSortedArrays(int[] nums, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int k = low;
        int[] sorted = new int[nums.length];
        while (i <= mid && j <= high) {
            if (nums[i] <= nums[j]) {
                sorted[k] = nums[i];
                i++;
            } else {
                sorted[k] = nums[j];
                j++;
            }
            k++;
        }
        if (j > high) {
            while (i <= mid) {
                sorted[k++] = nums[i++];
            }
        } else {
            while (j <= high) {
                sorted[k++] = nums[j++];
            }
        }
        for (int p = low; p <= high; p++) {
            nums[p] = sorted[p];
        }
    }
    
}
