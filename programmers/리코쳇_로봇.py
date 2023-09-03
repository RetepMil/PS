cases = [
    [["...D..R", ".D.G...", "....D.D", "D....D.", "..D...."], 7],
    [[".D.R", "....", ".G..", "...D"], -1],
]

from collections import deque

dirs = [
    [-1, 0],
    [0, -1],
    [1, 0],
    [0, 1],
]

def solution(board):
    visited = [[-1] * len(board[i]) for i in range(len(board))]

    start = None
    goal = None
    for i in range(len(board)):
        for j in range(len(board[i])):
            if board[i][j] == 'R':
                start = [i, j]
            elif board[i][j] == 'G':
                goal = [i, j]

    q = deque()
    q.append(start)
    depth = 0
    
    while q:
        new_q = deque()
        while q:
            y, x = q.popleft()
            
            if [y, x] == goal:
                return depth
            
            # 처음 오는 지점에는 적절한 로직을 수행한다
            # 왔다 감~
            visited[y][x] = depth
            
            # 갈 수 있는 방향이 있으면 그 지점을 new_q에 추가
            for dy, dx in dirs:
                new_y, new_x = y, x
                
                while True:
                    new_y += dy
                    new_x += dx
                    
                    if not (0 <= new_y < len(board) and 0 <= new_x < len(board[0])):
                        break
                    
                    if board[new_y][new_x] == 'D':
                        break
                
                new_y -= dy
                new_x -= dx
                
                # 그 쪽 방향으로는 갈 수 없음
                if y == new_y and x == new_x:
                    continue
                
                # 이미 왔다 간 지점
                if visited[new_y][new_x] != -1:
                    continue
                
                new_q.append([new_y, new_x])
            
        q = new_q
        depth += 1
    
    return -1

for board, answer in cases:
    print(f"----- CASE START -----")
    print(solution(board))
    print(answer)
    print(f"----- CASE END -----\n\n")