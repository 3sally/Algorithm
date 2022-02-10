import java.io.*;
import java.util.*;

public class BOJ_7569_토마토 {

	static class Point {
		int x, y, z;
		int day;

		public Point(int x, int y, int z, int day) {
			super();
			this.x = x;
			this.y = y;
			this.z = z;
			this.day = day;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + ", z=" + z + ", day=" + day + "]";
		}

	}

	static int C, R, H, day;
	static int[][][] tomatoes;
	static boolean[][][] visited;
	static int[] dx = { 0, 0, 1, -1, 0, 0 };
	static int[] dy = { 1, -1, 0, 0, 0, 0 };
	static int[] dz = { 0, 0, 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		C = Integer.parseInt(st.nextToken()); // 가로
		R = Integer.parseInt(st.nextToken()); // 세로
		H = Integer.parseInt(st.nextToken()); // 층
		day = 0;
		tomatoes = new int[R][C][H];
		visited = new boolean[R][C][H];

		Queue<Point> q = new LinkedList<Point>();
		boolean allRipe = true;
		for (int i = 0; i < H; i++) {
			for (int r = 0; r < R; r++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int c = 0; c < C; c++) {
					tomatoes[r][c][i] = Integer.parseInt(st.nextToken());
					if (tomatoes[r][c][i] == 1) {
						q.add(new Point(r, c, i, 0));
					}
					if (tomatoes[r][c][i] == 0) {
						allRipe = false;
					}
				}
			}
		}

		if (allRipe) {
			System.out.println(0);
		} else {
			bfs(q);

			if (isAllRipe()) {
				System.out.println(day);
			} else {
				System.out.println(-1);
			}
		}
	}

	private static boolean isAllRipe() {
		for (int i = 0; i < H; i++) {
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					if (tomatoes[r][c][i] == 0)
						return false;
				}
			}
		}
		return true;
	}

	private static void bfs(Queue<Point> q) {
		while (!q.isEmpty()) {
			Point cur = q.poll();
			day = cur.day;
			visited[cur.x][cur.y][cur.z] = true;

			for (int d = 0; d < 6; d++) {
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];
				int nz = cur.z + dz[d];

				if (nx >= 0 && nx < R && ny >= 0 && ny < C && nz >= 0 && nz < H && !visited[nx][ny][nz]
						&& tomatoes[nx][ny][nz] == 0) {
					q.offer(new Point(nx, ny, nz, cur.day + 1));
					tomatoes[nx][ny][nz] = 1;
					visited[nx][ny][nz] = true;
				}
			}
		}
	}
}
