import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_6593_상범빌딩 {

    static StringBuilder sb;
    static int L, R, C;
    static int startL, startX, startY;
    static int endL, endX, endY;
    static char[][][] building;
    static boolean[][][] visited;

    static int dl[] = {-1, 1};
    static int dr[] = {-1,1,0,0};
    static int dc[] = {0,0,-1,1};

    static class Point{
        int l,r,c,cnt;

        public Point(int l, int r, int c, int cnt) {
            this.l = l;
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if(L==0 && R==0 && C==0){
                break;
            }

            building = new char[L][R][C];
            visited = new boolean[L][R][C];
            startL = 0;
            startX = 0;
            startY = 0;
            endL = 0;
            endX = 0;
            endY = 0;

            for (int i = 0; i < L; i++) {
                for (int r = 0; r < R; r++) {
                    char[] ch = br.readLine().toCharArray();
                    for (int c = 0; c < C; c++) {
                        building[i][r][c] = ch[c];

                        if(building[i][r][c]=='S'){
                            startL = i;
                            startX = r;
                            startY = c;
                            building[i][r][c] = '.';
                        }

                        if(building[i][r][c]=='E'){
                            endL = i;
                            endX = r;
                            endY = c;
                            building[i][r][c] = '.';
                        }
                    }
                }
                br.readLine();
            }
            dfs();
        }
        System.out.println(sb);
    }

    private static void dfs() {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(startL, startX, startY, 0));
        visited[startL][startX][startY] = true;

        while(!q.isEmpty()){
            Point cur = q.poll();
            if(cur.l==endL && cur.r==endX && cur.c == endY){
                sb.append("Escaped in ").append(cur.cnt).append(" minute(s).").append("\n");
                return;
            }

            // 상하 이동
            for (int d = 0; d < 2; d++) {
                int nl = cur.l + dl[d];
                if(nl>=0 && nl<L && building[nl][cur.r][cur.c]=='.' && !visited[nl][cur.r][cur.c]){
                    q.offer(new Point(nl, cur.r, cur.c, cur.cnt+1));
                    visited[nl][cur.r][cur.c] = true;
                }
            }

            // 동서남북 이동
            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];
                if(nr>=0 && nr<R && nc>=0 && nc<C && building[cur.l][nr][nc]=='.' && !visited[cur.l][nr][nc]){
                    q.offer(new Point(cur.l, nr, nc, cur.cnt+1));
                    visited[cur.l][nr][nc] = true;
                }
            }
        }

        sb.append("Trapped!").append("\n");
    }
}
