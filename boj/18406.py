import sys
input = sys.stdin.readline

string = input()

def solution(string_input):
    middle = len(string_input) // 2
    a, b = 0, 0
    
    for char in string_input[:middle]:
        a += int(char)
        
    for char in string_input[middle:-1]:
        b += int(char)
    
    if a == b:
        print("LUCKY")
        return
    print("READY")

solution(string)