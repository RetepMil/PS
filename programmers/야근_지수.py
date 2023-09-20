from heapq import heapify, heappush, heappop

def solution(n, works):
    repl = [-work for work in works]
    heapify(repl)
    for i in range(n):
        heappush(repl, heappop(repl) + 1)
    answer = 0
    for num in repl:
        if num > 0: continue
        answer += num ** 2
    return answer