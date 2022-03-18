import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11048_이동하기 {

	static int N, M, miro[][];
	static int[][] dp;
	static int[] dx = { 1, 0, 1 };
	static int[] dy = { 0, 1, 1 };

	static class Point {
		int x, y, candy;

		public Point(int x, int y, int candy) {
			super();
			this.x = x;
			this.y = y;
			this.candy = candy;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		miro = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= M; j++) {
				miro[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp = new int[N + 1][M + 1];
		dp[1][1] = miro[1][1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				move(i, j);
			}
		}
		System.out.println(dp[N][M]);
	}

	private static void move(int x, int y) {
		for (int d = 0; d < 3; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (nx > 0 && ny > 0 && nx <= N && ny <= M) {
				if (dp[x][y] + miro[nx][ny] > dp[nx][ny])
					dp[nx][ny] = dp[x][y] + miro[nx][ny];
			}
		}
	}
}
