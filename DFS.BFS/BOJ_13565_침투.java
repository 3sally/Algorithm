import java.awt.Point;
import java.io.*;
import java.util.*;

public class BOJ_13565_침투 {

	static int M, N;
	static char map[][];
	static boolean visited[][];

	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new char[M][N];
		visited = new boolean[M][N];

		for (int i = 0; i < M; i++) {
			map[i] = br.readLine().toCharArray();
		}

		if (canPercolate())
			System.out.println("YES");
		else
			System.out.println("NO");
	}

	private static boolean canPercolate() {
		Queue<Point> q = new LinkedList<Point>();
		for (int i = 0; i < N; i++) {
			if (map[0][i] == '0') {
				q.offer(new Point(0, i));
				visited[0][i] = true;
			}
		}

		while (!q.isEmpty()) {
			Point cur = q.poll();
			int x = cur.x;
			int y = cur.y;

			if (x == M - 1)
				return true;

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx >= 0 & nx < M && ny >= 0 && ny < N && map[nx][ny] == '0' && !visited[nx][ny]) {
					q.offer(new Point(nx, ny));
					visited[nx][ny] = true;
				}
			}
		}
		return false;

	}
}
