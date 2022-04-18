import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 프로그래머스_2017Kakao_카카오프렌즈컬러링북 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = 6;
        int n = 4;

        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};

        Solution(m, n, picture);
    }

    static boolean[][] visited;
    static int maxArea;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    private static int[] Solution(int m, int n, int[][] picture) {
        visited = new boolean[m][n];
        int totalArea = 0;
        maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] != 0 && !visited[i][j]) {
                    bfs(m, n, picture, i, j, picture[i][j]);
                    totalArea++;
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = totalArea;
        answer[1] = maxArea;
        return answer;

    }

    private static void bfs(int m, int n, int[][] picture, int x, int y, int num) {
        int area = 0;
        Queue<Point> q = new LinkedList<Point>();
        q.offer(new Point(x, y));

        while (!q.isEmpty()) {
            Point cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n && picture[nx][ny]==num && !visited[nx][ny]){
                    area++;
                    q.offer(new Point(nx,ny));
                    visited[nx][ny] = true;
                }
            }
        }
        maxArea = Math.max(area, maxArea);
    }

}
