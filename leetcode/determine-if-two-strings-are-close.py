from collections import Counter

class Solution:
    def closeStrings(self, word1: str, word2: str) -> bool:
        cntr1 = Counter(word1)
        cntr2 = Counter(word2)
        
        freq1 = [freq for _, freq in cntr1.most_common()]
        freq2 = [freq for _, freq in cntr2.most_common()]
        
        key1 = set([key for key, _ in cntr1.most_common()])
        key2 = set([key for key, _ in cntr2.most_common()])
        
        return freq1 == freq2 and key1 == key2
