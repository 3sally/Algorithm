import java.io.*;
import java.util.StringTokenizer;

public class BOJ_17144_미세먼지안녕 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());

		int[][] room = new int[R][C];
		int[][] copy_room = new int[R][C];
		int[][] ac = new int[2][2];
		int idx = 0;
		int totalDust = 0;

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < C; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
				if (room[i][j] == -1) {
					ac[idx][0] = i;
					ac[idx][1] = j;
					idx++;
				}
			}
		}

		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };

		for (int t = 0; t < T; t++) {
			// 미세먼지 확산
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (room[i][j] != 0) {
						int val = room[i][j] / 5;
						copy_room[i][j] += room[i][j];
						for (int d = 0; d < 4; d++) {
							int nx = i + dx[d];
							int ny = j + dy[d];
							if (nx >= 0 && ny >= 0 && nx < R && ny < C && room[nx][ny] != -1) {
								copy_room[nx][ny] += val;
								copy_room[i][j] -= val;
							}
						}
					}

				}
			}

			// 공기청정기 가동
			// 위
			{
				int x = ac[0][0];
				int y = ac[0][1];
				int r = x;
				int c = 0;

				for (int i = 0; i < x; i++) {
					if (room[r][y] == -1) {
						r--;
						continue;
					}
					copy_room[r][y] = copy_room[r - 1][y];
					r--;
				}

				for (int i = 0; i < C - 1; i++) {
					if (room[0][c] == -1) {
						c++;
						continue;
					}
					copy_room[0][c] = copy_room[0][c + 1];
					c++;
				}

				for (int i = 0; i < x; i++) {
					if (room[r][C - 1] == -1) {
						r++;
						continue;
					}
					copy_room[r][C - 1] = copy_room[r + 1][C - 1];
					r++;
				}

				for (int i = 0; i < C - 2; i++) {
					if (room[x][c] == -1) {
						c--;
						continue;
					}
					copy_room[x][c] = copy_room[x][c - 1];
					c--;
				}
				copy_room[x][y + 1] = 0;

			}
			// 아래
			{
				int x = ac[1][0];
				int y = ac[1][1];
				int r = x;
				int c = 0;

				for (int i = 0; i < R - 1 - x; i++) {
					if (room[r][y] == -1) {
						r++;
						continue;
					}
					copy_room[r][y] = copy_room[r + 1][y];
					r++;
				}

				for (int i = 0; i < C - 1; i++) {
					if (room[R - 1][c] == -1) {
						c++;
						continue;
					}
					copy_room[R - 1][c] = copy_room[R - 1][c + 1];
					c++;
				}

				for (int i = 0; i < R - 1 - x; i++) {
					if (room[r][C - 1] == -1) {
						r--;
						continue;
					}
					copy_room[r][C - 1] = copy_room[r - 1][C - 1];
					r--;
				}

				for (int i = 0; i < C - 2; i++) {
					if (room[x][c] == -1) {
						c--;
						continue;
					}
					copy_room[x][c] = copy_room[x][c - 1];
					c--;
				}
				copy_room[x][y + 1] = 0;

			}
			totalDust = 0;

			for (int k = 0; k < R; k++) {
				for (int j = 0; j < C; j++) {
					if (copy_room[k][j] == -1)
						continue;
					totalDust += copy_room[k][j];
				}
			}

			for (int k = 0; k < R; k++) {
				for (int j = 0; j < C; j++) {
					room[k][j] = copy_room[k][j];
					copy_room[k][j] = 0;
				}
			}

		}

		System.out.println(totalDust);
	}
}
