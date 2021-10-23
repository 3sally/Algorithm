import java.io.*;
import java.util.StringTokenizer;

public class BOJ_14719_빗물 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int R = Integer.parseInt(st.nextToken()); // 행
		int C = Integer.parseInt(st.nextToken()); // 열

		// 0 : 낫띵 1 : 벽, 2: 빗물
		int[][] board = new int[R][C];

		// 전체 다 빗물로 채움
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				board[i][j] = 2;
			}
		}

		st = new StringTokenizer(br.readLine(), " ");
		int[] walls = new int[C];
		// 벽 세워줌
		for (int i = 0; i < C; i++) {
			walls[i] = Integer.parseInt(st.nextToken());
			for (int j = R - 1; j > R - 1 - walls[i]; j--) {
				board[j][i] = 1;
			}
		}

		// 윗 줄부터 한 줄씩 보면서 1과 1 사이에 있는 빗물만 냅두기
		for (int i = 0; i < R; i++) {
			// 왼쪽
			int c = 0;
			while (board[i][c] != 1) {
				board[i][c++] = 0;
				if (c == C)
					break;
			}

			// 오른쪽
			c = C - 1;
			while (board[i][c] != 1) {
				board[i][c--] = 0;
				if (c < 0)
					break;
			}
		}

		// 빗물 얼마나 모아졌나요
		int rain = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (board[i][j] == 2)
					rain++;
			}
		}

		System.out.println(rain);
	}
}
