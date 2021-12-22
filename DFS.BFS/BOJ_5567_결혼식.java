import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_5567_결혼식 {

	static ArrayList<Integer>[] list;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 상근이 동기 수
		int M = Integer.parseInt(br.readLine()); // 리스트 길이

		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}

		StringTokenizer st;
		int a, b;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			list[a].add(b);
			list[b].add(a);
		}

		visited = new boolean[N + 1];

		check(1, 0);

		int cnt = 0;
		for (int i = 2; i <= N; i++) {
			if (visited[i])
				cnt++;
		}
		System.out.println(cnt);
	}

	private static void check(int n, int depth) {
		if (depth == 2)
			return;
		for (int i = 0; i < list[n].size(); i++) {
			int next = list[n].get(i);
			visited[next] = true;
			check(next, depth + 1);
		}
	}
}
