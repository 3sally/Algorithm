import java.io.*;

public class BOJ_10844_쉬운계단수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		long[][] dp = new long[N + 1][10];

		for (int i = 1; i < 10; i++) {
			dp[1][i] = 1;
		}

		for (int i = 2; i <= N; i++) {
			for (int j = 0; j < 10; j++) {

				// j=0, 즉 자릿값이 0이라면 이전 자릿수의 첫번째 자릿수만 가능
				if (j == 0) {
					dp[i][0] = dp[i - 1][1] % 1000000000;
				}
				// j=9라면 이전 자릿수는 8만 가능
				else if (j == 9) {
					dp[i][9] = dp[i - 1][8] % 1000000000;
				} else {
					dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000;
				}
			}
		}

		long res = 0;

		for (int i = 0; i < 10; i++) {
			res += dp[N][i];
		}
		System.out.println(res % 1000000000);
	}
}
