class Solution:
    def halvesAreAlike(self, s: str) -> bool:
        vowels = ('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
        half1 = len([char for char in s[:len(s) // 2] if char in vowels])
        half2 = len([char for char in s[len(s) // 2:] if char in vowels])
        return half1 == half2
