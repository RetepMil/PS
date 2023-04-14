import sys, itertools
input = sys.stdin.readline

def get_sums(arr):
    sub = []
    for list_ in [list(map(sum, itertools.combinations(arr, i))) for i in range(len(arr) + 1)]:
        sub.extend(list_)
    return sub

def count_pairs(num, arr):
    if num > C:
        return 0
    
    start = 0
    end = len(arr) - 1
    
    while start <= end:
        mid = (start + end) // 2
        target = arr[mid] + num
        
        if target <= C:
            start = mid + 1
        else:
            end = mid - 1
        
    return start

N, C = map(int, input().split())
weights = list(map(int, input().split()))

lhalf, rhalf = weights[:N // 2], weights[N // 2:]
l_sum, r_sum = get_sums(lhalf), get_sums(rhalf)

r_sum.sort()
count = 0

for num in l_sum:
    count += count_pairs(num, r_sum)

print(count)