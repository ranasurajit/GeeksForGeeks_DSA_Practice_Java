//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                out.print(ans.get(i)+" ");
            }
            out.println();
                        
        }
        out.close();
	}
}


// } Driver Code Ends


class Solution {
    public List<String> find_permutation(String S) {
        List<String> list = new ArrayList<String>();
        Set<String> hs = new HashSet<String>();
        char[] ch = S.toCharArray();
        combinations(0, ch, hs);
        for (String it : hs) {
            list.add(it);
        }
        Collections.sort(list);
        return list;
    }
    
    private void combinations(int index, char[] ch, Set<String> hs) {
        // Base case
        if (index == ch.length) {
            hs.add(new String(ch));
            return;
        }
        // Try swapping each and every character in String S i.e. in char[] ch
        for (int i = index; i < ch.length; i++) {
            swap(ch, i, index);
            combinations(index + 1, ch, hs);
            swap(ch, i, index);
        }
    }
    
    private void swap(char[] ch, int a, int b) {
        char temp = ch[b];
        ch[b] = ch[a];
        ch[a] = temp;
    }

}
