package PS;

import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.stream(scoville).forEach(a -> pq.offer(a));

        int answer = 0;
        while(pq.size() >= 2) {
            if (pq.peek() >= K) break;
            int first = pq.poll();
            int second = pq.poll();
            pq.offer(first + (second * 2)); answer++;
        }

        if (pq.size() == 1 && pq.peek() >= K) return answer;
        return answer == scoville.length - 1 ? -1 : answer;
    }
}