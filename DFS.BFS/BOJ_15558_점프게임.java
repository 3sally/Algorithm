import java.io.*;
import java.util.*;

public class BOJ_15558_점프게임 {

	static int N, k;
	static int[][] map;
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

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		map = new int[2][N];
		for (int i = 0; i < 2; i++) {
			char[] c = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				map[i][j] = c[j] - '0';
			}
		}

		visited = new boolean[2][N];

		System.out.println(jump(0, 0));
	}

	private static int jump(int x, int y) {
		Queue<Point> q = new LinkedList<Point>();
		q.offer(new Point(x, y, 0));
		visited[x][y] = true;

		while (!q.isEmpty()) {
			Point cur = q.poll();

			int nx, ny;

			nx = cur.x;
			ny = cur.y + 1;
			if (checkRange(nx, ny, cur.cnt)) {
				q.offer(new Point(nx, ny, cur.cnt + 1));
				if (ny >= N) {
					return 1;
				}
				visited[nx][ny] = true;
			}

			nx = cur.x;
			ny = cur.y - 1;
			if (checkRange(nx, ny, cur.cnt)) {
				q.offer(new Point(nx, ny, cur.cnt + 1));
				if (ny >= N) {
					return 1;
				}
				visited[nx][ny] = true;
			}

			nx = cur.x + 1;
			ny = cur.y + k;
			if (checkRange(nx, ny, cur.cnt)) {
				q.offer(new Point(nx, ny, cur.cnt + 1));
				if (ny >= N) {
					return 1;
				}
				visited[nx][ny] = true;
			}

			nx = cur.x - 1;
			ny = cur.y + k;
			if (checkRange(nx, ny, cur.cnt)) {
				q.offer(new Point(nx, ny, cur.cnt + 1));
				if (ny >= N) {
					return 1;
				}
				visited[nx][ny] = true;
			}

		}
		return 0;
	}

	private static boolean checkRange(int nx, int ny, int cnt) {
		if (nx >= 0 && nx < 2 && ny > cnt) {
			if (ny < N && map[nx][ny] == 0)
				return false;
			if (ny < N && visited[nx][ny])
				return false;
			return true;
		}
		return false;
	}
}
