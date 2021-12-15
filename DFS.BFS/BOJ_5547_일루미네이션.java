import java.awt.Point;
import java.io.*;
import java.util.*;

public class BOJ_5547_일루미네이션 {

	static int[][] odd = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 1, 1 }, { 0, 1 }, { -1, 1 } };
	static int[][] even = { { -1, -1 }, { 0, -1 }, { 1, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine(), " ");
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());

		int[][] map = new int[H + 2][W + 2];
		boolean[][] outside = new boolean[H + 2][W + 2];

		for (int i = 1; i <= H; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 바깥쪽만 표시
		Queue<Point> q = new LinkedList<Point>();

		q.offer(new Point(0, 0));
		outside[0][0] = true;

		int nx, ny;

		while (!q.isEmpty()) {
			Point cur = q.poll();
			for (int i = 0; i < 6; i++) {
				if (cur.x % 2 == 0) { // x가 짝수일때
					nx = cur.x + even[i][0];
					ny = cur.y + even[i][1];

					if (nx >= 0 && nx <= H + 1 && ny >= 0 && ny <= W + 1 && !outside[nx][ny]) {
						if (map[nx][ny] == 0) {
							q.offer(new Point(nx, ny));
							outside[nx][ny] = true;
						}
					}
				} else { // x가 홀수일때
					nx = cur.x + odd[i][0];
					ny = cur.y + odd[i][1];

					if (nx >= 0 && nx <= H + 1 && ny >= 0 && ny <= W + 1 && !outside[nx][ny]) {
						if (map[nx][ny] == 0) {
							q.offer(new Point(nx, ny));
							outside[nx][ny] = true;
						}
					}
				}
			}
		}

		int total = 0;

		for (int i = 1; i <= H; i++) {
			for (int j = 1; j <= W; j++) {
				if (map[i][j] == 0)
					continue;
				for (int k = 0; k < 6; k++) {
					if (i % 2 == 0) {// x가 짝수일때
						nx = i + even[k][0];
						ny = j + even[k][1];
					} else {// x가 홀수일때
						nx = i + odd[k][0];
						ny = j + odd[k][1];
					}
					if (outside[nx][ny])
						total++;
				}
			}
		}

		System.out.println(total);
	}
}
