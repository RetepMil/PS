'''
백조의 호수
--
두 개의 이차원 배열 생성
1. 입력을 받으며 실제로 데이터를 저장하는 배열x
2. 근처에 물이 있는지 체크하는 배열
--
0일차 부터 N일차 까지 다음을 반복한다:
1. DFS로 백조들끼리 만날 수 있는지 확인한다
2. R, C를 순회하며 지워져야하는 블록 체크해서 해당되는 블록을 삭제한다
    2.1 삭제하며 체크하는 배열에 동시에 업데이트를 진행한다
'''

import sys
input = sys.stdin.readline

directions = [[-1, 0], [1, 0], [0, -1], [0, 1]]

def isMoveValid(row, col, R, C):
    if row < 0 or row >= R:
        return False
    if col < 0 or col >= C:
        return False
    return True

def dfs(lakeMap, start):
    visited = [[False] * C for _ in range(R)]
    stack = []
    stack.append(start)
    while stack:
        (row, col) = stack.pop()
        visited[row][col] = True
        element = lakeMap[row][col]
        print(row, col)
        if element == 'L': # Find swan
            return True
        elif element == 'X': # Hit the wall
            continue
        else: # Another water block
            for direction in directions:
                newRow = row + direction[0]
                newCol = col + direction[1]
                if isMoveValid(newRow, newCol, R, C) and not visited[newRow][newCol]:
                    stack.append((newRow, newCol))
    return False

[ R, C ] = list(map(int, input().split(' ')))

lakeMap = [['X'] * C for _ in range(R)]
willMeltMap = [[False] * C for _ in range(R)]

swanPos = []

for i in range(R):
    inputChars = list(input())
    for j, inputChar in enumerate(inputChars[:-1]):
        lakeMap[i][j] = inputChar
        if inputChar == '.':
            willMeltMap[i][j] = True
            for direction in directions:
                row = i + direction[0]
                col = j + direction[1]
                if isMoveValid(row, col, R, C):
                    willMeltMap[row][col] = True
        elif inputChar == 'L':
            lakeMap[i][j] = '.'
            swanPos.append((i, j))

startPos = swanPos[0]
targetPos = swanPos[1]

day = 0
while True:
    if(dfs(lakeMap, startPos)):
        print(day)
    else:
        for i in range(R):
            for j in range(C):
                if willMeltMap[i][j] == True:
                    lakeMap[i][j] = '.'
                    for direction in directions:
                        row = i + direction[0]
                        col = j + direction[1]
                        if isMoveValid(row, col, R, C):
                            willMeltMap[row][col] = True



# for i in range(R):            # 세로 크기
#     for j in range(C):     # 가로 크기
#         print(lakeMap[i][j], end=' ')
#     print()

# for i in range(R):            # 세로 크기
#     for j in range(C):     # 가로 크기
#         print(willMeltMap[i][j], end=' ')
#     print()