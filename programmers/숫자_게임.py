def solution(A, B):
    n = len(A)
    n = len(B)

    A.sort(reverse=True)
    B.sort(reverse=True)

    answer = 0
    a_pointer = 0
    for i in range(n):
        while a_pointer < n and A[a_pointer] >= B[i]:
            a_pointer += 1
        if a_pointer < n and A[a_pointer] < B[i]:
            answer += 1
            a_pointer += 1

    return answer