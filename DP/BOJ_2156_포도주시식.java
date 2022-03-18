import java.io.*;

public class BOJ_2156_포도주시식 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] podo = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			podo[i] = Integer.parseInt(br.readLine());
		}

		int[] dp = new int[N + 1];
		dp[1] = podo[1];

		if (N > 1)
			dp[2] = podo[1] + podo[2];

		for (int i = 3; i <= N; i++) {
			dp[i] = Math.max(Math.max(dp[i - 1], dp[i - 2] + podo[i]), podo[i - 1] + podo[i] + dp[i - 3]);
		}

		System.out.println(dp[N]);
	}

}
