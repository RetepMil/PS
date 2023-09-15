import java.util.*;

class Solution {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        int cnt = 0;
        for (String string : s) {
            // System.out.println("START : " + string);

            int appearance = 0;
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < string.length(); i++) {
                char curr = string.charAt(i);
                if (curr == '0') {
                    if (stack.size() > 1) {
                        char prev = stack.pop();
                        char prevprev = stack.pop();

                        if (curr == '0' && prev == '1' && prevprev == '1')
                            appearance++;
                        else {
                            stack.push(prevprev);
                            stack.push(prev);
                            stack.push(curr);
                        }
                    } else stack.push(curr);
                } else stack.push(curr);
            }

            StringBuilder temp = new StringBuilder();
            while (!stack.isEmpty()) temp.append(stack.pop());

            String skeleton = temp.reverse().toString();
            boolean hasZero = false;
            int zeroLoc = 0;
            for (int i = 0; i < skeleton.length(); i++) {
                if (skeleton.charAt(i) == '0') {
                    hasZero = true;
                    zeroLoc = i;
                }
            }

            // System.out.println("appearance : " + appearance);
            // System.out.println("hasZero : " + hasZero);
            // System.out.println("zeroLoc : " + zeroLoc);
            // System.out.println("SKELETON : " + skeleton);

            StringBuilder sb = new StringBuilder();

            // 전부 1이면 그냥 앞에 전부 APPEND
            if (!hasZero) {
                for (int i = 0; i < appearance; i++)
                    sb.append("110");
                sb.append(skeleton);
            }
            // 0이 존재한다면 그 부분부터 APPEND
            else {
                sb.append(skeleton.substring(0, zeroLoc + 1));
                for (int i = 0; i < appearance; i++)
                    sb.append("110");
                sb.append(skeleton.substring(zeroLoc + 1));
            }

            // System.out.println("END : " + sb);
            answer[cnt++] = sb.toString();
            // System.out.println();
        }
        return answer;
    }
}
