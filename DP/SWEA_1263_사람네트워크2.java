import java.io.*;
import java.util.StringTokenizer;

public class SWEA_1263_사람네트워크2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			sb.append("#").append(tc).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());

			int arr[][] = new int[N][N];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					arr[r][c] = Integer.parseInt(st.nextToken());
					if (arr[r][c] == 0 && r != c)
						arr[r][c] = 987654321;
				}
			}

			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						arr[i][j] = Math.min(arr[i][k] + arr[k][j], arr[i][j]);
					}
				}
			}

			int result = Integer.MAX_VALUE;

			for (int k = 0; k < N; k++) {
				int sum = 0;
				for (int i = 0; i < N; i++)
					sum += arr[k][i];
				result = Math.min(result, sum);
			}

			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
}
