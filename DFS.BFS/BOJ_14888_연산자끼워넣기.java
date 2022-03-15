import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14888_연산자끼워넣기 {

	static int N;
	static int[] num, cal;
	static boolean[] selected;
	static long min, max;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		num = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		cal = new int[4];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < 4; i++) {
			cal[i] = Integer.parseInt(st.nextToken());
		}

		max = Long.MIN_VALUE;
		min = Long.MAX_VALUE;

		dfs(num[0], 1);

		System.out.println(max);
		System.out.println(min);

	}

	private static void dfs(int total, int idx) {
		if (idx == N) {
			max = Math.max(max, total);
			min = Math.min(min, total);
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (cal[i] > 0) {
				cal[i]--;

				if (i == 0) {
					dfs(total + num[idx], idx + 1);
				} else if (i == 1) {
					dfs(total - num[idx], idx + 1);
				} else if (i == 2) {
					dfs(total * num[idx], idx + 1);
				} else if (i == 3) {
					dfs(total / num[idx], idx + 1);
				}

				cal[i]++;
			}
		}
	}

}
