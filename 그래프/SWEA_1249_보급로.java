import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_SWEA_1249_보급로 {

	static int N, map[][];
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {

			N = Integer.parseInt(br.readLine()); // 배열 크기
			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				char[] ch = br.readLine().toCharArray();
				for (int j = 0; j < N; j++) {
					map[i][j] = ch[j] - '0';
				}
			}

			System.out.println("#" + tc + " " + dijkstra(0, 0));
		}

	}

	private static int dijkstra(int startR, int startC) {

		boolean[][] isVisited = new boolean[N][N];
		int[][] minTime = new int[N][N];

		// 최소값이 갱신되도록 큰 값으로 초기화
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				minTime[i][j] = INF;
			}
		}

		PriorityQueue<int[]> pQueue = new PriorityQueue<int[]>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});

		minTime[startR][startC] = 0;
		pQueue.offer(new int[] { startR, startC, minTime[startR][startC] });

		int r = 0, c = 0, minCost = 0, nr, nc;
		while (true) {

			// step1
			int[] cur = pQueue.poll();
			r = cur[0];
			c = cur[1];
			minCost = cur[2];

			if (isVisited[r][c])
				continue;

			isVisited[r][c] = true;

			if (r == N - 1 && c == N - 1)
				return minCost;

			// step2 : step1에서 선택된 정점을 경유지로 해서 인접정점 따져보기
			// 이 문제에서는 인접정점이 4방 정점
			for (int d = 0; d < 4; d++) {
				nr = r + dx[d];
				nc = c + dy[d];

				if (nr >= 0 && nr < N && nc >= 0 && nc < N && !isVisited[nr][nc]
						&& minTime[nr][nc] > minCost + map[nr][nc]) {
					minTime[nr][nc] = minCost + map[nr][nc];
					pQueue.offer(new int[] { nr, nc, minTime[nr][nc] });
				}
			}

		}

	}
}
