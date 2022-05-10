import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2583_영역구하기 {

    static int N, M, K;
    static int[][] map;
    static boolean[][] visited;
    static int dx[] = {0,0,-1,1};
    static int dy[] = {-1,1,0,0};
    static PriorityQueue<Integer> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int startY = Integer.parseInt(st.nextToken());
            int startX = N-1-Integer.parseInt(st.nextToken());
            int endY =  Integer.parseInt(st.nextToken())-1;
            int endX = N-1-(Integer.parseInt(st.nextToken())-1);

            for (int j = startX; j >= endX ; j--) {
                for (int k = startY; k <= endY ; k++) {
                    map[j][k] = 1;
                }
            }
        }

        // 빈영역 찾기
        int cnt = 0;
        pq = new PriorityQueue<>();
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j]==0 && !visited[i][j]){
                    cnt++;
                    bfs(i,j);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            sb.append(pq.poll()).append(" ");
        }
        System.out.println(cnt);
        System.out.println(sb);
    }

    private static void bfs(int x, int y) {
        int area = 1;
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x,y));
        visited[x][y] = true;

        while (!q.isEmpty()){
            Point cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if(nx>=0 && nx<N && ny>=0 && ny<M && map[nx][ny]==0 && !visited[nx][ny]){
                    q.offer(new Point(nx,ny));
                    visited[nx][ny] = true;
                    area++;
                }
            }
        }
        pq.offer(area);
    }
}
