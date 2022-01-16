import java.io.*;
import java.util.StringTokenizer;

public class BOJ_15661_링크와스타트 {

	static int N, power[][];
	static int p, minDiff;
	static int start[], link[];
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		power = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				power[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		minDiff = Integer.MAX_VALUE;

		for (p = 1; p <= N - 1; p++) {
			start = new int[p];
			link = new int[N - p];
			visited = new boolean[N + 1];
			team(0, 1);
		}

		System.out.println(minDiff);
	}

	private static void team(int cnt, int sta) {
		if (cnt == p) {
			int idx = 0;
			for (int i = 1; i < visited.length; i++) {
				if (!visited[i]) {
					link[idx++] = i;
				}
			}

			minDiff = Math.min(minDiff, calcDiff());

			return;
		}

		for (int i = sta; i <= N; i++) {
			start[cnt] = i;
			visited[i] = true;
			team(cnt + 1, i + 1);
			visited[i] = false;
		}
	}

	private static int calcDiff() {
		int startPow = 0;
		int linkPow = 0;

		if (start.length == 1) {
			startPow = 0;
		} else {
			for (int i = 0; i < start.length; i++) {
				for (int j = 0; j < start.length; j++) {
					if (i == j)
						continue;
					startPow += power[start[i]][start[j]];
				}
			}
		}
		if (link.length == 1) {
			linkPow = 0;
		} else {
			for (int i = 0; i < link.length; i++) {
				for (int j = 0; j < link.length; j++) {
					linkPow += power[link[i]][link[j]];
				}
			}
		}
		return Math.abs(startPow - linkPow);
	}
}
