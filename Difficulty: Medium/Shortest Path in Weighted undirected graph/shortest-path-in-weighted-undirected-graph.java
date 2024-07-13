//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static PrintWriter ot;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String s[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]), m = Integer.parseInt(s[1]);
            int edges[][] = new int[m][3];
            for (int i = 0; i < m; i++) {
                s = br.readLine().trim().split(" ");
                edges[i][0] = Integer.parseInt(s[0]);
                edges[i][1] = Integer.parseInt(s[1]);
                edges[i][2] = Integer.parseInt(s[2]);
            }

            List<Integer> list = new Solution().shortestPath(n, m, edges);

            ot.println(list.get(0));
            if (list.get(0) != -1 && !check(list, edges)) ot.println(-1);
        }
        ot.close();
    }

    static boolean check(List<Integer> list, int edges[][]) {
        Set<Integer> hs = new HashSet<>();
        Map<Integer, Map<Integer, Integer>> hm = new HashMap<>();
        for (int i = 1; i < list.size(); i++) hs.add(list.get(i));
        for (int x[] : edges) {
            if (hs.contains(x[0]) || hs.contains(x[1])) {
                if (!hm.containsKey(x[0])) hm.put(x[0], new HashMap<>());
                if (!hm.containsKey(x[1])) hm.put(x[1], new HashMap<>());
                hm.get(x[0]).put(x[1], x[2]);
                hm.get(x[1]).put(x[0], x[2]);
            }
        }
        int sum = 0;
        for (int i = 1; i < list.size() - 1; i++) {
            if (!hm.containsKey(list.get(i)) ||
                !hm.get(list.get(i)).containsKey(list.get(i + 1)))
                return false;
            sum += hm.get(list.get(i)).get(list.get(i + 1));
        }
        return sum == list.get(0);
    }
}

// } Driver Code Ends


class Solution {
    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        List<Integer> path = new ArrayList<Integer>();
        ArrayList<ArrayList<Pair>> adj = new ArrayList<ArrayList<Pair>>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<Pair>());
        }
        for (int i = 0; i < m; i++) {
            adj.get(edges[i][0]).add(new Pair(edges[i][2], edges[i][1]));
            adj.get(edges[i][1]).add(new Pair(edges[i][2], edges[i][0]));
        }
        int[] distances = new int[n + 1];
        int[] parents = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            distances[i] = Integer.MAX_VALUE;
            parents[i] = i;
        }
        PriorityQueue<Pair> pq = 
            new PriorityQueue<Pair>((Pair p, Pair q) -> p.distance - q.distance);
        pq.add(new Pair(0, 1));
        distances[1] = 0;
        parents[1] = 1;
        while (!pq.isEmpty()) {
            Pair current = pq.remove();
            int curDist = current.distance;
            int u = current.node;
            for (Pair v : adj.get(u)) {
                if (curDist + v.distance < distances[v.node]) {
                    distances[v.node] = curDist + v.distance;
                    parents[v.node] = u;
                    pq.add(new Pair(curDist + v.distance, v.node));
                }
            }
        }
        if (distances[n] == Integer.MAX_VALUE) {
            path.add(-1);
            return path;
        }
        int node = n;
        while (parents[node] != node) {
            path.add(node);
            node = parents[node];
        }
        path.add(1);
        path.add(distances[n]);
        Collections.reverse(path);
        return path;
    }
    
    class Pair {
        int distance;
        int node;
        
        public Pair(int distance, int node) {
            this.distance = distance;
            this.node = node;
        }
    }
}
