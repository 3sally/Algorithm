import java.io.*;
import java.util.StringTokenizer;

public class SWEA_4008_숫자만들기 {

	static int N, max, min;
	static int[] num, cal, order;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		for (int tc = 1; tc <= TC; tc++) {
			sb.append("#").append(tc).append(" ");

			N = Integer.parseInt(br.readLine());

			num = new int[N];
			cal = new int[4];
			order = new int[N - 1];

			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 4; i++) {
				cal[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}

			// 연산자 순열
			perm(0);
			sb.append(max - min).append("\n");
		}
		System.out.println(sb);
	}

	private static void perm(int cnt) {
		if (cnt == N - 1) {
			int res = calculate();
			// 계산
			max = Math.max(max, res);
			min = Math.min(min, res);
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (cal[i] > 0) {
				cal[i]--;
				order[cnt] = i;
				perm(cnt + 1);
				cal[i]++;
			}
		}
	}

	private static int calculate() {
		int res = num[0];

		for (int i = 0; i < N - 1; i++) {
			switch (order[i]) {
			case 0:
				res += num[i + 1];
				break;

			case 1:
				res -= num[i + 1];
				break;

			case 2:
				res *= num[i + 1];
				break;

			case 3:
				res /= num[i + 1];
				break;
			}
		}

		return res;
	}
}
