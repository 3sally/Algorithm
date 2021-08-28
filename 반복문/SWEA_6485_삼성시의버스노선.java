import java.io.*;
import java.util.StringTokenizer;

public class SWEA_6485_삼성시의버스노선 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			sb.append("#").append(tc).append(" ");
			int N = Integer.parseInt(br.readLine());
			int[][] route = new int[N][2];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				route[i][0] = Integer.parseInt(st.nextToken());
				route[i][1] = Integer.parseInt(st.nextToken());
			}

			int P = Integer.parseInt(br.readLine());
			int[] C = new int[P];
			for (int i = 0; i < P; i++) {
				C[i] = Integer.parseInt(br.readLine());
			}
			int[] busCnt = new int[P];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < P; j++) {
					if (C[j] >= route[i][0] && C[j] <= route[i][1]) {
						busCnt[j]++;
					}
				}
			}

			for (int cnt : busCnt)
				sb.append(cnt).append(" ");
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
