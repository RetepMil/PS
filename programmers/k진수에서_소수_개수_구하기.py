import math

highestNum = 0;
dp = []

def solution(n, k):
    kJinsooedNum = toKJinSoo(n, k)
    print(kJinsooedNum)
    nums = kJinsooedNum.split("0")
    print(nums)
    
    answer = -1
    return answer

def toKJinSoo(num, k):
    # k가 10이라면 바로 리턴
    if k == 10:
        return str(num)
    
    # 변환된 k 진수는 이 변수에 저장
    kJinSoo = ''
    
    # find highest order
    highestOrder = 1;
    while num > (k ** highestOrder):
        highestOrder += 1
    
    # 각 자리 수 계산
    for i in reversed(range(highestOrder)):
        if i == 0:
            continue
        digit = math.floor(num / (k ** i))
        kJinSoo = kJinSoo + str(digit)
        num %= k ** i
    
    # 마지막 자리 숫자 계산
    kJinSoo = kJinSoo + str(num)
    
    return kJinSoo

def isPrime():
    return 1

# Testing
input = [
    (437674, 3),
    (110011, 10)
]
for (n, k) in input:
    print(solution(n, k))