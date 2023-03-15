import sys
input = sys.stdin.readline

N = int(input())

def check(num):
    for i in range(2, int(num ** 0.5) + 1):
        if num % i == 0:
            return False
    return True

for i in range(N):
    num = int(input())
    if num == 0 or num == 1:
        print(2)
        continue
    while True:
        if check(num):
            print(num)
            break
        num += 1