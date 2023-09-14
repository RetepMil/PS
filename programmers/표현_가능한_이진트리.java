import java.util.Arrays;
import java.lang.Math;

class Solution {
    private static boolean allZeros(String str) {
        for (int i = 0; i < str.length(); i++)
            if (str.charAt(i) != '0')
                return false;
        return true;
    }
    
    private static boolean isPossible(String num) {
        if (num.length() == 1) return true;

        int mid = num.length() / 2;
        String leftNum = num.substring(0, mid);
        String rightNum = num.substring(mid + 1);
            
        if (num.charAt(mid) == '0') {
            if (allZeros(leftNum) && allZeros(rightNum)) return true;
            else return false;
        }

        return isPossible(leftNum) && isPossible(rightNum);
    }

    public static int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            StringBuilder binaryString = new StringBuilder(Long.toBinaryString(numbers[i]));

            int actualStringLength = binaryString.toString().length();
            int depth = 1;
            
            while ((int) Math.pow(2, depth) - 1 < actualStringLength)
                depth++;
            int expectedLength = (int) Math.pow(2, depth) - 1;
            while (binaryString.toString().length() < expectedLength)
                binaryString.insert(0, "0");
            if (isPossible(binaryString.toString())) answer[i] = 1;
        }
        return answer;
    }
}