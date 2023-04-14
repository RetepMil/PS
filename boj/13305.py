import sys
input = sys.stdin.readline

N = int(input())

distances = list(map(int, input().split())) + [0]
prices = list(map(int, input().split()))

ans = 0
prev_price = prices[0]

for i in range(N):
    distance = distances[i]
    price = prices[i]
    
    prev_mul = prev_price * distance
    curr_mul = price * distance
    
    if prev_mul < curr_mul:
        ans += prev_mul
    else:
        prev_price = price
        ans += curr_mul

print(ans)