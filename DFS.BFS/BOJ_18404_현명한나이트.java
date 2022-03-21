import java.awt.Point;
import java.io.*;
import java.util.*;

public class BOJ_18404_현명한나이트 {

	static int dx[] = { -2, -2, -1, -1, 1, 1, 2, 2 };
	static int dy[] = { -1, 1, -2, 2, -2, 2, -1, 1 };
	static int N, M, X, Y, map[][], cnt[][], findCnt;
	static boolean visited[][];
	static StringBuilder sb;

	static class Po {
		int x, y, cnt;

		public Po(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N + 1][N + 1];
		visited = new boolean[N + 1][N + 1];
		cnt = new int[N + 1][N + 1];

		st = new StringTokenizer(br.readLine(), " ");
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());

		List<Point> E = new LinkedList<Point>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			map[A][B] = 1;
			E.add(new Point(A, B));
		}
		findCnt = 0;
		move();

		for (Point p : E) {
			sb.append(cnt[p.x][p.y]).append(" ");
		}

		System.out.println(sb);
	}

	private static void move() {
		Queue<Po> q = new LinkedList<Po>();
		q.offer(new Po(X, Y, 0));
		visited[X][Y] = true;

		while (!q.isEmpty()) {
			Po cur = q.poll();
			if (map[cur.x][cur.y] == 1) {
				map[cur.x][cur.y] = 0;
				cnt[cur.x][cur.y] = cur.cnt;

				findCnt++;

				if (findCnt == M)
					return;

			}

			for (int d = 0; d < 8; d++) {
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];
				if (nx > 0 && ny > 0 && nx <= N && ny <= N && !visited[nx][ny]) {
					q.offer(new Po(nx, ny, cur.cnt + 1));
					visited[nx][ny] = true;
				}
			}
		}

	}
}
