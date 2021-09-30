import java.io.*;
import java.util.*;

public class SWEA_1953_탈주범검거 {

	static int[][] map;
	static int N, M, R, C, L;
	static int[][] time;
	static boolean[][] visited;
	static int nx, ny;

	static class Loc {
		int x, y, hour;

		public Loc(int x, int y, int hour) {
			super();
			this.x = x;
			this.y = y;
			this.hour = hour;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			sb.append("#").append(tc).append(" ");

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());// 지하 터널 지도의 세로 크기
			M = Integer.parseInt(st.nextToken());// 지하 터널 지도의 가로 크기
			R = Integer.parseInt(st.nextToken());// 맨홀 뚜껑 세로 위치
			C = Integer.parseInt(st.nextToken());// 맨홀 뚜껑 가로 위치
			L = Integer.parseInt(st.nextToken());// 탈출 후 소요된 시간

			map = new int[N][M]; // 지하 터널
			time = new int[N][M];
			visited = new boolean[N][M];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					time[i][j] = -1;
				}
			}

			move();

			int ans = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (time[i][j] >= 0 && time[i][j] <= L) {
						ans++;
					}
				}
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb);

	}

	private static void move() {
		Queue<Loc> q = new LinkedList<Loc>();
		q.add(new Loc(R, C, 1));

		while (!q.isEmpty()) {
			Loc s = q.poll();
			int x = s.x;
			int y = s.y;

			time[x][y] = s.hour;
			visited[x][y] = true;

			switch (map[x][y]) {
			case 1: { // 상하좌우
				int[] dx = { -1, 1, 0, 0 };
				int[] dy = { 0, 0, -1, 1 };
				for (int d = 0; d < 4; d++) {
					nx = x + dx[d];
					ny = y + dy[d];
					if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny]) {
						if (d == 0) { // 상
							if (map[nx][ny] == 1 || map[nx][ny] == 2 || map[nx][ny] == 5 || map[nx][ny] == 6) {
								q.offer(new Loc(nx, ny, s.hour + 1));
							}
						} else if (d == 1) { // 하
							if (map[nx][ny] == 1 || map[nx][ny] == 2 || map[nx][ny] == 4 || map[nx][ny] == 7) {
								q.offer(new Loc(nx, ny, s.hour + 1));
							}
						} else if (d == 2) { // 좌
							if (map[nx][ny] == 1 || map[nx][ny] == 3 || map[nx][ny] == 4 || map[nx][ny] == 5) {
								q.offer(new Loc(nx, ny, s.hour + 1));
							}
						} else if (d == 3) { // 우
							if (map[nx][ny] == 1 || map[nx][ny] == 3 || map[nx][ny] == 6 || map[nx][ny] == 7) {
								q.offer(new Loc(nx, ny, s.hour + 1));
							}
						}
					}
				}
			}
				break;
			case 2: { // 상하
				int[] dx = { -1, 1 };
				int[] dy = { 0, 0 };
				for (int d = 0; d < 2; d++) {
					nx = x + dx[d];
					ny = y + dy[d];
					if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny]) {
						if (d == 0) { // 상
							if (map[nx][ny] == 1 || map[nx][ny] == 2 || map[nx][ny] == 5 || map[nx][ny] == 6) {
								q.offer(new Loc(nx, ny, s.hour + 1));
							}
						} else if (d == 1) { // 하
							if (map[nx][ny] == 1 || map[nx][ny] == 2 || map[nx][ny] == 4 || map[nx][ny] == 7) {
								q.offer(new Loc(nx, ny, s.hour + 1));
							}
						}
					}
				}
			}
				break;
			case 3: { // 좌우
				int[] dx = { 0, 0 };
				int[] dy = { -1, 1 };
				for (int d = 0; d < 2; d++) {
					nx = x + dx[d];
					ny = y + dy[d];
					if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny]) {
						if (d == 0) { // 좌
							if (map[nx][ny] == 1 || map[nx][ny] == 3 || map[nx][ny] == 4 || map[nx][ny] == 5) {
								q.offer(new Loc(nx, ny, s.hour + 1));

							}
						} else if (d == 1) { // 우
							if (map[nx][ny] == 1 || map[nx][ny] == 3 || map[nx][ny] == 6 || map[nx][ny] == 7) {
								q.offer(new Loc(nx, ny, s.hour + 1));

							}
						}
					}
				}
			}
				break;
			case 4: { // 상우
				int[] dx = { -1, 0 };
				int[] dy = { 0, 1 };
				for (int d = 0; d < 2; d++) {
					nx = x + dx[d];
					ny = y + dy[d];
					if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny]) {
						if (d == 0) { // 상
							if (map[nx][ny] == 1 || map[nx][ny] == 2 || map[nx][ny] == 5 || map[nx][ny] == 6) {
								q.offer(new Loc(nx, ny, s.hour + 1));

							}
						} else if (d == 1) { // 우
							if (map[nx][ny] == 1 || map[nx][ny] == 3 || map[nx][ny] == 6 || map[nx][ny] == 7) {
								q.offer(new Loc(nx, ny, s.hour + 1));

							}
						}
					}
				}
			}
				break;
			case 5: { // 하우
				int[] dx = { 1, 0 };
				int[] dy = { 0, 1 };
				for (int d = 0; d < 2; d++) {
					nx = x + dx[d];
					ny = y + dy[d];
					if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny]) {
						if (d == 0) { // 하
							if (map[nx][ny] == 1 || map[nx][ny] == 2 || map[nx][ny] == 4 || map[nx][ny] == 7) {
								q.offer(new Loc(nx, ny, s.hour + 1));

							}
						} else if (d == 1) { // 우
							if (map[nx][ny] == 1 || map[nx][ny] == 3 || map[nx][ny] == 6 || map[nx][ny] == 7) {
								q.offer(new Loc(nx, ny, s.hour + 1));

							}
						}
					}
				}
			}
				break;
			case 6: { // 하좌
				int[] dx = { 1, 0 };
				int[] dy = { 0, -1 };
				for (int d = 0; d < 2; d++) {
					nx = x + dx[d];
					ny = y + dy[d];
					if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny]) {
						if (d == 0) { // 하
							if (map[nx][ny] == 1 || map[nx][ny] == 2 || map[nx][ny] == 4 || map[nx][ny] == 7) {
								q.offer(new Loc(nx, ny, s.hour + 1));

							}
						} else if (d == 1) { // 좌
							if (map[nx][ny] == 1 || map[nx][ny] == 3 || map[nx][ny] == 4 || map[nx][ny] == 5) {
								q.offer(new Loc(nx, ny, s.hour + 1));

							}
						}
					}
				}
			}
				break;
			case 7: { // 상좌
				int[] dx = { -1, 0 };
				int[] dy = { 0, -1 };
				for (int d = 0; d < 2; d++) {
					nx = x + dx[d];
					ny = y + dy[d];
					if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny]) {
						if (d == 0) { //
							if (map[nx][ny] == 1 || map[nx][ny] == 2 || map[nx][ny] == 5 || map[nx][ny] == 6) {
								q.offer(new Loc(nx, ny, s.hour + 1));

							}
						} else if (d == 1) { // 좌
							if (map[nx][ny] == 1 || map[nx][ny] == 3 || map[nx][ny] == 4 || map[nx][ny] == 5) {
								q.offer(new Loc(nx, ny, s.hour + 1));

							}
						}
					}
				}
			}
				break;
			}

		}
	}
}
