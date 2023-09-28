import java.lang.Character;

class Solution {
    public String solution(String s) {
        StringBuilder answerBuilder = new StringBuilder();
        char firstChar = s.charAt(0);
        answerBuilder.append(firstChar == ' ' ? ' ' : Character.toUpperCase(firstChar));
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') answerBuilder.append(c);
            else if (s.charAt(i - 1) == ' ') answerBuilder.append(Character.toUpperCase(c));
            else answerBuilder.append(Character.toLowerCase(c));
        }
        return answerBuilder.toString();
    }
}
