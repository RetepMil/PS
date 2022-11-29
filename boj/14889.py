import sys
input = sys.stdin.readline

N = int(input())

synergy = []
for _ in range(N):
    temp = list(map(int, input().split()))
    synergy.append(temp)

for i in range(N):
    for j in range(N):
        if i != j and i <= j:
            temp = synergy[i][j] + synergy[j][i]
            synergy[i][j] = temp
            synergy[j][i] = temp

global min_diff

min_diff = sys.maxsize

def calc_synergy_diff(team_start, N):
    total_start = 0
    for person1 in team_start:
        for person2 in team_start:
            if person1 != person2:
                total_start += synergy[person1][person2]
    
    total_link = 0
    for person1 in list(set(range(N)) - set(team_start)):
        for person2 in list(set(range(N)) - set(team_start)):
            if person1 != person2:
                total_link += synergy[person1][person2]
    
    return abs(total_start - total_link) // 2

def solution(team_start, N):
    global min_diff
    
    if len(team_start) == N /2:
        min_diff = min(min_diff, calc_synergy_diff(team_start, N))
        return None
    
    for person in range(team_start[-1] if team_start else 0, N):
        if team_start and team_start[0] != 0:
            return None
        if person not in team_start:
            team_start.append(person)
            solution(team_start, N)
            team_start.pop()

solution([], N)

print(min_diff)