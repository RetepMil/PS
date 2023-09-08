package PS;

import java.util.*;

public class ps2293 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();

        List<Integer> coins = new ArrayList<>();
        for (int i = 0; i < n; i++) coins.add(s.nextInt());
        Collections.sort(coins);

        int[] dp = new int[10_001];
        dp[0] = 1;
        for (int coin : coins) for (int i = coin; i < k + 1; i++)
            dp[i] = dp[i] + dp[i - coin];

        System.out.println(dp[k]);
    }
}
