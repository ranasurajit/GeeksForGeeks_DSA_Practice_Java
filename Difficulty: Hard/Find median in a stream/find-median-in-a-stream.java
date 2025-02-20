//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String s = sc.nextLine();
            String[] parts = s.split(" ");
            int[] nums = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                nums[i] = Integer.parseInt(parts[i]);
            }
            Solution ob = new Solution();
            ArrayList<Double> ans = ob.getMedian(nums);
            for (double i : ans) {
                System.out.printf("%.1f ", i);
            }
            System.out.println();
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    public ArrayList<Double> getMedian(int[] arr) {
        int n = arr.length;
        ArrayList<Double> medians = new ArrayList<Double>();
        PriorityQueue<Integer> leftMaxHeap = new PriorityQueue<Integer>((p, q) -> q - p);
        PriorityQueue<Integer> rightMinHeap = new PriorityQueue<Integer>((p, q) -> p - q);
        for (int i = 0 ; i < n; i++) {
            leftMaxHeap.offer(arr[i]);
            rightMinHeap.offer(leftMaxHeap.poll());
            if (rightMinHeap.size() > leftMaxHeap.size()) {
                leftMaxHeap.offer(rightMinHeap.poll());
            }
            if (leftMaxHeap.size() > rightMinHeap.size()) {
                medians.add((double) leftMaxHeap.peek());
            } else if (leftMaxHeap.size() == rightMinHeap.size()) {
                medians.add((double) (leftMaxHeap.peek() + rightMinHeap.peek()) / 2);
            }
        }
        return medians;
    }
}
