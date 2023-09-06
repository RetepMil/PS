package PS;

import java.util.*;

public class ps1922 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PriorityQueue<LinkedList<Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(list -> list.get(2)));

        int N = sc.nextInt();
        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            LinkedList<Integer> entry = new LinkedList<>();
            int from = sc.nextInt() - 1;
            entry.add(from);
            int to = sc.nextInt() - 1;
            entry.add(to);
            int cost = sc.nextInt();
            entry.add(cost);

            pq.offer(entry);
        }

        int[] parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
        int totalFee = 0;

        while (!pq.isEmpty()) {
            List<Integer> entry = pq.poll();

            int a = entry.get(0);
            int b = entry.get(1);
            int fee = entry.get(2);

            if (find(parent, a) != find(parent, b)) {
                union(parent, a, b);
                totalFee += fee;
            }

            if (Arrays.stream(parent).distinct().count() == 1) break;
        }

        System.out.println(totalFee);
    }

    public static void union(int[] parent, int a, int b) {
        int a_parent = find(parent, a);
        int b_parent = find(parent, b);

        if (a_parent < b_parent) {
            parent[b_parent] = a_parent;
        } else {
            parent[a_parent] = b_parent;
        }
    }

    public static int find(int[] parent, int a) {
        if (a == parent[a]) return a;
        return parent[a] = find(parent, parent[a]);
    }
}
