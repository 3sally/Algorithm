import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11724_연결요소의개수 {

	static int N, M, adj[][];
	static boolean visited[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		adj = new int[N + 1][N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			adj[u][v] = 1;
			adj[v][u] = 1;
		}

		visited = new boolean[N + 1];

		int connect = 0;

		// 방문하지 않았으면 탐색하고 연결+1 함
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				dfs(i);
				connect++;
			}
		}

		System.out.println(connect);
	}

	private static void dfs(int i) {
		visited[i] = true;

		// 연결되어 있고 방문 안했으면 이어서 탐색
		for (int j = 1; j <= N; j++) {
			if (adj[i][j] == 1 && !visited[j]) {
				dfs(j);
			}
		}
	}
}
