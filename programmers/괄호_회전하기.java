import java.util.*;

class Solution {
    private char[] charArr;
    
    private char returnOppositeChar(char c) {
        switch (c) {
            case ']':
                return '[';
            case '}':
                return '{';
            case ')':
                return '(';
        }
        return ' ';
    }
    
    private boolean isValid(int start) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < charArr.length; i++) {
            char c = charArr[start % charArr.length];
            if (c == '[' || c == '(' || c == '{') {
                stack.push(c);
            } else if (!stack.isEmpty() && stack.peek() == returnOppositeChar(c)) {
                stack.pop();
            } else {
                return false;
            }
            start++;
        }
        return stack.isEmpty();
    }
    
    public int solution(String s) {
        int answer = 0;
        charArr = s.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            if (isValid(i)) answer++;
        }
        return answer;
    }
}
