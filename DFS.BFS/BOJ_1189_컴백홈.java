import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1189_컴백홈 {

	static int R, C, K, cnt;
	static char[][] map;
	static boolean[][] visited;
	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			char[] ch = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				map[i][j] = ch[j];
			}
		}

		cnt = 0;

		visited[R - 1][0] = true;
		move(R - 1, 0, 1);

		System.out.println(cnt);
	}

	private static void move(int x, int y, int dist) {

		if (x == 0 && y == C - 1) {
			if (dist == K)
				cnt++;
			return;
		}

		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (nx >= 0 && nx < R && ny >= 0 && ny < C && !visited[nx][ny] && map[nx][ny] == '.') {
				visited[nx][ny] = true;
				move(nx, ny, dist + 1);
				visited[nx][ny] = false;
			}
		}

	}
}
