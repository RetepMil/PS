cases = [
    [2, ""],
    [4, "[1,2,9,3,10,8,4,5,6,7]"],
    [5, "[1,2,12,3,13,11,4,14,15,10,5,6,7,8,9]"],
    [6, "[1,2,15,3,16,14,4,17,21,13,5,18,19,20,12,6,7,8,9,10,11]"],
    [7, ""]
]

def solution(n):
    if n == 1:
        return [1]
    
    full_arr = []
    for i in range(n):
        full_arr.append([0] * (i+1))
    
    MAX = sum([i for i in range(1, n+1)])
    cnter = 1
    row, col = -1, 0
    
    while cnter <= MAX:
        # go down
        row += 1
        while full_arr[row][col] == 0:
            full_arr[row][col] = cnter
            cnter += 1
            row += 1
            if row == len(full_arr):
                break
        row -= 1
        
        # go left
        col += 1
        while full_arr[row][col] == 0:
            full_arr[row][col] = cnter
            cnter += 1
            col += 1
            if col == len(full_arr[row]):
                break
        col -= 1
        
        # go up
        row -= 1
        col -= 1
        while full_arr[row][col] == 0:
            full_arr[row][col] = cnter
            cnter += 1
            row -= 1
            col -= 1
            if row == len(full_arr):
                break
        row += 1
        col += 1
    
    answer = []
    for arr in full_arr:
        answer.extend(arr)
    
    return answer


for param, answer in cases:
    print(f"----- CASE START -----")
    print(solution(param))
    print(answer)
    print(f"----- CASE END -----\n\n")