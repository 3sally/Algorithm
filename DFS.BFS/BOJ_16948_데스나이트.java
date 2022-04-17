import java.io.*;
import java.util.*;

public class BOJ_16948_데스나이트 {
	static int dx[] = { -2, -2, 0, 0, 2, 2 };
	static int dy[] = { -1, 1, -2, 2, -1, 1 };
	static int startX, startY, endX, endY;
	static int N;
	static boolean[][] visited;

	static class Point {
		int x, y, cnt;

		public Point(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		startX = Integer.parseInt(st.nextToken());
		startY = Integer.parseInt(st.nextToken());
		endX = Integer.parseInt(st.nextToken());
		endY = Integer.parseInt(st.nextToken());

		visited = new boolean[N][N];

		System.out.println(bfs());
	}

	private static int bfs() {
		Queue<Point> q = new LinkedList<Point>();
		q.offer(new Point(startX, startY, 0));
		visited[startX][startY] = true;

		while (!q.isEmpty()) {
			Point cur = q.poll();

			if (cur.x == endX && cur.y == endY) {
				return cur.cnt;
			}

			for (int d = 0; d < 6; d++) {
				int nx = cur.x + dx[d];  
				int ny = cur.y + dy[d];

				if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]) {
					q.offer(new Point(nx, ny, cur.cnt + 1));
					visited[nx][ny] = true;
				}
			}

		}

		return -1;
	}

}
