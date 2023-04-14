import sys
input = sys.stdin.readline

N, S = map(int, input().split())
nums = list(map(int, input().split()))

ans = 999999
left, right = 0, 0
total = nums[0]

while True:
    if total >= S:
        total -= nums[left]
        ans = min(ans, right - left + 1)
        left += 1
    else:
        right += 1
        if right == N:
            break
        total += nums[right]

print(0 if ans == 999999 else ans)