import java.io.*;
import java.util.StringTokenizer;

public class SWEA_1952_수영장 {

	static int pays[], months[];
	static int minPay;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= TC; tc++) {
			sb.append("#").append(tc).append(" ");

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			// 1일,1달,3달,1년
			pays = new int[4];
			for (int i = 0; i < 4; i++) {
				pays[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine(), " ");

			months = new int[13];
			for (int i = 1; i <= 12; i++) {
				months[i] = Integer.parseInt(st.nextToken());
			}

			// 1년짜리 금액
			minPay = pays[3];

			dfs(1, 0);
			sb.append(minPay).append("\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int month, int totalPay) {
		if (month > 12) {
			minPay = Math.min(minPay, totalPay);
			return;
		}

		// 사용 안할땐 안 사기
		if (months[month] == 0)
			dfs(month + 1, totalPay);

		// 1일 이용권
		if (months[month] > 0)
			dfs(month + 1, totalPay + months[month] * pays[0]);

		// 1달 이용권
		dfs(month + 1, totalPay + pays[1]);

		// 3달 이용권
		dfs(month + 3, totalPay + pays[2]);
	}
}
