import java.io.*;

public class BOJ_2579_계단오르기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int score[] = new int[301];
		int dp[] = new int[301];

		for (int i = 0; i < N; i++) {
			score[i] = Integer.parseInt(br.readLine());
		}

		dp[0] = score[0];
		dp[1] = score[0] + score[1];
		dp[2] = Math.max(score[0], score[1]) + score[2];

		for (int i = 3; i < N; i++) {
			dp[i] = Math.max(dp[i - 3] + score[i - 1], dp[i - 2]) + score[i];
		}

		System.out.println(dp[N - 1]);
	}

}
