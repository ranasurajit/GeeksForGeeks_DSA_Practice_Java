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
 * Using HashMap and DoublyLinkedList
 *
 * TC: O(1)
 * SC: O(1)
 */
class LRUCache {
    private static Map<Integer, Node> map;
    private static int capacity;
    private static Node head;
    private static Node tail;
    
    // Constructor for initializing the cache capacity with the given value.
    LRUCache(int cap) {
        this.map = new HashMap<Integer, Node>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        this.capacity = cap;
    }
    
    /**
     * We will be pushing recent put/get values just after the Head Node
     */
    private static void insertAfterHead(Node node) {
        Node headNext = head.next;
        head.next = node;
        node.next = headNext;
        headNext.prev = node;
        node.prev = head;
        map.put(node.key, node);
    }
    
    /**
     * We will be deleting any Node from the DoublyLinkedList
     */
    private static void deleteNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        map.remove(node.key);
    }

    // Function to return value corresponding to the key.
    public static int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        // we need to remove it from LinkedList and insert it after Head Node
        deleteNode(node);
        insertAfterHead(node);
        return node.val;
    }

    // Function for storing key-value pair.
    public static void put(int key, int value) {
        if (map.containsKey(key)) {
            // we need to update the value
            deleteNode(map.get(key));
        } else {
            if (map.size() == capacity) {
                deleteNode(tail.prev);
            }
        }
        Node newNode = new Node(key, value);
        insertAfterHead(newNode);
    }
    
    static class Node {
        int key;
        int val;
        Node prev;
        Node next;
        
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}

/**
 * Using HashMap and ArrayDeque
 *
 * TC: O(1)
 * SC: O(1)
 */
class LRUCacheDeque {
    private static ArrayDeque<Integer> deque = null;
    private static Map<Integer, Integer> map;
    private static int n = 0;
    
    // Constructor for initializing the cache capacity with the given value.
    LRUCacheDeque(int cap) {
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

