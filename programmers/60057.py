cases = [
    ["aabbaccc", 7],
    ["ababcdcdababcdcd", 9],
    ["abcabcdede", 8],
    ["abcabcabcabcdededededede", 14],
    ["xababcdcdababcdcd", 17]
]

def solution(s):
    candidates = []
    i = 0
    while i < len(s):
        inspectedStr = ''
        for wordSize in range(1, len(s) - 1):
            if i + wordSize > len(s):
                break
            repetition = 0
            while 
    
    
    ##
    for wordSize in range(1, len(s) // 2 + 1):
        strLength = 0
        j = 0
        while j < (len(s) - wordSize + 1):
            if j == len(s) - wordSize:
                strLength += wordSize - 1
            
            word = s[j:(j + wordSize)] # repeated word
            
            repetition = 0
            while j + wordSize < len(s):
                if word != s[(j + wordSize):(j + 2 * wordSize)]:
                    break
                # print(word, s[(j + wordSize):(j + 2 * wordSize)])
                repetition += 1
                j += wordSize
            
            if repetition > 0:
                print(s[j:j+wordSize], repetition, wordSize)
                strLength += len(str(repetition + 1)) + wordSize
            else:
                strLength += 1
            j += 1  
        ##
        from pprint import pprint
        pprint(locals())
        candidates.append(strLength)
    return min(candidates)


print(solution(cases[2][0]), cases[2][1])

# for i, case in enumerate(cases):
#     print(f"case {str(i)}:")
#     print(solution(case[0]), case[1])