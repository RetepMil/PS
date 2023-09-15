import java.util.Arrays;

class Solution {
    private int deletedStone(int[] rocks, int distance, int minimum) {
        int deleteCnt = 0;
        int prev = 0;
        for (int curr : rocks) {
            if (curr - prev < minimum) deleteCnt++;
            else prev = curr;
        }
        if (distance - prev < minimum) deleteCnt++;
        return deleteCnt;
    }
    
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        
        int left = 0; int right = distance;
        int answer = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (deletedStone(rocks, distance, mid) <= n) {
                answer = Math.max(answer, mid);
                left = mid + 1;
            }
            else right = mid - 1;
        }
        
        return answer;
    }
}