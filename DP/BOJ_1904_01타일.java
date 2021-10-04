import java.io.*;
import java.util.Arrays;

public class BOJ_1904_01타일 {

	static int[] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		dp = new int[1000001];
		Arrays.fill(dp, -1); // dp 배열을 -1로 채움

		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;

		System.out.println(Sol(N));
	}

	public static int Sol(int N) {
		if (dp[N] == -1) {
			dp[N] = (Sol(N - 1) + Sol(N - 2)) % 15746;
		}
		return dp[N];
	}
}
