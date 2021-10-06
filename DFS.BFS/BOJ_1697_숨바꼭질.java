import java.io.*;
import java.util.*;

public class BOJ_1697_숨바꼭질 {

	static int N, K;
	static int visited[] = new int[100001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		Arrays.fill(visited, -1);

		if (N == K)
			System.out.println("0");
		else
			System.out.println(dfs());
	}

	private static int dfs() {
		Queue<Integer> q = new LinkedList<Integer>();

		q.offer(N);
		visited[N] = 0;

		while (!q.isEmpty()) {
			int cur = q.poll();
			int next = 0;

			for (int i = 0; i < 3; i++) {

				if (i == 0) {
					next = cur * 2;
				} else if (i == 1) {
					next = cur + 1;
				} else if (i == 2) {
					next = cur - 1;
				}

				if (next == K) {
					return visited[cur] + 1;
				}

				if (next >= 0 && next < 100001 && visited[next] == -1) {
					q.offer(next);
					visited[next] = visited[cur] + 1;
				}
			}

		}
		return 0;
	}
}
