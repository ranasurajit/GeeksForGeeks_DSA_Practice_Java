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

class Solution
{
    public String findOrder(String[] dict, int N, int K) {
        HashMap<Integer, ArrayList<Integer>> adj = createGraph(dict, N, K);
        String order = topoSort(adj, N, K);
        return order;
    }
    
    private String topoSort(HashMap<Integer, ArrayList<Integer>> adj, int n, int k) {
        StringBuilder sb = new StringBuilder();
        int[] indegrees = new int[k];
        for (int i = 0; i < k; i++) {
            for (Integer it : adj.get(i)) {
                indegrees[it]++;
            }
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < k; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            Integer u = queue.poll();
            char ch = (char) (u + 'a');
            sb.append(ch);
            for (Integer v : adj.get(u)) {
                indegrees[v]--;
                if (indegrees[v] == 0) {
                    queue.offer(v);
                }
            }
        }
        return sb.length() == k ? sb.toString() : "";
    }
    
    private HashMap<Integer, ArrayList<Integer>> createGraph(String[] dict, int n, int k) {
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < k; i++) {
            adj.put(i, new ArrayList<Integer>());
        }
        for (int i = 0; i < n - 1; i++) {
            int m = Math.min(dict[i].length(), dict[i + 1].length());
            for (int j = 0; j < m; j++) {
                if (dict[i].charAt(j) != dict[i + 1].charAt(j)) {
                    adj.get(dict[i].charAt(j) - 'a').add(dict[i + 1].charAt(j) - 'a');
                    break;
                }
            }
        }
        return adj;
    }
}
