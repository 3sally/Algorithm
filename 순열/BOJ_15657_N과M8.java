import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15657_N과M8 {
	static int N, M;
	static int arr[];
	static int res[];
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		sb = new StringBuilder();
		res = new int[M];
		perm(0);
		System.out.println(sb);
	}

	private static void perm(int cnt) {
		if (cnt == M) {
			if (check(res)) {
				for (int i : res) {
					sb.append(i).append(" ");
				}
				sb.append("\n");
			}
			return;
		}

		for (int i = 0; i < N; i++) {
			res[cnt] = arr[i];
			perm(cnt + 1);
		}
	}

	private static boolean check(int[] res) {
		for (int i = 0; i < M - 1; i++) {
			if (res[i] > res[i + 1]) {
				return false;
			}
		}
		return true;
	}

}
