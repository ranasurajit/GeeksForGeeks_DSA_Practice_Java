//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            String[] inputs = input.split(" ");
            int[] arr = new int[inputs.length];

            for (int i = 0; i < inputs.length; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.findMaxDiff(arr));
        }
    }
}

// } Driver Code Ends


class Solution {
    public int findMaxDiff(int[] arr) {
        int n = arr.length;
        int[] leftMin = new int[n];
        int[] rightMin = new int[n];
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        s1.add(0);
        s2.add(0);
        for (int i = 0; i < n; i++) {
            while (!s1.isEmpty() && arr[i] <= s1.peek()) {
                s1.pop();
            }
            leftMin[i] = s1.peek();
            s1.add(arr[i]);
        }
        for (int i = n - 1; i >= 0; i--) {
            while (!s2.isEmpty() && arr[i] <= s2.peek()) {
                s2.pop();
            }
            rightMin[i] = s2.peek();
            s2.add(arr[i]);
        }
        int diff = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int current = rightMin[i] - leftMin[i];
            if (current < 0) {
                current = current * -1;
            }
            if (diff < current) {
                diff = current;
            }
        }
        return diff;
    }
}
