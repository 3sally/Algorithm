import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15662_톱니바퀴2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); // 톱니바퀴수

        int[][] chain = new int[T+1][8];

        for (int i = 1; i <= T; i++) {
            char[] ch = br.readLine().toCharArray();
            for (int j = 0; j < 8; j++) {
                chain[i][j] = ch[j] - '0';
            }
        }

        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int chainNum = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());

            int[] move = new int[T+1];

            move[chainNum] = dir;
            // 회전 톱니 기준 왼쪽
            for (int j = chainNum - 1; j > 0; j--) {
                if (move[j + 1] == 0)
                    move[j] = 0;
                else {
                    if (chain[j + 1][6] == chain[j][2]) {
                        move[j] = 0;
                    } else {
                        move[j] = move[j + 1] == -1 ? 1 : -1;
                    }
                }
            }

            // 회전 톱니 기준 오른쪽
            for (int j = chainNum + 1; j <=T; j++) {
                if (move[j - 1] == 0)
                    move[j] = 0;
                else {
                    if (chain[j - 1][2] == chain[j][6]) {
                        move[j] = 0;
                    } else {
                        move[j] = move[j - 1] == -1 ? 1 : -1;
                    }
                }
            }

            // 회전
            for (int j = 1; j <= T; j++) {
                if (move[j] == 0)
                    continue;
                else if (move[j] == -1) { // 반시계
                    int temp = chain[j][0];
                    for (int l = 0; l < 7; l++) {
                        chain[j][l] = chain[j][l + 1];
                    }
                    chain[j][7] = temp;
                } else if (move[j] == 1) { // 시계
                    int temp = chain[j][7];
                    for (int l = 7; l > 0; l--) {
                        chain[j][l] = chain[j][l - 1];
                    }
                    chain[j][0] = temp;
                }
            }
        }

        int cnt = 0;
        for (int i = 1; i <= T; i++) {
            if(chain[i][0]==1)
                cnt++;
        }
        System.out.println(cnt);

    }
}
