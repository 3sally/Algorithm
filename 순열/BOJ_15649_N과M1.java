import java.io.*;
import java.util.StringTokenizer;

public class BOJ_15649_N과M1 {

	static int N, M;
	static int[] arr;
	static boolean[] visited;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[M];
		visited = new boolean[N + 1];

		sb = new StringBuilder();

		perm(0);
		System.out.println(sb);
	}

	private static void perm(int cnt) {
		if (cnt == M) {
			for (int i : arr)
				sb.append(i).append(" ");
			sb.append("\n");
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (visited[i])
				continue;

			arr[cnt] = i;
			visited[i] = true;
			perm(cnt + 1);
			visited[i] = false;
		}
	}
}
