import java.io.*;
import java.util.StringTokenizer;

public class JUNGOL_1681_해밀턴순환회로 {

	static int N, minCost;
	static int[][] map;
	static boolean[] isSelected;
	static int[] loc, order;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine()); // 배달해야할 장소의 수
		map = new int[N][N];
		isSelected = new boolean[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		minCost = Integer.MAX_VALUE;
		// 0번에서 시작하고 다시 0번에서 끝남
		dfs(0, 0, 0);
		System.out.println(minCost);
	}

	private static void dfs(int start, int idx, int cost) {
		if (cost >= minCost) {
			return;
		}

		if (idx == N - 1) {
			if (map[start][0] != 0) {
				cost += map[start][0];
				minCost = Math.min(cost, minCost);
			}
			return;
		}

		for (int i = 1; i < N; i++) {
			if (map[start][i] != 0 && !isSelected[i]) {
				isSelected[i] = true;
				dfs(i, idx + 1, map[start][i] + cost);
				isSelected[i] = false;
			}
		}
	}
}
