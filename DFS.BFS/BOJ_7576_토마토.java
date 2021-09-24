import java.io.*;
import java.util.*;

public class BOJ_7576_토마토 {

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static int[][] box;
	static Queue<Loc> tomatoQ;
	static int res, N, M;

	public static class Loc {
		int x;
		int y;
		int day;

		public Loc(int x, int y, int day) {
			super();
			this.x = x;
			this.y = y;
			this.day = day;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		box = new int[N][M];
		int totalTomato = N * M;
		tomatoQ = new LinkedList<Loc>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());

				// 익은 토마토 위치 넣어두기
				if (box[i][j] == 1)
					tomatoQ.offer(new Loc(i, j, 0));
				else if (box[i][j] == -1)
					totalTomato--;

			}
		}

		// 들어있지 않은 칸 말고 나머지 칸이 모두 다 익어 있으면
		if (tomatoQ.size() == totalTomato) {
			System.out.println("0");
			return;
		}

		bfs();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (box[i][j] == 0) {
					System.out.println("-1");
					return;
				}
			}
		}
		System.out.println(res);

	}

	private static void bfs() {
		while (!tomatoQ.isEmpty()) {
			Loc tomato = tomatoQ.poll();
			res = tomato.day;
			// 익은 토마토 위치 하나 꺼내서 인접한 네 곳을 익은 토마토로 바꾸고 다시 큐에 넣어줌
			for (int d = 0; d < 4; d++) {
				int nx = tomato.x + dx[d];
				int ny = tomato.y + dy[d];
				int day = tomato.day + 1;
				if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
					if (box[nx][ny] == 0) {
						box[nx][ny] = 1;
						tomatoQ.offer(new Loc(nx, ny, day));
					}
				}
			}
		}
	}
}
