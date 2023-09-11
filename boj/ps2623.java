import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ps2623 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 1; i <= n; i++) map.put(i, new HashSet<>());

        // per PD
        for (int i = 0; i < m; i++) {
            String[] orders = br.readLine().split(" ");
            if (orders.length == 1) continue;
            for (int j = 2; j < orders.length; j++) {
                int node = Integer.parseInt(orders[j]);
                if (!map.containsKey(node))
                    map.put(node, new HashSet<>());
                map.get(node).add(Integer.parseInt(orders[j - 1]));
            }
        }

        Deque<Integer> q = new ArrayDeque<>();
        List<Integer> answer = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (map.get(i).size() == 0) q.add(i);
        }

        while (!q.isEmpty()) {
            int currentNode = q.pollFirst();
            answer.add(currentNode);
            for (int i = 1; i <= n; i++) {
                if (map.get(i).contains(currentNode)) {
                    map.get(i).remove(currentNode);
                    if(map.get(i).size() == 0) q.add(i);
                }
            }
        }

        if (answer.size() != n) System.out.println(0);
        else for (int num : answer) System.out.println(num);
    }
}