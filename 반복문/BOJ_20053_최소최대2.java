import java.io.*;
import java.util.StringTokenizer;

public class BOJ_20053_최소최대2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());

			st = new StringTokenizer(br.readLine(), " ");

			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;

			for (int j = 0; j < N; j++) {
				int n = Integer.parseInt(st.nextToken());

				max = Math.max(max, n);
				min = Math.min(min, n);
			}

			sb.append(min).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}
}
