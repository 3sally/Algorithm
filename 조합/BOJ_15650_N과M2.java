import java.io.*;
import java.util.StringTokenizer;

public class BOJ_15650_N과M2 {

	static int N, M;
	static int[] res;
	static boolean[] visited;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		res = new int[M];
		visited = new boolean[N + 1];

		sb = new StringBuilder();
		comb(0, 1);
		System.out.println(sb);
	}

	private static void comb(int cnt, int start) {
		if (cnt == M) {
			for (int i : res)
				sb.append(i).append(" ");
			sb.append("\n");
			return;
		}

		for (int i = start; i <= N; i++) {
			if (visited[i])
				continue;
			res[cnt] = i;
			visited[i] = true;
			comb(cnt + 1, i + 1);
			visited[i] = false;
		}
	}
}
