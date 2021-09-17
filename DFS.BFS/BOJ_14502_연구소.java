import java.io.*;
import java.util.*;

public class BOJ_14502_연구소 {

	static int N, M;
	static int[][] map;
	static int maxSafe;

	static class virusLoc {
		int x;
		int y;

		public virusLoc(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken()); // 세로
		M = Integer.parseInt(st.nextToken()); // 가로

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		maxSafe = 0;
		wall(0);
		System.out.println(maxSafe);
	}

	private static void wall(int cnt) {
		if (cnt == 3) {
			virus();
			return;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					map[i][j] = 1; // 벽세우기
					wall(cnt + 1);
					map[i][j] = 0; // 연산 끝나면 다시 돌려놓기
				}
			}
		}
	}

	private static void virus() {
		int[][] virusMap = new int[N][M];
		Queue<virusLoc> virus = new LinkedList<virusLoc>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				virusMap[i][j] = map[i][j];
				if (virusMap[i][j] == 2) {
					virus.offer(new virusLoc(i, j)); // 바이러스의 위치 저장
				}
			}
		}

		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };

		while (!virus.isEmpty()) {
			virusLoc cur = virus.poll();

			for (int d = 0; d < 4; d++) {
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];

				if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
					if (virusMap[nx][ny] == 0) { // 빈칸이면 바이러스로 만들기
						virusMap[nx][ny] = 2;
						virus.offer(new virusLoc(nx, ny));
					}
				}
			}

		}
		safeCnt(virusMap);
	}

	private static void safeCnt(int[][] virusMap) {
		int safeCnt = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (virusMap[i][j] == 0) {
					safeCnt++;
				}
			}
		}

		maxSafe = Math.max(safeCnt, maxSafe);
	}
}
