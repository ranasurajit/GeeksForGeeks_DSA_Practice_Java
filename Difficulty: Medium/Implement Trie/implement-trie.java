//{ Driver Code Starts
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


// } Driver Code Ends

// User function Template for Java
class Trie {
    
    TrieNode root = null;
    
    class TrieNode {
        boolean isEnd;
        TrieNode[] children;
        
        public TrieNode() {
            this.isEnd = false;
            this.children = new TrieNode[26];
        }
    }

    public Trie() {
        root = new TrieNode();
    }

    // Insert a word into the Trie
    /**
     * TC: O(N)
     * SC: O(N x 26) ~ O(N)
     */
    public void insert(String word) {
        int n = word.length();
        TrieNode crawler = root;
        for (int i = 0; i < n; i++) { // TC: O(N)
            int idx = word.charAt(i) - 'a';
            if (crawler.children[idx] == null) {
                crawler.children[idx] = new TrieNode();
            }
            crawler = crawler.children[idx];
        }
        crawler.isEnd = true;
    }

    // Search for a word in the Trie
    /**
     * TC: O(N)
     * SC: O(1)
     */
    public boolean search(String word) {
        int n = word.length();
        TrieNode crawler = root;
        int i = 0;
        for (i = 0; i < n; i++) { // TC: O(N)
            int idx = word.charAt(i) - 'a';
            if (crawler.children[idx] == null) {
                return false;
            }
            crawler = crawler.children[idx];
        }
        return i == n && crawler.isEnd;
    }

    // Check if a prefix exists in the Trie
    /**
     * TC: O(N)
     * SC: O(1)
     */
    public boolean isPrefix(String word) {
        int n = word.length();
        TrieNode crawler = root;
        int i = 0;
        for (i = 0; i < n; i++) { // TC: O(N)
            int idx = word.charAt(i) - 'a';
            if (crawler.children[idx] == null) {
                return false;
            }
            crawler = crawler.children[idx];
        }
        return i == n;
    }
}


//{ Driver Code Starts.

public class GfG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        while (t-- > 0) {
            int q = sc.nextInt();
            sc.nextLine();
            List<Boolean> ans = new ArrayList<>();
            Trie ob = new Trie();

            for (int i = 0; i < q; i++) {
                int x = sc.nextInt();
                String s = sc.next();
                if (i != q - 1) sc.nextLine();

                if (x == 1) {
                    ob.insert(s);
                } else if (x == 2) {
                    ans.add(ob.search(s));
                } else if (x == 3) {
                    ans.add(ob.isPrefix(s));
                }
            }

            for (Boolean result : ans) {
                System.out.print(result + " ");
            }
            System.out.println();
            System.out.println("~");
        }

        sc.close();
    }
}

// } Driver Code Ends