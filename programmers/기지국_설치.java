import java.lang.Math;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int range = 1 + 2 * w;
        int prev = 0;
        for (int station : stations) {
            int minimum_cover = station - w;
            int maximum_cover = station + w;
            if (minimum_cover > prev + 1) {
                int empty_space = minimum_cover - prev - 1;
                answer += (int) Math.ceil((empty_space * 1.0)/ range);
            }
            prev = maximum_cover;
        }
        if (prev >= n) return answer;

        int remain = n - prev;
        return answer + (int) Math.ceil((remain * 1.0) / range);
    }
}