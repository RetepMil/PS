import java.util.*;
import java.lang.Math;

class Solution {
    private long cnt = 0;
    private long[] info;
    private ArrayList<Integer>[] adj;
    private boolean[] visited;
    
    private long balance(int node) {
        visited[node] = true;
        long positive = 0;
        long negative = 0;
        for (int i = 0; i < adj[node].size(); i++) {
            int child = adj[node].get(i);
            if (visited[child]) continue;
            long sum = balance(child);
            cnt += Math.abs(sum);
            if (sum < 0)
                negative += sum;
            else
                positive += sum;
        }
        return positive + negative + (long) info[node];
    }
    
    public long solution(int[] a, int[][] edges) {
        this.adj = new ArrayList[a.length];
        this.info = new long[a.length];
        this.visited = new boolean[a.length];
        
        for (int i = 0; i < a.length; i++) {
            info[i] = a[i];
            adj[i] = new ArrayList<>();
            this.cnt += a[i];
        }
        
        if (this.cnt != 0) return -1;
        this.cnt = 0;
        
        for (int i = 0; i < edges.length; i++) {
            adj[edges[i][0]].add(edges[i][1]);
            adj[edges[i][1]].add(edges[i][0]);
        }
        
        balance(0);
        
        return this.cnt;
    }
}
