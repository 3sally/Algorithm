import java.io.*;
import java.util.*;

public class BOJ_2206_벽부수고이동하기 {

	static int N, M, map[][];
	static int visited[][];
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class Point {
		int r, c, move;
		int crash;

		public Point(int r, int c, int move, int crash) {
			super();
			this.r = r;
			this.c = c;
			this.move = move;
			this.crash = crash;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new int[N][M]; // 방문 여부 + 벽을 부순 횟수
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
				visited[i][j] = Integer.MAX_VALUE;
			}
		}

		System.out.println(move());

	}

	private static int move() {
		boolean finish = false;
		Queue<Point> q = new LinkedList<Point>();
		// 시작 위치 넣음
		q.offer(new Point(0, 0, 1, 0));
		visited[0][0] = 0;

		while (!q.isEmpty()) {
			Point cur = q.poll();
			int r = cur.r;
			int c = cur.c;
			int move = cur.move;
			int crash = cur.crash;

			if (r == N - 1 && c == M - 1) { // 도착지점이면
				return cur.move;
			}

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				if (nr >= 0 && nr < N && nc >= 0 && nc < M) {

					if (visited[nr][nc] > cur.crash) {
						if (map[nr][nc] == 0) { // 0이면 바로 집어넣기
							q.offer(new Point(nr, nc, move + 1, crash));
							visited[nr][nc] = crash;
						} else { // 1이면
							if (crash == 0) { // 지금까지 벽을 부순휫수가 0이면
								q.offer(new Point(nr, nc, move + 1, crash + 1));
								visited[nr][nc] = crash + 1;
							}
						}
					}
				}
			}
		}

		return -1;

	}
}
