import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < bridge_length; i++)
            q.offer(0);
        
        int time = 0;
        int truck_idx = 0;
        int weight_sum = 0;
        
        while (truck_idx < truck_weights.length) {
            int truck_weight = truck_weights[truck_idx];
            
            // 먼저 차량을 다리에서 뺀다
            weight_sum -= q.poll();
            
            // 삽입이 가능한 상태이기 때문에 해당 truck_weight을 넣는다
            if (weight_sum + truck_weight <= weight) {
                truck_idx++;
                q.offer(truck_weight);
                weight_sum += truck_weight;
            }
            
            // 큐에 삽입이 불가능하면 time을 증가시키기고 0을 Q에 넣는다
            else {
                q.offer(0);
            }
            
            time++;
        }
        
        while (weight_sum != 0) {
            if (q.isEmpty()) break;
            time++;
            weight -= q.poll();
        }
        
        return time;
    }
}