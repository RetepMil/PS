seq = input()
strlen = len(seq)
end_num = 0
for i in range(1, 50):
    if i < 10:
        strlen -= 1
    else:
        strlen -= 2
    
    if strlen == 0:
        end_num = i

ans = []
anslen = 0

record = [[False] * end_num for _ in range(end_num)]

while len(ans) < end_num:
    for i in range(end_num):
        if i in ans or record[len(ans) - 1, i]:
            continue
        token = str(i)