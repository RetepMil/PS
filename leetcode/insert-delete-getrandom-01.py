from random import random

class RandomizedSet:

    def __init__(self):
        self.values = defaultdict(bool)

    def insert(self, val: int) -> bool:
        if val in self.values.keys():
            return False
        self.values[val] = True
        return True

    def remove(self, val: int) -> bool:
        if val in self.values.keys():
            del self.values[val]
            return True
        return False
        
    def getRandom(self) -> int:
        index = int(random() * len(self.values))
        return list(self.values)[index]
