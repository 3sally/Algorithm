import java.io.*;
import java.util.*;

public class BOJ_2565_전깃줄 {

	static int N, maxLine;
	static int dp[], line[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());
		line = new int[N][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			line[i][0] = Integer.parseInt(st.nextToken());
			line[i][1] = Integer.parseInt(st.nextToken());
		}

		// A기둥 기준으로 정렬
		Arrays.sort(line, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});

		dp = new int[N];
		Arrays.fill(dp, -1);
		maxLine = 0;

		// A기둥을 기준으로 연결 가능한개수를 탐색 해서 최대 연결 개수 구함
		for (int i = 0; i < N; i++) {
			maxLine = Math.max(maxLine, connect(i));
		}
		System.out.println(N - maxLine);
	}

	private static int connect(int i) {

		// 탐색 안했으면
		if (dp[i] == -1) {
			// 최소 하나는 연결 가능이므로
			dp[i] = 1;

			// i 이후의 전봇대 비교
			for (int j = i + 1; j < N; j++) {
				if (line[i][1] < line[j][1]) {
					dp[i] = Math.max(dp[i], connect(j) + 1);
				}
			}
		}
		return dp[i];
	}
}
