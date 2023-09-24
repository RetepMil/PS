class Solution {
    public int solution(int n, int count) {
        long[][] dp = new long[n+1][count+1];
        dp[1][1] = 1;
        for (int i = 2; i < n + 1; i++) for (int j = 1; j < count + 1; j++)
                dp[i][j] = (dp[i - 1][j] * (i - 1) * 2 + dp[i - 1][j - 1]) % 1000000007;
        return (int) dp[n][count];
    }
}
