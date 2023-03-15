N, M = map(int, input().split())

listens = set()
for _ in range(N):
    listens.add(input())

answer = list()
for _ in range(M):
    hear = input()
    if hear in listens:
        answer.append(hear)

print(len(answer))
for name in sorted(answer):
    print(name)