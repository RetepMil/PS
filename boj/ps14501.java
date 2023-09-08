package PS;

import java.util.*;

import static java.lang.Math.max;

public class ps14501 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] takes = new int[N+1];
        int[] profits = new int[N+1];
        for (int i = 1; i < N + 1; i++) {
            // 걸리는 일
            takes[i] = sc.nextInt();
            // 이익
            profits[i] = sc.nextInt();
        }

        int[] dp = new int[N+2];
        for (int i = N; i > 0; i--) {
            int take = takes[i];
            int profit = profits[i];

            int endDay = i + take;
            if (endDay > N + 1) dp[i] = dp[i + 1];
            else dp[i] = max(dp[i + 1], dp[endDay] + profit);
        }

        System.out.println(dp[1]);
    }
}