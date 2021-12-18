import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1455_뒤집기2 {

	static int[][] coin;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		coin = new int[N][M];

		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				coin[i][j] = Integer.parseInt(str[j]);
			}
		}

		// 오른쪽 맨 끝부터 1을 만나면 뒤집어봄 (거꾸로 뒤집기)
		int cnt = 0;
		for (int i = N - 1; i >= 0; i--) {
			for (int j = M - 1; j >= 0; j--) {
				if (coin[i][j] == 1) {
					reverse(i, j);
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}

	private static void reverse(int i, int j) {
		for (int r = 0; r <= i; r++) {
			for (int c = 0; c <= j; c++) {
				if (coin[r][c] == 0)
					coin[r][c] = 1;
				else
					coin[r][c] = 0;
			}
		}
	}
}
