

import java.io.*;
import java.util.Arrays;

public class BOJ_1463_1로만들기 {

	static int dp[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		dp = new int[N + 1];
		Arrays.fill(dp, -1);
		dp[0] = dp[1] = 0;

		System.out.println(makeOne(N));
	}

	private static int makeOne(int n) {
		if (dp[n] == -1) {
			// 1 더하는건 연산 횟수때문!!
			if (n % 6 == 0) {// 6으로 나누어질때
				dp[n] = Math.min(makeOne(n - 1), Math.min(makeOne(n / 3), makeOne(n / 2))) + 1;
			} else if (n % 3 == 0) {// 3으로만 나누어질때
				dp[n] = Math.min(makeOne(n / 3), makeOne(n - 1)) + 1;
			} else if (n % 2 == 0) {
				dp[n] = Math.min(makeOne(n / 2), makeOne(n - 1)) + 1;
			} else { // 2와 3으로 다 나누어지지 않을 때
				dp[n] = makeOne(n - 1) + 1;
			}
		}
		return dp[n];
	}
}
