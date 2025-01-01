//{ Driver Code Starts
import java.util.*;


// } Driver Code Ends
class Solution {
    public ArrayList<ArrayList<String>> anagrams(String[] arr) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for (String word : arr) {
            String key = uniqueKey(word);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(word);
        }
        for (String key : map.keySet()) {
            result.add(map.get(key));
        }
        return result;
    }
    
    private String uniqueKey(String word) {
        int[] chars = new int[26];
        for (char ch : word.toCharArray()) {
            chars[ch - 'a']++;
        }
        return Arrays.toString(chars);
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Ignore the newline after the test case input
        while (t-- > 0) {
            String inputLine = sc.nextLine();
            String[] arr = inputLine.split(" ");

            Solution ob = new Solution();
            ArrayList<ArrayList<String>> result = ob.anagrams(arr);
            result.sort(Comparator.comparing(a -> a.get(0)));
            for (ArrayList<String> group : result) {
                for (String word : group) {
                    System.out.print(word + " ");
                }
                System.out.println();
            }
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends