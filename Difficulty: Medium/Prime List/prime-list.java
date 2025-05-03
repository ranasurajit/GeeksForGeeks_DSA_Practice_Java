//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class Node {
    Node next;
    int val;

    public Node(int data) {
        val = data;
        next = null;
    }
}

class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t;
        t = Integer.parseInt(in.readLine());
        while (t-- > 0) {

            Node head, tail;
            String s[] = in.readLine().trim().split(" ");
            int num = Integer.parseInt(s[0]);
            head = new Node(num);
            tail = head;
            for (int i = 1; i < s.length; i++) {
                num = Integer.parseInt(s[i]);
                tail.next = new Node(num);
                tail = tail.next;
            }
            Solution ob = new Solution();
            Node temp = ob.primeList(head);
            while (temp != null) {
                out.print(temp.val + " ");
                temp = temp.next;
            }
            out.println();
            out.println("~");
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java
/*
class Node{
    Node next;
    int val;
    public Node(int data){
        val=data;
        next=null;
    }
}
*/

class Solution {
    /**
     * Approach II : Using Sieve of Eratosthenes + Binary Search Approach
     * 
     * TC: O(Max(head) x log(log(Max(head)))) + O(N x log(Max(head)))
     * SC: O(Max(head))
     */
    Node primeList(Node head) {
        if (head == null) {
            return null;
        }
        // as per constraints 1 <= node.val <= 10^4 so we can pre-compute prime numbers upto 
        ArrayList<Integer> primes = getPrimes((int) 1e4 + 100); // TC: O(Max(head) x log(log(Max(head))))
        Node current = head;
        while (current != null) { // TC: O(N)
            int primeNum = getNearestPrimeNumber(current.val, primes); // TC: O(Max(head))
            current.val = primeNum;
            current = current.next;
        }
        return head;
    }

    /**
     * Approach : Find Lower Bound such that primes' element >= value
     * 
     * TC: O(log(Max(head)))
     * SC: O(1)
     */
    private int lowerBound(int value, ArrayList<Integer> primes) {
        int low = 0;
        int high = primes.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (primes.get(mid) >= value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    /**
     * Approach I : Using Sieve of Eratosthenes Approach
     * 
     * TC: O(Max(head) x log(log(Max(head)))) + O(N x Max(head))
     * SC: O(Max(head))
     */
    Node primeListApproachI(Node head) {
        if (head == null) {
            return null;
        }
        int maxValue = 0;
        Node current = head;
        while (current != null) {
            maxValue = Math.max(maxValue, current.val);
            current = current.next;
        }
        ArrayList<Integer> primes = getPrimes(maxValue); // TC: O(Max(head) x log(log(Max(head))))
        current = head;
        while (current != null) { // TC: O(N)
            int primeNum = getNearestPrimeNumber(current.val, primes); // TC: O(Max(head))
            current.val = primeNum;
            current = current.next;
        }
        return head;
    }
    
    /**
     * TC: O(Max(head))
     * SC: O(1)
     */
    private int getNearestPrimeNumber(int nodeValue, ArrayList<Integer> primes) {
        int index = 0;
        for (int i = 0; i < primes.size(); i++) { // TC: O(N)
            if (primes.get(i) <= nodeValue) {
                index = i;
            }
        }
        if (primes.get(index) == nodeValue) {
            return nodeValue;
        } else {
            int distA = Math.abs(nodeValue - primes.get(index));
            int distB = Math.abs(nodeValue - primes.get(index + 1));
            if ((distA == distB) || (distA < distB)) {
                return primes.get(index);
            } else {
                return primes.get(index + 1);
            }
        }
    }
    
    /**
     * Approach : Using Sieve of Eratosthenes Approach
     * 
     * TC: O(Max(head) x log(log(Max(head))))
     * SC: O(Max(head))
     */
    private ArrayList<Integer> getPrimes(int n) {
        ArrayList<Integer> primeList = new ArrayList<Integer>();
        int[] primes = new int[n + 100];
        Arrays.fill(primes, 1);
        primes[0] = 0;
        primes[1] = 0;
        for (int i = 2; i * i < primes.length; i++) {
            for (int j = i * i; j < primes.length; j += i) {
                primes[j] = 0;
            }
        }
        for (int i = 2; i < primes.length; i++) {
            if (primes[i] == 1) {
                primeList.add(i);
            }
        }
        return primeList;
    }
}
