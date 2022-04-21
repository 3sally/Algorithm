import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17142_연구소3 {

    static int N, M, map[][], minTime, empty;
    static List<Virus> virus;
    static Virus[] selected;

    static class Virus{
        int x, y, time;

        public Virus(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    static int dx[] = {0,0,-1,1};
    static int dy[] = {1,-1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        virus = new LinkedList<>();
        selected = new Virus[M];
        minTime = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st =new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==2){
                    virus.add(new Virus(i,j,0));
                }else if(map[i][j]==0){
                    empty++;
                }
            }
        }

        if (empty==0){
            System.out.println(0);
        }else{
            //바이러스 가능한 위치 조합
            comb(0,0);
            System.out.println(minTime==Integer.MAX_VALUE?-1:minTime);
        }
    }

    private static void comb(int cnt, int start) {
        if(cnt==M){
            // 바이러스 전파
            activeVirus(empty);
            return;
        }

        for (int i = start; i < virus.size(); i++) {
            selected[cnt] = virus.get(i);
            comb(cnt+1, i+1);
        }
    }

    private static void activeVirus(int empty) {
        boolean[][] visited = new boolean[N][N];
        Queue<Virus> q = new LinkedList<>();

        for (int i = 0; i < M; i++) {
            q.offer(new Virus(selected[i].x, selected[i].y, selected[i].time));
            visited[selected[i].x][selected[i].y] = true;
        }

        while (!q.isEmpty()){
            Virus cur = q.poll();

             for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if(nx>=0 && nx<N && ny>=0 && ny<N && !visited[nx][ny] && map[nx][ny]!=1){
                    // 빈칸으로 갈 경우
                    if (map[nx][ny]==0 ){
                        empty--;
                    }
                    visited[nx][ny] = true;
                    q.offer(new Virus(nx,ny,cur.time+1));

                    if(empty==0){
                        minTime= Math.min(minTime, cur.time+1);
                        return;
                    }
                }
            }
        }
    }
}
