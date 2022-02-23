import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1010_다리놓기 {

	static double N, M;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < TC; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Double.parseDouble(st.nextToken());
			M = Double.parseDouble(st.nextToken());

			// 조합
//			comb(0, 0);
			System.out.printf("%.0f\n", combi(M, N));
//			sb.append(combi(M, N)).append("\n"); // mC
		}
//		System.out.println(sb);
	}

	private static double combi(double M, double N) {
		double a = 1;
		double b = 1;

		for (double i = M; i > M - N; i--) {
			a = a * i;
		}

		for (double i = N; i > 0; i--) {
			b = b * i;
		}

		return a / b;
	}

//	private static void comb(int cnt, int start) {
//		if (cnt == N) {
//			answer++;
//			return;
//		}
//
//		for (int i = start; i < M; i++) {
//			bridge[cnt] = i;
//			comb(cnt + 1, i + 1);
//		}
//	}
}
