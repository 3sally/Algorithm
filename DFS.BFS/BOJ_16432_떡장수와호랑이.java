import java.io.*;
import java.util.*;

public class BOJ_16432_떡장수와호랑이 {

	static int N;
	static List<Integer>[] ricecake;
	static int[] result;
	static boolean[][] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		ricecake = new LinkedList[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			ricecake[i] = new LinkedList<Integer>();
			int M = Integer.parseInt(st.nextToken());
			for (int j = 0; j < M; j++) {
				ricecake[i].add(Integer.parseInt(st.nextToken()));
			}
		}

		result = new int[N];
		visited = new boolean[N][10];
		dfs(0, 0);
		System.out.println("-1");
	}

	private static void dfs(int idx, int prev) {
		if (idx == N) {
			for (int i : result) {
				System.out.println(i);
			}
			System.exit(0);
		}

		for (int i = 1; i < 10; i++) {
			if (i != prev && !visited[idx][i] && ricecake[idx].contains(i)) {
				visited[idx][i] = true;
				result[idx] = i;
				dfs(idx + 1, i);
			}
		}

	}
}
