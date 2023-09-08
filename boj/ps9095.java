package PS;

import java.util.Scanner;

public class ps9095 {
    static int[] dp;
    static int highest;

    static {
        dp = new int[11];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        highest = 3;
    }

    public static int solve(int n) {
        if (dp[n] != 0) return dp[n];
        for (int i = highest + 1; i <= n; i++) {
            for (int j = 1; j <= 3; j++)
                if (i - j > 0)
                    dp[i] += dp[i - j];
        }
        highest = n;
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for (int i = 0; i < n; i++)
            System.out.println(solve(s.nextInt()));
    }
}
