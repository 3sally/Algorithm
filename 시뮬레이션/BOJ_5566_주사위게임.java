import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_5566_주사위게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] map = new int[N+1];
        for (int i = 1; i <= N; i++) {
            map[i] = Integer.parseInt(br.readLine());
        }

        int cur = 1; // 시작 위치
        for (int i = 0; i < M; i++) {
            int move = Integer.parseInt(br.readLine());
            cur += move;

            if(cur>=N){
                System.out.println(i+1);
                break;
            }

            int num = map[cur];
            cur += num;

            if(cur>=N){
                System.out.println(i+1);
                break;
            }
        }
    }
}
