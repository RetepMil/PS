import sys
input = sys.stdin.readline

a, b = map(int, input().split(" "))

part_sum = [0]
for i in range(1, b+1):
    for j in range(i):
        part_sum.append(part_sum[-1] + i)

print(part_sum[b] - part_sum[a-1])