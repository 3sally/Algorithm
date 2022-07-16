import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_1946_신입사원 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] score = new int[N][2];
            StringTokenizer st = null;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                score[i][0] = Integer.parseInt(st.nextToken());
                score[i][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(score, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });
            int cnt = 1;
            int prevScore = score[0][1];
            for (int i = 1; i < N; i++) {
                if(score[i][1]<prevScore){
                    prevScore = score[i][1];
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }
}
