string = input()
history = set()
answer = 0
for length in range(1, len(string)):
    for i in range(len(string) - length + 1):
        substring = string[i : i + length]
        if substring not in history:
            history.add(substring)
            answer += 1
print(answer + 1)