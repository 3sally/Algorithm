import java.io.*;
import java.util.*;

public class SWEA_1238_Contact {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= 10; tc++) {
			sb.append("#").append(tc).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			int INPUTSIZE = Integer.parseInt(st.nextToken());
			int START = Integer.parseInt(st.nextToken());

			boolean[][] connect = new boolean[101][101];

			st = new StringTokenizer(br.readLine(), " ");

			for (int i = 0; i < INPUTSIZE / 2; i++) {
				int FROM = Integer.parseInt(st.nextToken());
				int TO = Integer.parseInt(st.nextToken());

				connect[FROM][TO] = true;

			}

			sb.append(BFS(START, connect)).append("\n");
		}
		System.out.println(sb);
	}

	private static int BFS(int start, boolean[][] connect) {
		Queue<Integer> queue = new LinkedList<Integer>();
		int[] visited = new int[101];
		int maxCnt = 0;
		int result = 0;
		queue.offer(start);
		visited[start] = 1;

		while (!queue.isEmpty()) {

			int current = queue.poll();
			// System.out.println(current);

			for (int i = 0; i < 101; i++) {
				if (visited[i] == 0 && connect[current][i]) {
					queue.offer(i);
					visited[i] = visited[current] + 1;
				}
			}
			maxCnt = visited[current];
		}

		for (int i = 0; i < 101; i++) {
			if (maxCnt == visited[i])
				result = Math.max(i, result);
		}
		return result;
	}
}
