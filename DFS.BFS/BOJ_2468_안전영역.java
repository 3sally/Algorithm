import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2468_안전영역 {

    static int N, map[][], maxHeight;
    static int maxSafeArea;
    static boolean[][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        maxHeight = 0;

        StringTokenizer st = null;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j]= Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, map[i][j]);
            }
        }

        maxSafeArea = 0;

        for (int rain = 0; rain <= maxHeight; rain++) {
            int safeArea = 0;
            visited = new boolean[N][N];
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (map[r][c]>rain && !visited[r][c]){
                        safeArea++;
                        bfs(r, c, rain);
                    }
                }
            }
            maxSafeArea = Math.max(maxSafeArea, safeArea);
        }

        System.out.println(maxSafeArea);

    }

    private static void bfs(int r, int c, int rain) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(r,c));
        visited[r][c] = true;

        while(!q.isEmpty()){
            Point cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = cur.x+ dx[d];
                int nc = cur.y+ dy[d];
                if(nr>=0 && nr<N && nc>=0 && nc<N && !visited[nr][nc] && map[nr][nc]>rain){
                    q.offer(new Point(nr, nc));
                    visited[nr][nc] = true;
                }
            }
        }
    }
}
