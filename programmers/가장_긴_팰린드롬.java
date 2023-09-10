class Solution {
    private static String string;

    private static int answer;

    public void central(int i, int j) {
        int length = i == j ? 1 : 2;

        int left = i - 1;
        int right = j + 1;

        while (left >= 0 && right <= string.length() - 1) {
            if (string.charAt(left) != string.charAt(right)) break;
            left--;
            right++;
            length += 2;
        }

        if (length > answer) answer = length;
    }

    public void central(int i) {
        central(i, i);
    }

    public int solution(String s) {
        string = s;
        answer = 1;
        for (int i = 1; i < string.length(); i++) {
            if (string.charAt(i) == string.charAt(i-1)) {
                System.out.println((i-1) + " " + i);
                central(i-1, i);
            }
            central(i);
        }
        return answer;
    }
}