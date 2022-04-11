import java.io.*;
import java.util.StringTokenizer;

public class BOJ_18290_NM과K1 {

	static int N, M, K, map[][], maxSum;
	static boolean visited[][];
	static int dx[] = { 0, 0, 1, -1 };
	static int dy[] = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		maxSum = Integer.MIN_VALUE;

		visited = new boolean[N][M];
		choice(0, 0, 0, 0);

		System.out.println(maxSum);
	}

	private static void choice(int x, int y, int cnt, int sum) {
		if (cnt == K) {
			maxSum = Math.max(maxSum, sum);
			return;
		}

		for (int i = x; i < N; i++) {
			for (int j = y; j < M; j++) {
				if (!visited[i][j]) {
					if (check(i, j)) {
						visited[i][j] = true;
						choice(x, y, cnt + 1, sum + map[i][j]);
						visited[i][j] = false;
					}
				}
			}
		}
	}

	private static boolean check(int i, int j) {
		boolean flag = true;

		for (int d = 0; d < 4; d++) {
			int nx = i + dx[d];
			int ny = j + dy[d];

			if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
				if (visited[nx][ny])
					flag = false;
			}
		}
		return flag;
	}
}
