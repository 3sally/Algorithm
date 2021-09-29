import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_4485_녹색옷입은애가젤다지 {

	static class Loc implements Comparable<Loc> {
		int x;
		int y;
		int cost;

		public Loc(int x, int y, int cost) {
			super();
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

		@Override
		public int compareTo(Loc o) {
			return this.cost - o.cost;
		}

	}

	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int[][] caves, coins;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		int tc = 1;
		while ((N = Integer.parseInt(br.readLine())) != 0) {
			sb.append("Problem ").append(tc++).append(": ");

			caves = new int[N][N];
			coins = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					caves[i][j] = Integer.parseInt(st.nextToken());
					coins[i][j] = Integer.MAX_VALUE;
				}
			}

			sb.append(bfs()).append("\n");
		}
		System.out.println(sb);
	}

	private static int bfs() {
		PriorityQueue<Loc> q = new PriorityQueue<Loc>();
		q.add(new Loc(0, 0, caves[0][0]));
		coins[0][0] = caves[0][0];

		while (!q.isEmpty()) {
			Loc loc = q.poll();
			int x = loc.x;
			int y = loc.y;

			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];

				if (nx >= 0 && nx < N && ny >= 0 && ny < N && (coins[nx][ny] > coins[x][y] + caves[nx][ny])) {

					coins[nx][ny] = coins[x][y] + caves[nx][ny];
					q.add(new Loc(nx, ny, coins[nx][ny]));
				}
			}
		}
		return coins[N - 1][N - 1];
	}
}