import java.io.*;
import java.util.*;

public class BOJ_1012_유기농배추 {

	static int N, M, needBug;
	static int[][] map;
	static boolean[][] isVisited;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class Loc {
		int r, c;

		public Loc(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int TC = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < TC; tc++) {
			st = new StringTokenizer(br.readLine(), " ");

			M = Integer.parseInt(st.nextToken()); // 가로
			N = Integer.parseInt(st.nextToken()); // 세로
			int K = Integer.parseInt(st.nextToken()); // 배추 위치 개수

			map = new int[N][M];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				map[r][c] = 1;
			}

			isVisited = new boolean[N][M];
			needBug = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 1 && !isVisited[i][j])
						baechu(i, j); // 배추덩어리 구하기
				}
			}
			System.out.println(needBug);
		}
	}

	private static void baechu(int r, int c) {
		Queue<Loc> q = new LinkedList<Loc>();
		q.offer(new Loc(r, c));
		isVisited[r][c] = true;

		while (!q.isEmpty()) {
			Loc cur = q.poll();

			for (int d = 0; d < 4; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 1 && !isVisited[nr][nc]) {
					q.offer(new Loc(nr, nc));
					isVisited[nr][nc] = true; // 들어갈때 방문체크 중요!!!
				}
			}
		}
		needBug++;
	}
}
