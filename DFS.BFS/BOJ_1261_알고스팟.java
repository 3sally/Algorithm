import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1261_알고스팟 {

    static int M, N, map[][];
    static boolean visited[][];
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int minSmash;

    static class Point implements Comparable<Point>{
        int x, y, smash;

        public Point(int x, int y, int smash) {
            this.x = x;
            this.y = y;
            this.smash = smash;
        }

        @Override
        public int compareTo(Point o) {
            return this.smash-o.smash;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            char[] ch = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = ch[j] - '0';
            }
        }

        visited = new boolean[N][M];
        minSmash = Integer.MAX_VALUE;

        visited[0][0] = true;
        System.out.println(bfs());
    }

    private static int bfs() {
        PriorityQueue<Point> q = new PriorityQueue<>();
        q.offer(new Point(0, 0, 0));
        visited[0][0] = true;

        while (!q.isEmpty()) {
            Point cur = q.poll();

            if (cur.x == N - 1 && cur.y == M - 1) {
                return cur.smash;
            }

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny]) {
                    if (map[nx][ny] == 1)
                        q.offer(new Point(nx, ny, cur.smash + 1));
                    else
                        q.offer(new Point(nx, ny, cur.smash));
                    visited[nx][ny] = true;
                }
            }
        }

        return  0;
    }

}
