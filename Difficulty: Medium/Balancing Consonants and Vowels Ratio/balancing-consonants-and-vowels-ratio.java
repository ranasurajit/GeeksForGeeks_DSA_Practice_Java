class Solution {
    /**
     * Approach II : Using Optimal (Hashing + Array Prefix) Approach
     * 
     * TC: O(M x N)
     * SC: O(N)
     * 
     * where M = maximum size of StringBuilder formed
     * 
     * Accepted (1115/1115 testcases passed)
     */
    public int countBalanced(String[] arr) {
        int n = arr.length;
        int count = 0;
        Set<Character> vowels = 
            new HashSet<Character>(Arrays.asList('a', 'e', 'i', 'o', 'u')); // SC: O(5)
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); // SC: O(N)
        map.put(0, 1); // added to store Empty "" String which is also balanced
        int prefixSum = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            for (char ch : arr[i].toCharArray()) { // TC: O(M)
                if (vowels.contains(ch)) {
                    prefixSum++;
                } else {
                    prefixSum--;
                }
            }
            if (map.containsKey(prefixSum)) {
                count += map.get(prefixSum);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
    
    /**
     * Approach I : Using Brute-Force (Hashing + StringBuilder) Approach
     * 
     * TC: O(M x N ^ 2)
     * SC: O(M x N)
     * 
     * where M = maximum size of StringBuilder formed
     * 
     * Time Limit Exceeded (1110/1115 testcases passed)
     */
    public int countBalancedBruteForce(String[] arr) {
        int n = arr.length;
        int count = 0;
        Set<Character> vowels = 
            new HashSet<Character>(Arrays.asList('a', 'e', 'i', 'o', 'u')); // SC: O(5)
        for (int i = 0; i < n; i++) { // TC: O(N)
            int vow = 0;
            int con = 0;
            for (int j = i; j < n; j++) { // TC: O(N)
                StringBuilder sb = new StringBuilder(); // SC: O(M)
                sb.append(arr[j].toString());
                for (char ch : sb.toString().toCharArray()) { // TC: O(M)
                    if (vowels.contains(ch)) {
                        vow++;
                    } else {
                        con++;
                    }
                }
                if (vow == con) {
                    count++;
                }
            }
        }
        return count;
    }
}
