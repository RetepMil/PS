import sys
input = sys.stdin.readline

N = int(input())
M = int(input())

def find(city):
    if unions[city] != city:
        unions[city] = find(unions[city])
    return unions[city]

def union(city1, city2):
    city1 = find(city1)
    city2 = find(city2)
    if city1 < city2:
        unions[city2] = city1
    else:
        unions[city1] = city2

path = [list(map(int, input().split())) for _ in range(N)]
for i in range(N):
    path[i][i] = 1

unions = [i for i in range(N)]

for i in range(N):
    for j in range(i + 1, N):
        if path[i][j]:
            union(i, j)

print('Yes' if len(set(map(find, set(map(lambda x: int(x) - 1, input().split()))))) == 1 else 'NO')