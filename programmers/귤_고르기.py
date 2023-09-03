cases = [
    [6, [1, 3, 2, 5, 4, 5, 2, 3], 3],
    [4, [1, 3, 2, 5, 4, 5, 2, 3], 2],
    [2, [1, 1, 1, 1, 2, 2, 2, 3], 1],
]

from collections import Counter

def solution(k, tangerine):
    cnter = Counter(tangerine)
    answer = 0
    in_bag = 0
    for _, freq in cnter.most_common():
        in_bag += freq
        answer += 1
        if in_bag >= k:
            break
    return answer

for a, b, answer in cases:
    print(f"----- CASE START -----")
    print(solution(a, b))
    print(answer)
    print(f"----- CASE END -----\n\n")