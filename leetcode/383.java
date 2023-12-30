class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] map = new int[26];
        for (char c : magazine.toCharArray())
            map[(int) c - 97]++;
        for (char c : ransomNote.toCharArray()) {
            if (map[(int) c - 97]-- <= 0) return false;
        }
        return true;
    }
}
