import java.util.Stack;

class Solution {
    final int MAX = 1_000_005;
    int[] prev = new int[MAX];
    int[] next = new int[MAX];

    public String solution(int n, int k, String[] cmd) {
        for (int i = 0; i < n; i++) {
            prev[i] = i - 1;
            next[i] = i + 1;
        }
        next[n - 1] = -1;
        int cursor = k;
        Stack<tuple> stack = new Stack<>();
        StringBuilder sb = new StringBuilder("O".repeat(n));
        for (String command : cmd) {
            switch (command.charAt(0)) {
                case 'U' -> {
                    int upBy = Integer.parseInt(command.substring(2, command.length()));
                    while (upBy-- > 0) cursor = prev[cursor];
                }
                case 'D' -> {
                    int downBy = Integer.parseInt(command.substring(2, command.length()));
                    while (downBy-- > 0) cursor = next[cursor];
                }
                case 'C' -> {
                    stack.push(new tuple(prev[cursor], cursor, next[cursor]));
                    if (prev[cursor] != -1) next[prev[cursor]] = next[cursor];
                    if (next[cursor] != -1) prev[next[cursor]] = prev[cursor];
                    sb.setCharAt(cursor, 'X');
                    if (next[cursor] != -1) cursor = next[cursor];
                    else cursor = prev[cursor];
                }
                case 'Z' -> {
                    int prevVal = stack.peek().prev;
                    int currVal = stack.peek().curr;
                    int nextVal = stack.peek().next;
                    stack.pop();
                    if (prevVal != -1) next[prevVal] = currVal;
                    if (nextVal != -1) prev[nextVal] = currVal;
                    sb.setCharAt(currVal, 'O');
                }
            }
        }
        return sb.toString();
    }
}

class tuple {
    int prev, curr, next;
    tuple(int prev, int curr, int next) {
        this.prev = prev;
        this.curr = curr;
        this.next = next;
    }
}