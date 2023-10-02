package PS;

import java.util.Scanner;

public class ps1865 {

    private static final Scanner s = new Scanner(System.in);

    private static void solve() {
        int N = s.nextInt();
        int M = s.nextInt();
        int W = s.nextInt();

        int[][] edges = new int[2*M+W][3];
        for (int i = 0; i < M; i++) {
            int start = s.nextInt();
            int end = s.nextInt();
            int time = s.nextInt();
            edges[2*i] = new int[]{ start, end, time };
            edges[2*i+1] = new int[]{ end, start, time };
        }
        for (int i = 2 * M; i < 2 * M + W; i++)
            edges[i] = new int[]{s.nextInt(), s.nextInt(), -s.nextInt()};

        int[] distance = new int[N+1];
        int MAX = 10_000_000;
        for (int i = 1; i < N+1; i++)
            distance[i] = MAX;
        for (int i = 0; i < N; i++) {
            for (int[] edge : edges) {
                int start = edge[0];
                int end = edge[1];
                int time = edge[2];
                if (distance[start] + time < distance[end])
                    distance[end] = distance[start] + time;
            }
        }
        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            int time = edge[2];
            if (distance[start] + time < distance[end]) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }

    public static void main(String[] args) {
        int TC = s.nextInt();
        for (int i = 0; i < TC; i++)
            solve();
    }

}

