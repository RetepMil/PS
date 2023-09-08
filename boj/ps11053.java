package PS;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.max;

public class ps11053 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = Integer.parseInt(s.nextLine());
        List<Integer> arr = Arrays.stream(s.nextLine().split(" ")).map(Integer::parseInt).toList();
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr.get(j) < arr.get(i)) dp[i] = max(dp[i], dp[j]);
            }
            dp[i]++;
        }
        System.out.println(dp[N-1]);
    }
}
