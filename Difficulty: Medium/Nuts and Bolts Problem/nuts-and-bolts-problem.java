//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            char[] nuts = new char[n], bolts = new char[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                nuts[i] = (inputLine[i].charAt(0));
            }
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                bolts[i] = (inputLine[i].charAt(0));
            }

            new Solution().matchPairs(n, nuts, bolts);
            for (int i = 0; i < n; i++) {
                System.out.print(nuts[i] + " ");
            }
            System.out.println();
            for (int i = 0; i < n; i++) {
                System.out.print(bolts[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    void matchPairs(int n, char nuts[], char bolts[]) {
        char[] order = { '!', '#', '$', '%', '&', '*', '?', '@', '^' };
        Map<Character, Integer> hm = new HashMap<Character, Integer>();
        for (int i = 0; i < order.length; i++) {
            hm.put(order[i], i);
        }
        TreeMap<Integer, Character> nutMap = new TreeMap<Integer, Character>();
        TreeMap<Integer, Character> boltMap = new TreeMap<Integer, Character>();
        for (int i = 0; i < n; i++) {
            nutMap.put(hm.get(nuts[i]), nuts[i]);
            boltMap.put(hm.get(bolts[i]), bolts[i]);
        }
        int nutIndex = 0;
        for (Map.Entry<Integer, Character> entry : nutMap.entrySet()) {
            nuts[nutIndex] = entry.getValue();
            nutIndex++;
        }
        int boltIndex = 0;
        for (Map.Entry<Integer, Character> entry : boltMap.entrySet()) {
            bolts[boltIndex] = entry.getValue();
            boltIndex++;
        }
    }
}