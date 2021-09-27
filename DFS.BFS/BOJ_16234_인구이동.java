import java.io.*;
import java.util.*;

public class BOJ_16234_인구이동 {

	static class Loc {
		int x;
		int y;

		public Loc(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static int N, L, R, moveCnt;
	static boolean[][] visited;
	static int[][] map;

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken()); // NxN 땅
		L = Integer.parseInt(st.nextToken()); // L명 이상
		R = Integer.parseInt(st.nextToken()); // R명 이하

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		moveCnt = 0;

		move();
		System.out.println(moveCnt);

	}

	private static void move() {
		while (true) {
			visited = new boolean[N][N];
			boolean canMove = false;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visited[i][j]) // 방문한 곳이면 넘어가고
						continue;
					if (open(i, j)) // 방문안한 곳이면 연합을 할 수 있는지 확인
						canMove = true;
				}
			}

			if (!canMove)
				break;
			moveCnt++;
		}
	}

	private static boolean open(int i, int j) {

		Queue<Loc> q = new LinkedList<Loc>();
		Queue<Loc> team = new LinkedList<Loc>();

		q.add(new Loc(i, j));
		team.add(new Loc(i, j));
		visited[i][j] = true;

		int total = map[i][j];

		while (!q.isEmpty()) {
			Loc loc = q.poll();

			for (int d = 0; d < 4; d++) {
				int nx = loc.x + dx[d];
				int ny = loc.y + dy[d];
				if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
					if (Math.abs(map[loc.x][loc.y] - map[nx][ny]) >= L
							&& Math.abs(map[loc.x][loc.y] - map[nx][ny]) <= R) {
						total += map[nx][ny];
						q.add(new Loc(nx, ny));
						team.add(new Loc(nx, ny));
						visited[nx][ny] = true;
					}
				}
			}
		}

		if (team.size() == 1)
			return false; // 연합 없음
		else {
			int people = total / team.size();
			for (Loc loc : team) {
				map[loc.x][loc.y] = people;
			}
			return true;
		}
	}
}
