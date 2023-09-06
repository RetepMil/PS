package PS;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ps13397 {
    public static boolean isPossible(int[] sequence, int mid, int M) {
        int groupCnt = 1;
        List<Integer> group = new LinkedList<>();
        for (int num : sequence) {
            group.add(num);
            int max = Collections.max(group);
            int min = Collections.min(group);
            if (max - min > mid) {
                group = new LinkedList<>();
                group.add(num);
                groupCnt++;
            }
            if (groupCnt > M) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] sequence = new int[N];
        for (int i = 0; i < N; i++)
            sequence[i] = sc.nextInt();

        int left = 0;
        int right = 10_000;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isPossible(sequence, mid, M)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(left);
    }
}
