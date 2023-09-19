def solution(beginning, target):
    xor = [[0] * len(beginning[0]) for _ in range(len(beginning))]
    for i in range(len(beginning)):
        for j in range(len(beginning[0])):
            if beginning[i][j] != target[i][j]:
                xor[i][j] = 1
            else:
                xor[i][j] = 0
    
    minimum = 1_000_000
    base_row = xor[0]
    for row in xor:
        diff = 0
        for other_row in xor:
            if row == other_row: continue
            
            temp_row = [1 - i for i in other_row]
            if row == temp_row:
                diff += 1
                continue
            
            return -1
        
        diff += sum(row)
        if diff < minimum:
            base_row = row
            minimum = diff
    
    return minimum