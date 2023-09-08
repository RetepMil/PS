package PS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ps12015 {
    private static final List<Integer> LIS = new ArrayList<>();

    public static int binarySearch(int from, int to, int maximum) {
        while (from < to) {
            int mid = (from + to) >> 1;
            if (LIS.get(mid) < maximum) {
                from = mid + 1;
            }
            else {
                to = mid;
            }
        }
        return to;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        LIS.add(0);
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num > LIS.get(LIS.size() - 1)) LIS.add(num);
            else {
                int replaceIndex = binarySearch(0, LIS.size() - 1, num);
                LIS.set(replaceIndex, num);
            }
        }
        System.out.println(LIS.size() - 1);
    }
}