import sys
input = sys.stdin.readline

N = int(input())
dp = [0] * (N + 1)
path = [""] * (N + 1)
path[1] = "1"

for i in range(2, N + 1):
    dp[i] = dp[i - 1] + 1
    prev = i - 1
    if i % 2 == 0 and dp[i // 2] < dp[i] - 1:
        dp[i] = dp[i // 2] + 1
        prev = i // 2
    if i % 3 == 0 and dp[i // 3] < dp[i] - 1:
        dp[i] = dp[i // 3] + 1
        prev = i // 3
    path[i] = str(i) + " " + path[prev]

print(dp[N])
print(path[N])