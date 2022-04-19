import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_20058_마법사상어와파이어스톰 {

    static int dx[] = {0,0,-1,1};
    static int dy[] = {1,-1,0,0};
    static int map[][], size;
    static boolean visited[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N= Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        size = (int)Math.pow(2,N);
        map = new int[size][size];
        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < size; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < Q; i++) {
            // 0. 파이어스톰 시전
            int L = Integer.parseInt(st.nextToken());
            int[][] tempMap = new int[size][size];

            // 1. 격자 나누기
            int div = (int)Math.pow(2, L);
            for (int r = 0; r < size; r+=div) {
                for (int c = 0; c < size; c+=div) {
                   // 2. 90도 회전
                    int tempX = r;
                    int tempY = c+div-1;
                    for (int x = r; x < div+r; x++) {
                        for (int y = c; y < div+c; y++) {
                            tempMap[tempX++][tempY] = map[x][y];
                        }
                        tempX -= div;
                        tempY--;
                    }
                }
            }

            // map 을 tempMap으로 동기화
            for (int r = 0; r < size; r++) {
                for (int c = 0; c < size; c++) {
                    map[r][c] = tempMap[r][c];
                }
            }

            // 3. 근처에 얼음 0-2개면 녹이기
            for (int r = 0; r < size; r++) {
                for (int c = 0; c < size; c++) {
                    int ice = 0;
                    for (int d = 0; d < 4; d++) {
                        int nr = r + dx[d];
                        int nc = c + dy[d];
                        if(nr>=0 && nr<size && nc>=0&& nc<size && tempMap[nr][nc]>0){
                            ice++;
                        }
                    }

                    if(ice<3){
                         if(map[r][c]!=0)
                            map[r][c]--;
                    }
                }
            }
        }

        // 남아있는 얼음의 합 && 가장 큰 얼음 덩어리
        visited = new boolean[size][size];
        int total = 0;
        int maxArea = 0;
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
              total += map[r][c];
              if(!visited[r][c] && map[r][c]!=0){
                maxArea = Math.max(maxArea,bfs(r,c));
              }
            }
        }

        System.out.println(total);
        System.out.println(maxArea);

    }

    private static int bfs(int r, int c) {
        int area = 1;
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(r,c));
        visited[r][c] = true;

        while (!q.isEmpty()){
            Point cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = cur.x +dx[d];
                int nc = cur.y + dy[d];

                if(nr>=0 && nr<size && nc>=0&& nc<size && map[nr][nc]>0 && !visited[nr][nc]){
                    area++;
                    q.offer(new Point(nr,nc));
                    visited[nr][nc] = true;
                }
            }
        }

        return  area;
    }
}
