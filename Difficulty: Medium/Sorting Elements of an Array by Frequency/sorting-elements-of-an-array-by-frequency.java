//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.Map.Entry;


// } Driver Code Ends
// User function Template for Java

class Solution {
    // Function to sort the array according to frequency of elements.
    public ArrayList<Integer> sortByFreq(int arr[]) {
        int n = arr.length;
        ArrayList<Integer> sorted = new ArrayList<Integer>();
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((Pair p, Pair q) -> {
            if (p.freq == q.freq) {
                return p.elem - q.elem;
            } else {
                return q.freq - p.freq;
            }
        });
        for (Integer key : hm.keySet()) {
            pq.offer(new Pair(key, hm.get(key)));
        }
        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int freq = current.freq;
            for (int i = 0; i < freq; i++) {
                sorted.add(current.elem);
            }
        }
        return sorted;
    }
    
    class Pair {
        int elem;
        int freq;
        public Pair (int elem, int freq) {
            this.elem = elem;
            this.freq = freq;
        }
    }
}

//{ Driver Code Starts.

class Driverclass {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sc.readLine());
        while (n != 0) {
            String input = sc.readLine();
            String[] inputs = input.split(" ");
            int[] arr = new int[inputs.length];

            for (int i = 0; i < inputs.length; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
            }

            ArrayList<Integer> ans = new ArrayList<Integer>();
            ans = new Solution().sortByFreq(arr);
            for (int i = 0; i < ans.size(); i++) System.out.print(ans.get(i) + " ");
            System.out.println();
            n--;
        }
    }
}

// } Driver Code Ends