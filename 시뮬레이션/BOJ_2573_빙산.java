import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2573_빙산 {

    static int N, M, map[][];
    static int year;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        year=0;

        while (true){
            if(canMelt()){ // 녹일 얼음이 있으면
                year++;

                // 얼음 녹이기
                melting();

                // 덩어리 확인
                int iceGroup = findGroup();
                if(iceGroup>1){
                    System.out.println(year);
                    break;
                }
            }else{
                System.out.println(0);
                break;
            }
        }

    }

    private static boolean canMelt() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j]!=0){
                    return true;
                }
            }
        }
        return false;
    }

    private static int findGroup() {
        int group = 0;
        visited  = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j]!=0 && !visited[i][j]){
                   bfs(i,j);
                    group++;
                }
            }
        }
        return group;
    }

    private static void bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x,y));
        visited[x][y] = true;

        while(!q.isEmpty()){
            Point cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if(nx>=0 && nx<N && ny>=0 &&ny<M && map[nx][ny]!=0 && !visited[nx][ny]){
                    q.offer(new Point(nx,ny));
                    visited[nx][ny] = true;
                }
            }
        }
    }

    private static void melting() {
        int[][] meltingMap = new int[N][M];

        // 얼음 녹이기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j]!=0){
                    int zero = findZero(i,j);
                    meltingMap[i][j] = map[i][j]-zero<0?0:map[i][j]-zero;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = meltingMap[i][j];
            }
        }
    }

    private static int findZero(int x, int y) {
        int cnt = 0;
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(nx>=0 && nx<N && ny>=0 &&ny<M && map[nx][ny]==0){
                cnt++;
            }
        }

        return cnt;
    }
}
