import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5472_불 {

    static int w,h;
    static char[][] map;
    static boolean[][] visited;
    static Queue<Point> fire;
    static int dx[] = {0,0,1,-1};
    static int dy[] = {1,-1,0,0};
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        for (int tc = 0; tc < TC; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
             w = Integer.parseInt(st.nextToken());
             h = Integer.parseInt(st.nextToken());

            map = new char[h][w];
            visited = new boolean[h][w];
            fire = new LinkedList<>();
            Point sanggun = null;
            for (int i = 0; i < h; i++) {
                char[] ch = br.readLine().toCharArray();
                for (int j = 0; j < w; j++) {
                    map[i][j] = ch[j];
                    if(map[i][j]=='@'){
                        sanggun = new Point(i,j);
                    }
                    if(map[i][j]=='*'){
                        fire.offer(new Point(i,j));
                    }
                }
            }
            bfs(sanggun);
        }
        System.out.println(sb);
    }

    private static void bfs(Point sanggun) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(-1,-1)); // 상근이가 이동을 다 했는지 알아보기 위한 플래그
        q.offer(new Point(sanggun.x, sanggun.y));
        visited[sanggun.x][sanggun.y] = true;
        int sec =-1;

        while(!q.isEmpty()){
            Point cur = q.poll();

            if(cur.x == -1 && cur.y == -1){ // 이동하기 전
                burn(); // 불부터 이동
                if(!q.isEmpty()){ // 상근이가 이동할 수 있으면
                    q.offer(cur); // 플래그 넣기
                }
                sec++; // 시간 증가
                continue;
            }

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if(nx<0 || nx>=h || ny<0 || ny>=w){ // 탈출 성공
                    sb.append(sec+1).append("\n");
                    return;
                }
                if(map[nx][ny]=='.' && !visited[nx][ny]){
                    q.offer(new Point(nx,ny));
                    visited[nx][ny] = true;
                }
            }
        }
        sb.append("IMPOSSIBLE").append("\n");
    }

    private static void burn() {
        int size = fire.size();
        for (int i = 0; i < size; i++) {
            Point cur = fire.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if(nx>=0 && nx<h && ny>=0 && ny<w && (map[nx][ny]=='.' || map[nx][ny]=='@')){
                    fire.offer(new Point(nx,ny));
                    map[nx][ny] = '*';
                }
            }
        }

    }
}
