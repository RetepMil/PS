import java.util.*;

class Solution {
    List<List<Integer>> adjList;
    int[] record;
    
    private void bfs(int destination) {
        Deque<Integer> q1 = new ArrayDeque<>();
        q1.add(destination);
        int level = 0;
        while (!q1.isEmpty()) {
            Deque<Integer> q2 = new ArrayDeque<>();
            while(!q1.isEmpty()) {
                int popped_node = q1.poll();
                if (record[popped_node] == -1) {
                    record[popped_node] = level;
                    for (int next_node : adjList.get(popped_node))
                        q2.add(next_node);
                }
            }
            level++;
            q1 = q2;
        }
    }

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        adjList = new ArrayList<>();
        record = new int[n];
        
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
            record[i] = -1;
        }
        
        for (int[] road : roads) {
            int from = road[0] - 1;
            int to = road[1] - 1;
            adjList.get(from).add(to);
            adjList.get(to).add(from);
        }
        
        bfs(destination - 1);
        
        int[] answer = new int[sources.length];
        for (int i = 0; i < sources.length; i++)
            answer[i] = record[sources[i] - 1];
        
        return answer;
    }
}