import java.util.Scanner;

public class ps2096 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int[] max = { 0, 0, 0 };
        int[] min = { 0, 0, 0 };
        for (int i = 0; i < N; i++) {
            logic(max, min, s);
        }
        int minVal = 1_000_000;
        int maxVal = 0;
        for (int i = 0; i < 3; i++) {
            minVal = Math.min(minVal, min[i]);
            maxVal = Math.max(maxVal, max[i]);
        }
        System.out.println(maxVal + " " + minVal);
    }

    private static void logic(int[] max, int[] min, Scanner s) {
        int[] newMin = new int[3];
        int[] newMax = new int[3];
        for (int i = 0; i < 3; i++) {
            int minVal = 1_000_000;
            int maxVal = 0;
            for (int j = -1; j < 2; j++) {
                int index = i + j;
                if (index < 0 || index > 2) continue;
                minVal = Math.min(minVal, min[index]);
                maxVal = Math.max(maxVal, max[index]);
            }
            int num = s.nextInt();
            newMin[i] = num + minVal;
            newMax[i] = num + maxVal;
        }
        for (int i = 0; i < 3; i++) {
            min[i] = newMin[i];
            max[i] = newMax[i];
        }
    }
}
