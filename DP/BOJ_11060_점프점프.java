import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11060_점프점프 {

	static int N, miro[], dp[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		miro = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			miro[i] = Integer.parseInt(st.nextToken());
		}

		dp = new int[N];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;

		for (int i = 0; i < N; i++) {
			if (dp[i] != Integer.MAX_VALUE) {
				int jump = miro[i];
				for (int j = 1; j <= jump; j++) {
					if (i + j >= N)
						continue;

					dp[i + j] = Math.min(dp[i] + 1, dp[i + j]);
				}
			}
		}

		System.out.println(dp[N - 1] == Integer.MAX_VALUE ? -1 : dp[N - 1]);
	}

}
