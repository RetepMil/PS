import sys
input = sys.stdin.readline

string = input()

if len(string) == 0:
    print(0)

appearance = 1
currentChar = string[0]
for char in string:
    if char != currentChar:
        appearance += 1
        currentChar = char
        
print((appearance - 1) // 2)