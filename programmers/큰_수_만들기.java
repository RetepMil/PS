package PS;

import java.util.ArrayList;

class Solution {
    public String solution(String number, int k) {
        String[] nums = number.split("");
        ArrayList<Integer> answer = new ArrayList<>();

        int deleted = 0;
        for (String num : nums) {
            int numInt = Integer.parseInt(num);
            int prev = answer.isEmpty() ? 0 : answer.get(answer.size()-1);

            if (deleted >= k) {
                answer.add(numInt);
                continue;
            }

            while (numInt > prev && !answer.isEmpty()) {
                answer.remove(answer.size()-1);
                deleted++;
                if (answer.isEmpty() || deleted >= k) break;
                prev = answer.get(answer.size()-1);
            }

            answer.add(numInt);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < number.length()-k; i++)
            sb.append(answer.get(i));

        return sb.toString();
    }
}