import java.io.*;
import java.util.StringTokenizer;

public class BOJ_15651_N과M3 {

	static int N, M;
	static int[] res;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		res = new int[M];

		sb = new StringBuilder();

		perm(0);
		System.out.println(sb);
	}

	private static void perm(int cnt) {
		if (cnt == M) {
			for (int i : res) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 1; i <= N; i++) {
			res[cnt] = i;
			perm(cnt + 1);
		}
	}

}
