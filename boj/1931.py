# 회의실 배정

# import pprint
# pp = pprint.PrettyPrinter(indent=4)

import sys
input = sys.stdin.readline

N = int(input())

infos = []
for _ in range(N):
    start, end = map(int, input().split())
    infos.append([start, end])

infos.sort(key=lambda x : x[0])
infos.sort(key=lambda x : x[1])

answer = 0
pointer = 0
min_start = 0

while pointer < len(infos):
    # 이전 고른 회의보다 더 늦은 시간에 시작하는 회의인 경우
    if min_start <= infos[pointer][0]:
        min_start = infos[pointer][1]
        answer += 1
    pointer += 1

print(answer)