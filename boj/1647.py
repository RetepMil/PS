import sys
input = sys.stdin.readline

N, M = map(int, input().split())

cost_list = []

for _ in range(M):
    fro, to, cost = map(int, input().split())
    cost_list.append((cost, fro, to))

def find(node_id):
    if union[node_id] != node_id:
        union[node_id] = find(union[node_id])
    return union[node_id]

def union_func(a, b):
    a_union = find(a)
    b_union = find(b)
    if a_union < b_union:
        union[b_union] = a_union
    else:
        union[a_union] = b_union

cost_list.sort()

union = []
for i in range(N + 1):
    union.append(i)

answer = 0
last = 0
for cost, fro, to in cost_list:
    if find(fro) != find(to):
        union_func(fro, to)
        answer += cost
        last = cost

print(answer - last)