import java.io.*;
import java.util.*;

public class BOJ_7562_나이트의이동 {

	static int I;
	static int[][] board;
	static boolean[][] visited;
	static Point start, dest;

	static int[] dx = { -2, -1, -2, -1, 1, 2, 1, 2 };
	static int[] dy = { -1, -2, 1, 2, -2, -1, 2, 1 };

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

		int TC = Integer.parseInt(br.readLine()); // 테스트 케이스 수

		for (int tc = 0; tc < TC; tc++) {
			I = Integer.parseInt(br.readLine()); // 체스판 한 변의 길이
			board = new int[I][I];
			visited = new boolean[I][I];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);

			st = new StringTokenizer(br.readLine(), " ");
			dest = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);

			System.out.println(move());
		}

	}

	private static int move() {
		Queue<Point> q = new LinkedList<Point>();

		q.offer(start);
		visited[start.x][start.y] = true;

		while (!q.isEmpty()) {
			Point cur = q.poll();
			int x = cur.x;
			int y = cur.y;
			int cnt = cur.cnt;

			if (x == dest.x && y == dest.y)
				return cnt;

			for (int d = 0; d < 8; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];

				if (nx >= 0 && nx < I && ny >= 0 && ny < I && !visited[nx][ny]) {
					q.offer(new Point(nx, ny, cnt + 1));
					visited[nx][ny] = true;
				}
			}
		}
		return 0;
	}
}
