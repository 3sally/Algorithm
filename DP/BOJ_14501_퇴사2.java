import java.io.*;
import java.util.StringTokenizer;

public class BOJ_14501_퇴사2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] TP = new int[N + 10][2]; // +10의 이유는 마지막날 +5일때 배열 에러 안나기 위해서

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			TP[i][0] = Integer.parseInt(st.nextToken());
			TP[i][1] = Integer.parseInt(st.nextToken());
		}

		int maxPay = 0;
		int[] dp = new int[N + 10];

		for (int i = 1; i <= N + 1; i++) {
			dp[i] = Math.max(dp[i], maxPay); // 이전까지의 최대 수입을 비교해서 현재에 저장해줌
			// 이전에 저장된 최대수익 vs 이번 움직임으로 생긴 최대 수익
			dp[TP[i][0] + i] = Math.max(dp[TP[i][0] + i], TP[i][1] + dp[i]);

			maxPay = Math.max(dp[i], maxPay);
		}

		System.out.println(maxPay);
	}
}
