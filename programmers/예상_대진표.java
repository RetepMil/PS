import java.lang.Math;

class Solution {
    public int solution(int n, int a, int b) {
        int smaller = Math.min(a, b);
        int bigger = Math.max(a, b);
        int answer = 1;
        while (true) {
            if (smaller % 2 == 1 && (bigger - smaller) == 1) break;
            smaller = (smaller + 1) / 2;
            bigger = (bigger + 1) / 2;
            answer++;
        }
        return answer;
    }
}
