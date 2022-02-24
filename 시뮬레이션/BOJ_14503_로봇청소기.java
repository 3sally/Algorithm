import java.io.*;
import java.util.StringTokenizer;

public class BOJ_14503_로봇청소기 {

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static int N, M, map[][], cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		st = new StringTokenizer(br.readLine(), " ");
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		clean(r, c, d);
		System.out.println(cnt);
	}

	private static void clean(int r, int c, int d) {
		// 현재위치 청소
		if (map[r][c] == 0) {
			map[r][c] = 2;
			cnt++;
		}

		// 왼쪽부터 회전
		boolean canMove = false;

		for (int i = 0; i < 4; i++) {
			int nD = d == 0 ? 3 : d - 1;
			int nR = r + dx[nD];
			int nC = c + dy[nD];

			if (nR >= 0 && nR < N && nC >= 0 && nC < M) {
				if (map[nR][nC] == 0) {
					clean(nR, nC, nD);
					canMove = true;
					break;
				}
			}
			d = nD;
		}

		if (!canMove) {
			int bD = d < 2 ? d + 2 : d - 2;
			int bR = r + dx[bD];
			int bC = c + dy[bD];

			if (bR >= 0 && bR < N && bC >= 0 && bC < M) {
				if (map[bR][bC] != 1) {
					clean(bR, bC, d);
				}
			}
		}
	}
}
