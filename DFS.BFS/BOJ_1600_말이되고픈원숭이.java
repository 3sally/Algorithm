import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1600_말이되고픈원숭이 {

    static int K, W, H, map[][];
    static boolean[][][] visited;
    static int horseX[] = {-1,1,-2,2,-2,2,-1,1};
    static int horseY[] = {-2,-2,-1,-1,1,1,2,2};
    static int monkeyX[] = {0,0,-1,1};
    static int monkeyY[] = {-1,1,0,0};

    static class Point{
        int x, y, cnt, k;

        public Point(int x, int y, int cnt, int k) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.k = k;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][W];
        visited = new boolean[H][W][K+1];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        jump();
    }

    private static void jump() {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0,0,0,0));
        visited[0][0][0] = true;

        while(!q.isEmpty()){
            Point cur = q.poll();

            if(cur.x==H-1 && cur.y==W-1){
                System.out.println(cur.cnt);
                return;
            }

            // 말 따라하기
            if(cur.k<K) {
                for (int d = 0; d < 8; d++) {
                    int nx = cur.x + horseX[d];
                    int ny = cur.y + horseY[d];

                    if (nx >= 0 && nx < H && ny >= 0 && ny < W && map[nx][ny] == 0 && !visited[nx][ny][cur.k+1]) {
                        q.offer(new Point(nx, ny, cur.cnt + 1, cur.k + 1));
                        visited[nx][ny][cur.k+1] = true;
                    }
                }
            }

            // 원숭이 원래
            for (int d = 0; d < 4; d++) {
                int nx = cur.x+ monkeyX[d];
                int ny = cur.y + monkeyY[d];

                if(nx>=0 && nx<H && ny>=0 && ny<W && map[nx][ny]==0 && !visited[nx][ny][cur.k]){
                    q.offer(new Point(nx, ny, cur.cnt+1, cur.k));
                    visited[nx][ny][cur.k] = true;
                }
            }


        }
        System.out.println(-1);
    }
}
