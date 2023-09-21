def solution(routes):
    routes.sort(key=lambda a: [a[1], a[0]])
    answer = 0
    pointer = 0
    start, target_end = routes[0]
    while True:
        while pointer < len(routes):
            start = routes[pointer][0]
            if start > target_end: break
            target_end = min(target_end, routes[pointer][1])
            pointer += 1
        answer += 1
        if pointer >= len(routes): break
        start, target_end = routes[pointer]
    return answer