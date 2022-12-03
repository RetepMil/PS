from collections import Counter

class Solution:
    def frequencySort(self, s: str) -> str:
        answer = []
        for char, freq in Counter(s).most_common():
            for _ in range(freq):
                answer.append(char)
        return "".join(answer)
