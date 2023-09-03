import sys
input = sys.stdin.readline

H, W = map(int, input().split(" "))
rains = list(map(int, input().split(" ")))

total_volume = 0

pointer = 0
local_max = 0
prev_val = -1
stack = []

for rain in rains:
    pass

print(H, W)
print(rains)

print(total_volume)