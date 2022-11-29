import heapq

cases = [
    ([3, 1, 2], 5, 1)
]

def solution(food_times, k):
    if sum(food_times) < k:
        return -1
    
    queue = []
    
    for i, food_time in enumerate(food_times):
        heapq.heappush(queue, (food_time, i + 1))
    
    sumValue = 0
    previous = 0
    length = len(queue)
    while sumValue + ((queue[0][0] - previous) * length) <= k:
        now = heapq.heappop(queue)[0]
        sumValue += (now - previous) * length
        length -= 1
        previous = now
    
    result = sorted(queue, key = lambda x: x[1])
    
    return result[(k - sumValue) % length][1]

for case in cases:
    print(solution(case[0], case[1]))