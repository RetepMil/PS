from heapq import heappop, heappush, heapify


def solution(n, paths, gates, summits):
    adjList = [[] for _ in range(n + 1)]

    for a, b, w in paths:
        adjList[a].append([w, b])
        adjList[b].append([w, a])

    is_summit = [False] * (n + 1)
    for summit in summits:
        is_summit[summit] = True

    q = []
    weights = [1e9] * (n + 1)
    for gate in gates:
        weights[gate] = 0
        heappush(q, [0, gate])

    while q:
        weight, node = heappop(q)
        if weight > weights[node] or is_summit[node]:
            continue
        for new_weight, new_node in adjList[node]:
            new_weight = max(weight, new_weight)
            if new_weight < weights[new_node]:
                weights[new_node] = new_weight
                heappush(q, [weights[new_node], new_node])

    answer = [-1, 1e9]
    for summit in sorted(summits):
        if weights[summit] < answer[1]:
            answer[0] = summit
            answer[1] = weights[summit]
    return answer
