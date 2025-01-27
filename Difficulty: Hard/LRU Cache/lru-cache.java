//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

public class LRUDesign {

    private static List<String> inputLine(Scanner sc) {
        return Arrays.asList(sc.nextLine().split(" "));
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        while (t-- > 0) {
            int capacity = Integer.parseInt(sc.nextLine());
            LRUCache cache = new LRUCache(capacity);

            int queries = Integer.parseInt(sc.nextLine());
            while (queries-- > 0) {
                List<String> vec = inputLine(sc);
                if (vec.get(0).equals("PUT")) {
                    int key = Integer.parseInt(vec.get(1));
                    int value = Integer.parseInt(vec.get(2));
                    cache.put(key, value);
                } else {
                    int key = Integer.parseInt(vec.get(1));
                    System.out.print(cache.get(key) + " ");
                }
            }
            System.out.println();
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// design the class in the most optimal way
/**
 * Using HashMap and ArrayDeque
 *
 * TC: O(1)
 * SC: O(1)
 */
class LRUCache {
    private static ArrayDeque<Integer> deque = null;
    private static Map<Integer, Integer> map;
    private static int n = 0;
    
    // Constructor for initializing the cache capacity with the given value.
    LRUCache(int cap) {
        map = new HashMap<Integer, Integer>();
        deque = new ArrayDeque<Integer>();
        n = cap;
    }

    // Function to return value corresponding to the key.
    public static int get(int key) {
        if (map.containsKey(key)) {
            deque.remove(key);
            deque.addLast(key);
            return map.get(key);
        }
        return -1;
    }

    // Function for storing key-value pair.
    public static void put(int key, int value) {
        if (map.containsKey(key)) {
            deque.remove(key);
        } else {
            if (map.size() >= n) {
                int leastUsedKey = deque.pollFirst();
                map.remove(leastUsedKey);
            }
        }
        map.put(key, value);
        deque.addLast(key);
    }
}
