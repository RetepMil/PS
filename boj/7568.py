N = int(input())

infos = []
for _ in range(N):
    infos.append(tuple(map(int, input().split())))
    
rank_arr = []
for weight, height in infos:
    rank = 1
    for weight__, height__ in infos:
        if weight__ > weight and height__ > height:
            rank += 1
    rank_arr.append(str(rank))
    
answer = " ".join(rank_arr)
print(answer)