import sys
input = sys.stdin.readline

def union(a, b):
    a = find(a)
    b = find(b)
    if a < b:
        parents[b] = a
    else:
        parents[a] = b

def find(a):
    if a != parents[a]:
        parents[a] = find(parents[a])
    return parents[a]

N = int(input())
M = int(input())
parents = [i for i in range(N)]
for i in range(N):
    links = list(map(int, input().split()))
    for j in range(N):
        if links[j] == 1:
            union(i, j)

parents = [-1] + parents
path = list(map(int, input().split()))
union_id = parents[path[0]]
for i in range(1, M):
    if parents[i] != union_id:
        print("NO")
        break
else:
    print("YES")