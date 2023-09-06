package PS;

import java.util.Arrays;
import java.util.Scanner;

public class ps4796 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cnt = 1;
        while(true) {
            Integer[] inputs = Arrays.stream(in.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
            Integer L = inputs[0];
            Integer P = inputs[1];
            Integer V = inputs[2];

            if (L == 0 && P == 0 && V == 0) break;

            int quotient = V / P;
            int remainder = Math.min(V - (P * quotient), L);
            int answer = quotient * L + remainder;
            System.out.printf("Case %d: %s%n", cnt, answer);

            cnt++;
        }
    }
}