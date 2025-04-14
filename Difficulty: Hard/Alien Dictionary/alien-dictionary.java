//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int k = Integer.parseInt(sc.next());
		    
		    String[] words = new String[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        words[i] = sc.next();
		    }
		    
		    Solution ob = new Solution();
		  //  System.out.println(T.findOrder(words,k));
		    String order = ob.findOrder(words,n,k);
		    if(order.length() == 0){
		        System.out.println(0);
		        continue;
		    }
		    if(order.length() != k){
		        System.out.println("INCOMPLETE");
		        return;
		    }
		    String temp[] = new String[n];
		    for(int i=0;i<n;i++)
		        temp[i] = words[i];
		    
		    Arrays.sort(temp, new Comparator<String>(){
		    
		      @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for(int i = 0; i < Math.min(a.length(), b.length()) 
                                        && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }
                
                    if(index1 == index2 && a.length() != b.length()) 
                    {
                        if(a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }
                
                    if(index1 < index2)
                        return -1;
                    else
                        return 1;
                        
                }
		    });
		    
		    int flag = 1;
		    for(int i=0;i<n;i++)
		    {
		        if(!words[i].equals(temp[i]))
	            {
	                flag = 0;
	                break;
	            }
		    }
		    
		    System.out.println(flag);
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    /**
     * Approach : Performing Topological Sort and Cycle Detection Using DFS Approach
     * 
     * TC: O(2 x N x L + (2 x V + E)) ~ O(N x L + V + E))
     * SC: O(3 x V + E) ~ O(V + E)
     */
    public String findOrder(String[] words) {
        int n = words.length;
        boolean[] exist = new boolean[26]; // SC:O(26)
        for (String word : words) { // TC: O(N)
            for (char ch : word.toCharArray()) { // TC: O(L)
                exist[ch - 'a'] = true;
            }
        }
        Map<Integer, ArrayList<Integer>> adj = 
            new HashMap<Integer, ArrayList<Integer>>(); // SC: O(V + E)
        for (int i = 1; i < n; i++) { // TC: O(N)
            String prev = words[i - 1];
            String current = words[i];
            int len = Math.min(prev.length(), current.length());
            boolean found = false;
            for (int j = 0; j < len; j++) { // TC: O(L)
                if (prev.charAt(j) != current.charAt(j)) {
                    found = true;
                    if (!adj.containsKey(prev.charAt(j) - 'a')) {
                        adj.put(prev.charAt(j) - 'a', new ArrayList<Integer>());
                    }
                    if (!adj.containsKey(current.charAt(j) - 'a')) {
                        adj.put(current.charAt(j) - 'a', new ArrayList<Integer>());
                    }
                    adj.get(prev.charAt(j) - 'a').add(current.charAt(j) - 'a');
                    break;
                }
            }
            if (!found && current.length() < prev.length()) { // handle prefix case
                return "";
            }
        }
        // we need to perform topological sort along with cycle detection
        Stack<Integer> st = new Stack<Integer>(); // SC: O(V)
        if (topologicalSort(adj, st, exist)) { // TC: O(V + E), SC: O(V)
            // graph has cycle
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) { // TC: O(V)
            sb.append((char) ((int) 'a' + st.pop()));
        }
        return sb.toString();
    }
    
    /**
     * Performing Topological Sort and Cycle Detection Using DFS Approach
     * 
     * TC: O(V + E)
     * SC: O(V)
     */
    private boolean topologicalSort(Map<Integer, ArrayList<Integer>> adj, 
        Stack<Integer> st, boolean[] exist) {
        boolean[] visited = new boolean[26]; // SC: O(26)
        boolean[] inRecursion = new boolean[26]; // SC: O(26)
        for (int u = 0; u < 26; u++) { // TC: O(26)
            if (exist[u] && !visited[u] && 
                dfsGraphHasCycle(u, adj, visited, inRecursion, st)) { // TC: O(V + E), SC: O(V)
                return true;
            }
        }
        return false;
    }
    
    /**
     * Using DFS Approach
     * 
     * TC: O(V + E)
     * SC: O(V)
     */
    private boolean dfsGraphHasCycle(int u, Map<Integer, ArrayList<Integer>> adj,
        boolean[] visited, boolean[] inRecursion, Stack<Integer> st) {
        visited[u] = true;
        inRecursion[u] = true;
        for (Integer v : adj.getOrDefault(u, new ArrayList<Integer>())) {
            if (!visited[v] && dfsGraphHasCycle(v, adj, visited, inRecursion, st)) {
                return true;
            } else if (inRecursion[v]) {
                return true;
            }
        }
        st.push(u);
        inRecursion[u] = false;
        return false;
    }
}
