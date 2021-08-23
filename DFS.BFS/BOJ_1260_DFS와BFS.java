import java.io.*;
import java.util.*;

public class BOJ_1260_DFS와BFS {

	static int N;
	static boolean[][] connect;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 정점의 개수
		int M = Integer.parseInt(st.nextToken()); // 간선의 개수
		int V = Integer.parseInt(st.nextToken()); // 탐색을 시작할 정점의 번호

		connect = new boolean[N + 1][N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			connect[from][to] = connect[to][from] = true;
		}

		DFS(V, new boolean[N + 1]);
		System.out.println();
		BFS(V);
	}

	private static void DFS(int current, boolean[] visited) {
		visited[current] = true;

		System.out.print(current + " ");

		for (int i = 0; i < N + 1; i++) {
			if (!visited[i] && connect[current][i]) {
				DFS(i, visited);
			}
		}
	}

	private static void BFS(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[N + 1];

		queue.offer(start);
		visited[start] = true;

		while (!queue.isEmpty()) {
			int current = queue.poll();

			System.out.print(current + " ");

			for (int i = 0; i < N + 1; i++) {
				if (!visited[i] && connect[current][i]) {
					queue.offer(i);
					visited[i] = true;
				}
			}
		}

	}
}
