import java.io.*;
import java.util.*;

public class BOJ_17086_아기상어2 {

	static int N, M, map[][], maxDistance;
	static boolean[][] visited;
	static int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };

	static class Point {
		int x, y, distance;

		public Point(int x, int y, int distance) {
			super();
			this.x = x;
			this.y = y;
			this.distance = distance;
		}

	}

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

		maxDistance = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					visited = new boolean[N][M];
					bfs(i, j);
				}
			}
		}

		System.out.println(maxDistance);
	}

	private static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(x, y, 0));
		visited[x][y] = true;

		while (!q.isEmpty()) {
			Point cur = q.poll();

			if (map[cur.x][cur.y] == 1) {
				maxDistance = Math.max(maxDistance, cur.distance);
				return;
			}

			for (int d = 0; d < 8; d++) {
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];
				if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny]) {
					q.add(new Point(nx, ny, cur.distance + 1));
					visited[nx][ny] = true;
				}
			}
		}

	}
}
