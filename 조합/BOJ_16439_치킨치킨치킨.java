import java.io.*;
import java.util.StringTokenizer;

public class BOJ_16439_치킨치킨치킨 {

	static int N, M, max;
	static int[][] chicken;
	static int[] selected;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		chicken = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				chicken[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		selected = new int[3]; // 최대 세가지 종류의 치킨만 시킴
		max = 0;
		// 조합
		comb(0, 0);
		System.out.println(max);
	}

	private static void comb(int cnt, int start) {
		if (cnt == 3) {
			max = Math.max(max, satisfaction());
			return;
		}

		for (int i = start; i < M; i++) {
			selected[cnt] = i;
			comb(cnt + 1, i + 1);
		}
	}

	private static int satisfaction() {
		int result = 0;
		for (int i = 0; i < N; i++) {
			result += Math.max(Math.max(chicken[i][selected[0]], chicken[i][selected[1]]), chicken[i][selected[2]]);
		}

		return result;
	}
}
