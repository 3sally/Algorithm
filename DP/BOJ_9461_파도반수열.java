import java.io.*;

public class BOJ_9461_파도반수열 {

	static int N;
	static long[] dp = new long[101];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());

		dp[1] = dp[2] = dp[3] = 1;

		for (int i = 0; i < TC; i++) {
			int N = Integer.parseInt(br.readLine());

			System.out.println(P(N));
		}
	}

	private static long P(int N) {
		if (dp[N] != 0)
			return dp[N];
		dp[N] = P(N - 3) + P(N - 2);
		return dp[N];
	}
}
