package PS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ps11660 {
     public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         StringTokenizer st = new StringTokenizer(br.readLine());
         int N = Integer.parseInt(st.nextToken());
         int M = Integer.parseInt(st.nextToken());

         int[][] matrix = new int[N + 1][N + 1];
         for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j < N + 1; j++)
                matrix[i][j] = Integer.parseInt(st.nextToken());
         }

         int[][] cul = new int[N + 1][N + 1];

         // 오른쪽으로 당기기
         for (int i = 1; i < N + 1; i++) {
             cul[i][1] = matrix[i][1];
             for (int j = 1; j < N + 1; j++) {
                 cul[i][j] = matrix[i][j] + cul[i][j - 1];
             }
         }

         // 밑으로 당기기
         for (int i = 1; i < N + 1; i++) {
             cul[1][i] = cul[1][i];
             for (int j = 1; j < N + 1; j++) {
                 cul[j][i] += cul[j - 1][i];
             }
         }

         for (int i = 0; i < M; i++) {
             st = new StringTokenizer(br.readLine());
             int x1 = Integer.parseInt(st.nextToken()); int y1 = Integer.parseInt(st.nextToken());
             int x2 = Integer.parseInt(st.nextToken()); int y2 = Integer.parseInt(st.nextToken());

             int fullCul = cul[x2][y2];
             int rowSub = cul[x2][y1 - 1];
             int colSub = cul[x1 - 1][y2];
             int dupPlus = cul[x1 - 1][y1 - 1];

             int answer = fullCul - rowSub - colSub + dupPlus;
             System.out.println(answer);
         }
     }
}
