import java.io.*;
import java.util.*;

public class BOJ_2636_치즈 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int R = Integer.parseInt(st.nextToken()); // 세로
		int C = Integer.parseInt(st.nextToken()); // 가로

		int[][] board = new int[R][C];
		int cheese = 0;

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < C; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 1)
					cheese++;
			}
		}

		int time = 0;
		int left_cheese = 0;
		boolean[][] check;
		// 좌, 우, 상,하
		int dx[] = { 0, 0, -1, 1 };
		int dy[] = { -1, 1, 0, 0 };

		// cheese가 0이 될때까지 반복
		// 한번 돌때마다 시간 한시간 증가, 남아있는 치즈 개수 left_cheese에 저장
		while (cheese != 0) {
			time++;
			left_cheese = cheese;
			// bfs
			Queue<int[]> q = new LinkedList<int[]>();
			q.offer(new int[] { 0, 0 });
			check = new boolean[R][C];
			check[0][0] = true;
			while (!q.isEmpty()) {
				int[] here = q.poll();
				for (int i = 0; i < 4; i++) {
					int x = here[0] + dx[i];
					int y = here[1] + dy[i];
					if (x < 0 || x >= R || y < 0 || y >= C || check[x][y])
						continue;
					if (board[x][y] == 1) {
						cheese--;
						board[x][y] = 0;
					} else {
						q.offer(new int[] { x, y });
					}
					check[x][y] = true;
				}
			}
		}
		System.out.println(time);
		System.out.println(left_cheese);
	}
}
