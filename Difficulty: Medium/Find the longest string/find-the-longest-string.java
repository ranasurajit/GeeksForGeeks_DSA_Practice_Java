class Solution {
    TrieNode root = new TrieNode();
    
    /**
     * Approach : Using Trie Approach
     * 
     * TC: O(N x L)
     * SC: O(N x L)
     * 
     * where L = Max(arr)
     */
    public String longestString(String[] arr) {
        for (String word : arr) { // TC: O(N)
            insertWord(word); // TC: O(L), SC: O(L)
        }
        String result = "";
        for (String word : arr) { // TC: O(N)
            if (hasAllPrefixesInTrie(word) && 
                (word.length() > result.length() || 
                (word.length() == result.length() && word.compareTo(result) < 0))) { // TC: O(L)
                result = word;
            }
        }
        return result;
    }
    
    /**
     * TC: O(L)
     * SC: O(L x 26) ~ O(L)
     */
    private void insertWord(String word) {
        int n = word.length();
        TrieNode crawler = root;
        for (int i = 0; i < n; i++) { // TC: O(L)
            int idx = word.charAt(i) - 'a';
            if (crawler.children[idx] == null) {
                crawler.children[idx] = new TrieNode();
            }
            crawler = crawler.children[idx];
        }
        crawler.isEnd = true;
    }
    
    /**
     * TC: O(L)
     * SC: O(1)
     */
    private boolean hasAllPrefixesInTrie(String word) {
        int n = word.length();
        TrieNode crawler = root;
        for (int i = 0; i < n; i++) { // TC: O(L)
            int idx = word.charAt(i) - 'a';
            crawler = crawler.children[idx];
            if (crawler == null || !crawler.isEnd) {
                return false;
            }
        }
        return true;
    }
    
    static class TrieNode {
        TrieNode[] children;
        boolean isEnd;
        
        public TrieNode() {
            isEnd = false;
            children = new TrieNode[26];
        }
    }
}
