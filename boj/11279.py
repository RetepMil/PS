from heapq import heappop, heappush 

import sys
input = sys.stdin.readline

N = int(input())

hq = []

for _ in range(N):
    num = int(input())
    if num == 0:
        if hq:
            print(-heappop(hq))
        else:
            print(0)
    else:
        heappush(hq, -num)