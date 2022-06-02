import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9663_NQueen {

    static int N, cnt;
    static boolean[][] visited;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cnt = 0;

        visited = new boolean[N][N];
        map = new int[N][N];

        dfs(0);
        System.out.println(cnt);
    }

    private static void dfs(int count) {
        if(count==N){
            cnt++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if(visited[count][i])
                continue;

            map[count][i] = 1;
            visited[count][i] = true;

            checkQueen(count, i);


            dfs(count+1);

            // 원복
            map[count][i] = 0;

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    visited[j][k] = false;
                }
            }

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if(map[j][k]==1){
                        checkQueen(j,k);
                    }
                }
            }
        }
    }

    private static void checkQueen(int count, int i) {
        // 아래 왼쪽대각선 오른쪽 대각선만 생각하면 됨
        // 아래
        for (int j = count; j < N; j++) {
            visited[j][i] = true;
        }
        // 왼쪽아래대각선
        int r = count;
        int c = i;
        while(r>=0 && c>=0 && r<N && c<N){
            visited[r++][c--] = true;
        }
        // 왼쪽아래대각선
        r = count;
        c = i;
        while(r>=0 && c>=0 && r<N && c<N){
            visited[r++][c++] = true;
        }
    }
}
