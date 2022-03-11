import java.io.*;
import java.util.*;

public class SWEA_2105_디저트카페 {

	static int N, maxDessert;
	static int sx, sy;
	static int dx[] = { 1, 1, -1, -1 };
	static int dy[] = { 1, -1, -1, 1 };
	static int[][] cafe;
	static boolean[] visited;
	static Deque<Integer> q;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= TC; tc++) {
			sb.append("#").append(tc).append(" ");

			N = Integer.parseInt(br.readLine());

			cafe = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					cafe[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			q = new LinkedList<Integer>();
			maxDessert = -1;

			for (int i = 0; i < N - 2; i++) {
				for (int j = 1; j < N - 1; j++) {
					sx = i;
					sy = j;
					visited = new boolean[101];
					visited[cafe[i][j]] = true;
					dfs(i, j, -1, -1, 1, 0);
				}
			}

			sb.append(maxDessert).append("\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int x, int y, int prevX, int prevY, int dessert, int dir) {

		for (int d = dir; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (nx == prevX && ny == prevY)
				continue;

			if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
				if (nx == sx && ny == sy) {
					maxDessert = Math.max(maxDessert, dessert);
					return;
				}

				if (!visited[cafe[nx][ny]]) {
					visited[cafe[nx][ny]] = true;
					dfs(nx, ny, x, y, dessert + 1, d);
					visited[cafe[nx][ny]] = false;
				}
			}
		}

	}

}
