import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15654_N과M5 {

	static int N, M, num[];
	static int[] arr;
	static boolean[] visited;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		num = new int[N];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(num);
		arr = new int[M];
		visited = new boolean[N];
		sb = new StringBuilder();

		perm(0);
		System.out.println(sb);

	}

	private static void perm(int cnt) {
		if (cnt == M) {
			for (int n : arr) {
				sb.append(n).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < N; i++) {
			if (visited[i])
				continue;
			arr[cnt] = num[i];
			visited[i] = true;
			perm(cnt + 1);
			visited[i] = false;
		}
	}
}
