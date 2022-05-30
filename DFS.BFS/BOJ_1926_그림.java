import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1926_그림 {

    static int n, m, pictureSize, maxPictureSize;
    static int[][] map;
    static boolean[][] visited;
    static int dx[] = {0,0,-1,1};
    static int dy[] = {1,-1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[n][m];
        int pictureCnt = 0;
        maxPictureSize = 0;

        for (int i = 0; i < n; i++) {
           for (int j = 0; j < m; j++) {
                if(map[i][j]==1 && !visited[i][j]){
                    pictureCnt++;
                    pictureSize = 1;
                    dfs(i,j);
                    maxPictureSize = Math.max(maxPictureSize, pictureSize);
                }
           }
        }

        System.out.println(pictureCnt);
        System.out.println(maxPictureSize);
    }

    private static void dfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x,y));
        visited[x][y] = true;

        while (!q.isEmpty()){
            Point cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if(nx>=0 && nx<n && ny>=0 && ny<m && map[nx][ny]==1 && !visited[nx][ny]){
                    pictureSize++;
                    q.offer(new Point(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }

    }
}
