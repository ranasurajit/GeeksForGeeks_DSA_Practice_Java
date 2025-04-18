//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine();
            String[] S = s.split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(S[i]);
            }
            Solution ob = new Solution();
            System.out.println(ob.maxXor(arr));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    /**
     * Approach II : Optimal Approach Using Trie
     * 
     * TC: O(2 x N) ~ O(N)
     * SC: O(32) ~ O(1)
     */
    public int maxXor(int[] arr) {
        int n = arr.length;
        int maxXORValue = Integer.MIN_VALUE;
        BitTrie trie = new BitTrie();
        for (int i = 0; i < n; i++) { // TC: O(N)
            trie.insertDigit(arr[i]);
        }
        // perform check to compare and store maximum XOR value
        for (int i = 0; i < n; i++) { // TC: O(N)
            maxXORValue = Math.max(maxXORValue, trie.getMaxXORPossible(arr[i])); // TC: O(1)
        }
        return maxXORValue;
    }
    
    class BitTrie {
        BitTrieNode root;
        
        class BitTrieNode {
            BitTrieNode left;  // to store 0 bits
            BitTrieNode right; // to store 1 bits
        }
        
        public BitTrie () {
            this.root = new BitTrieNode();
        }
        
        /**
         * Insert digits from left to right bits 
         * 
         * TC: O(32) ~ O(1)
         * SC: O(1)
         */
        private void insertDigit(int num) {
            BitTrieNode crawler = root;
            for (int i = 31; i >= 0; i--) {
                // check ith bit if 0 or 1
                int ithBit = ((num >> i) & 1);
                if (ithBit == 0) {
                    if (crawler.left == null) {
                        crawler.left = new BitTrieNode();
                    }
                    crawler = crawler.left;
                } else {
                    if (crawler.right == null) {
                        crawler.right = new BitTrieNode();
                    }
                    crawler = crawler.right;
                }
            }
        }
        
        /**
         * Performing XOR operations and computing XOR values 
         * 
         * TC: O(32) ~ O(1)
         * SC: O(1)
         */
        private int getMaxXORPossible(int num) {
            BitTrieNode crawler = root;
            int maxXOR = 0;
            for (int i = 31; i >= 0; i--) {
                int ithBit = ((num >> i) & 1);
                if (ithBit == 0) {
                    // we can get maximum value after performing XOR with 1 so move right
                    if (crawler.right != null) {
                        maxXOR += (int) Math.pow(2, i);
                        crawler = crawler.right;
                    } else {
                        // we don't have any option but to move left
                        crawler = crawler.left;
                    }
                } else {
                    // we can get maximum value after performing XOR with 0 so move left
                    if (crawler.left != null) {
                        maxXOR += (int) Math.pow(2, i);
                        crawler = crawler.left;
                    } else {
                        // we don't have any option but to move right
                        crawler = crawler.right;
                    }
                }
            }
            return maxXOR;
        }
    }

    /**
     * Approach I : Brute-Force Approach
     * 
     * TC: O(N ^ 2)
     * SC: O(1)
     */
    public int maxXorApproachI(int[] arr) {
        int n = arr.length;
        int maxXORValue = Integer.MIN_VALUE;
        for (int i = 0; i < n - 1; i++) {     // TC: O(N)
            for (int j = i + 1; j < n; j++) { // TC: O(N)
                maxXORValue = Math.max(maxXORValue, (arr[i] ^ arr[j]));
            }
        }
        return maxXORValue;
    }
}
